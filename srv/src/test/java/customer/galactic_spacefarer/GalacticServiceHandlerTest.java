package customer.galactic_spacefarer;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;

import com.sap.cds.services.ServiceException;

import cds.gen.galacticservice.SpaceFarers;

@ExtendWith(MockitoExtension.class)
class GalacticServiceHandlerTest {

    @Mock
    private org.springframework.mail.javamail.JavaMailSender mailSender;

    @InjectMocks
    private GalacticServiceHandler handler;

    @Test
    void beforeCreateAcceptsValidSpacefarer() {
        SpaceFarers spacefarer = validSpacefarer();

        assertDoesNotThrow(() -> handler.beforeCreateSpacefarer(null, spacefarer));
    }

    @Test
    void beforeCreateRejectsSkillAboveMaximum() {
        SpaceFarers spacefarer = validSpacefarer();
        spacefarer.setWormholeNavigationSkill(101);

        ServiceException exception = assertThrows(
                ServiceException.class,
                () -> handler.beforeCreateSpacefarer(null, spacefarer));

        assertTrue(exception.getMessage().contains("between 0 and 100"));
    }

    @Test
    void afterCreateSendsWelcomeEmail() {
        SpaceFarers spacefarer = validSpacefarer();

        handler.afterCreateSpacefarer(null, spacefarer);

        ArgumentCaptor<SimpleMailMessage> messageCaptor = ArgumentCaptor.forClass(SimpleMailMessage.class);
        verify(mailSender).send(messageCaptor.capture());
        SimpleMailMessage message = messageCaptor.getValue();

        assertEquals("kaelen.voss@yopmail.com", message.getTo()[0]);
        assertEquals("Welcome to the Galactic Spacefarer!", message.getSubject());
    }

    private SpaceFarers validSpacefarer() {
        SpaceFarers spacefarer = SpaceFarers.create();
        spacefarer.setName("Kaelen Voss");
        spacefarer.setEmail("kaelen.voss@yopmail.com");
        spacefarer.setStarductCollection(1420);
        spacefarer.setWormholeNavigationSkill(87);
        return spacefarer;
    }
}