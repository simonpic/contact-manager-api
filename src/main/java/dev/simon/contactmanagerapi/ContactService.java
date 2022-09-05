package dev.simon.contactmanagerapi;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    List<Contact> getContacts();
    Optional<Contact> getContactById(String id);
    Contact saveContact(Contact contact);
    Optional<Contact> searchContactByFirstName(String firstName);
}
