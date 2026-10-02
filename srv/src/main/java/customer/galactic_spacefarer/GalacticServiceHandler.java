package customer.galactic_spacefarer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.sap.cds.services.cds.CdsCreateEventContext;
import com.sap.cds.services.cds.CqnService;
import com.sap.cds.services.handler.EventHandler;
import com.sap.cds.services.handler.annotations.After;
import com.sap.cds.services.handler.annotations.Before;
import com.sap.cds.services.handler.annotations.ServiceName;
import com.sap.cds.services.ErrorStatuses;
import com.sap.cds.services.ServiceException;

import cds.gen.galacticservice.GalacticService_;
import cds.gen.galacticservice.SpaceFarers;
import cds.gen.galacticservice.SpaceFarers_;

@Component
@ServiceName(GalacticService_.CDS_NAME)
public class GalacticServiceHandler implements EventHandler {
    @Autowired
    private JavaMailSender mailSender;

    @Before(event = { CqnService.EVENT_CREATE }, entity = SpaceFarers_.CDS_NAME)
    public void beforeCreateSpacefarer(CdsCreateEventContext context, SpaceFarers spacefarer) {
        if (spacefarer.getName() == null || spacefarer.getName().isEmpty()) {
            throw new ServiceException(ErrorStatuses.BAD_REQUEST, "Spacefarer name cannot be null or empty");
        }

        if (spacefarer.getStarductCollection() == null || spacefarer.getStarductCollection() < 0) {
            throw new ServiceException(ErrorStatuses.BAD_REQUEST, "Starduct collection must be a non-negative integer");
        }

        if (spacefarer.getWormholeNavigationSkill() == null || spacefarer.getWormholeNavigationSkill() < 0 || spacefarer.getWormholeNavigationSkill() > 100) {
            throw new ServiceException(ErrorStatuses.BAD_REQUEST, "Wormhole navigation skill must be a non-negative integer between 0 and 100");
        }

        // enhance
        int stardust = spacefarer.getStarductCollection();
        int skill = spacefarer.getWormholeNavigationSkill();

        int stardustBonus = Math.max(1, skill / 10);
        long enhancedStardust = (long) stardust + stardustBonus;

        if (enhancedStardust > Integer.MAX_VALUE) {
            throw new ServiceException(
                ErrorStatuses.BAD_REQUEST,
                "Stardust collection is too large");
        }

        spacefarer.setStarductCollection((int) enhancedStardust);
        spacefarer.setWormholeNavigationSkill(Math.min(100, skill + 1));
    }

    @After(event = { CqnService.EVENT_CREATE }, entity = SpaceFarers_.CDS_NAME)
    public void afterCreateSpacefarer(CdsCreateEventContext context, SpaceFarers spacefarer) {
        if (spacefarer.getEmail() == null || spacefarer.getEmail().isEmpty()) {
            throw new ServiceException(ErrorStatuses.BAD_REQUEST, "Spacefarer email cannot be null or empty");
        }

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@example.com");
        message.setTo(spacefarer.getEmail());
        message.setSubject("Welcome to the Galactic Spacefarer!");
        message.setText("Dear " + spacefarer.getName() + ",\n\nWelcome to the Galactic Spacefarer! We are excited to have you on board.\n\nBest regards,\nThe Galactic Spacefarer Team");

        mailSender.send(message);
    }
}
