package dev.simon.contactmanagerapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public Contacts getContacts() {
        List<Contact> contacts = contactService.getContacts();
        return new Contacts(contacts);
    }

    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable("id") String id) {
        return contactService.getContactById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/search")
    public Contact searchContact(@RequestParam("firstName") String firstName) {
        if (firstName == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return contactService.searchContactByFirstName(firstName)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

}
