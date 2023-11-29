package com.yt.backend.service;

import com.yt.backend.model.Contact;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactService {
    Contact addContact(Contact contact);
    Contact getContactById(long id);
    List<Contact> getContact();
}
