package dev.simon.contactmanagerapi;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ContactServiceTest {

    @Mock
    private ContactRepository contactRepository;

    @InjectMocks
    private ContactServiceImpl contactService;

    @Test
    public void getContactById_returnsOptionalWithContact() {
        Contact contact = new Contact();
        when(contactRepository.getContactById(1)).thenReturn(Optional.of(contact));

        Optional<Contact> contactOpt = contactService.getContactById("1");

        assertThat(contactOpt).contains(contact);
    }

    @Test
    public void getContactById_returnsEmptyOptional() {
        when(contactRepository.getContactById(1)).thenReturn(Optional.empty());

        Optional<Contact> contactOpt = contactService.getContactById("1");

        assertThat(contactOpt).isEmpty();
    }

    @Test
    public void failingTest() {
        assertThat(1).isEqualTo(2);
    }

}
