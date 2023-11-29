package com.yt.backend.service.impl;

import com.yt.backend.model.Contact;
import com.yt.backend.repository.ContactRepository;
import com.yt.backend.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;
    @Override
    public Contact addContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact getContactById(long id) {
        return contactRepository.findById(id).get();
    }

    @Override
    public List<Contact> getContact() {
        return (List<Contact>) contactRepository.findAll();
    }
}
