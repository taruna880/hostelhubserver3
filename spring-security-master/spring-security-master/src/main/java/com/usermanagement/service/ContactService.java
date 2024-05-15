package com.usermanagement.service;

import com.usermanagement.modelentity.Contact;

import java.util.List;

public interface ContactService {
    Contact createContact(Contact contact);
    List<Contact> getAllContacts();
    Contact getContactById(Long id);
}
