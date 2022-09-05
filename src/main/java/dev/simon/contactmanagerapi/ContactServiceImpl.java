package dev.simon.contactmanagerapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    private static int id = 1;

    private final ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> getContacts() {
        return contactRepository.getContacts();
    }

    @Override
    public Optional<Contact> getContactById(String id) {
        return contactRepository.getContactById(Integer.parseInt(id));
    }

    @Override
    public Contact saveContact(Contact contact) {
        contact.setId(id++);
        contactRepository.saveContact(contact);
        return contact;
    }

    @Override
    public Optional<Contact> searchContactByFirstName(String firstName) {
        return contactRepository.searchContactByFirstName(firstName);
    }


}
