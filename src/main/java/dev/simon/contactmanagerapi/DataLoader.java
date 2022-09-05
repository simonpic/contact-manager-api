package dev.simon.contactmanagerapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("dev")
public class DataLoader {

    private static final Logger LOG = LoggerFactory.getLogger(DataLoader.class);

    private final ContactService contactService;

    @Autowired
    public DataLoader(ContactService contactService) {
        this.contactService = contactService;
    }

    @EventListener
    public void loadContacts(ApplicationStartedEvent event) {
        LOG.info("Start loading contacts");

        Contact c1 = Contact.builder()
                .firstName("John")
                .lastName("Tolkien")
                .email("tolkien@inklings.com")
                .phoneNumber("867-5309")
                .build();

        Contact c2 = Contact.builder()
                .firstName("Clive")
                .lastName("Lewis")
                .email("lewis@inklings.com")
                .phoneNumber("867-5309")
                .build();

        Contact c3 = Contact.builder()
                .firstName("Owen")
                .lastName("Barfield")
                .email("barfield@inklings.com")
                .phoneNumber("867-5309")
                .build();

        Contact c4 = Contact.builder()
                .firstName("Charles")
                .lastName("Williams")
                .email("williams@inklings.com")
                .phoneNumber("867-5309")
                .build();

        Contact c5 = Contact.builder()
                .firstName("Roger")
                .lastName("Green")
                .email("green@inklings.com")
                .phoneNumber("867-5309")
                .build();

        Contact c6 = Contact.builder()
                .firstName("Simon")
                .lastName("Picard")
                .email("picardla@hotmail.fr")
                .phoneNumber("867-5309")
                .build();

        List.of(c1, c2, c3, c4, c5, c6).forEach(contactService::saveContact);

        LOG.info("Finished loading contacts");
    }

}
