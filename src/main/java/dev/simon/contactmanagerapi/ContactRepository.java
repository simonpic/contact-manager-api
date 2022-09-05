package dev.simon.contactmanagerapi;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContactRepository {

    private final List<Contact> contacts = new ArrayList<>();

    public List<Contact> getContacts() {
        return contacts;
    }

    public Optional<Contact> getContactById(int id) {
        return contacts.stream().filter(contact -> contact.getId() == id).findFirst();
    }

    public Contact saveContact(Contact contact) {
        this.contacts.add(contact);
        return contact;
    }

    public Optional<Contact> searchContactByFirstName(String firstName) {
        return contacts.stream().filter(contact -> firstName.equals(contact.getFirstName())).findFirst();
    }
}
