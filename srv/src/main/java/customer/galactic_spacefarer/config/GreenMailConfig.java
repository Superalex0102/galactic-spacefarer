package customer.galactic_spacefarer.config;

import org.springframework.context.annotation.Configuration;

import com.icegreen.greenmail.configuration.GreenMailConfiguration;
import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetup;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Configuration
public class GreenMailConfig {

    private GreenMail greenMail;

@PostConstruct
    public void startMailServer() {
        ServerSetup setup = new ServerSetup(3025, "127.0.0.1", ServerSetup.PROTOCOL_SMTP);
        greenMail = new GreenMail(setup);
        greenMail.withConfiguration(GreenMailConfiguration.aConfig().withDisabledAuthentication());
        greenMail.start();
        System.out.println(">>> Embedded Mock SMTP running on port 3025");
    }

    @PreDestroy
    public void stopMailServer() {
        if (greenMail != null) {
            greenMail.stop();
        }
        System.out.println(">>> Embedded Mock SMTP stopped");
    }
}
