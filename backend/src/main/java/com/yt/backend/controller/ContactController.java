package com.yt.backend.controller;

import com.yt.backend.model.Comment;
import com.yt.backend.model.Contact;
import com.yt.backend.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @PostMapping("/contacts/add")
    public String addContact(@RequestBody Contact contact){
        contactService.addContact(contact);
        return "Contact added successfully..";
    }
    @RequestMapping("/contacts/{id}")
    public Contact getContactById(@PathVariable("id") String id) {
        long contactId = Long.parseLong(id);
        return contactService.getContactById(contactId);
    }
    @RequestMapping("/contacts")
    public List<Contact> getContact(){return contactService.getContact();}

}
