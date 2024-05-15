package com.usermanagement.controller;


import java.io.IOException;
import java.util.List;


import com.usermanagement.modelentity.Contact;
import com.usermanagement.repository.ContactRepository;
import com.usermanagement.service.ContactService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userApi")
@CrossOrigin(origins = {"http://localhost:3000", "https://shopwithzosh.vercel.app"})
public class ContactController {

    @Autowired
    private ContactService contactService;
    @Autowired
    private ContactRepository contactRepository;

    @PostMapping("/addContact")
    public ResponseEntity<String> submitContactForm(@Valid @RequestBody Contact contact) throws IOException {

        String fullName=contact.getFullName();
        String email = contact.getEmail();
        String message = contact.getMessage();

        Contact createdUser= new Contact();
        createdUser.setEmail(email);
        createdUser.setFullName(fullName);
        createdUser.setMessage(message);
//			createdUser.setLastName(lastName);
        //createdUser.setPassword(passwordEncoder.encode(password));
        //   createdUser.setRole(role);

        Contact savedContact= contactRepository.save(createdUser);
        //Contact savedContact = contactService.createContact(contact);
        if (savedContact != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Contact saved successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save contact");
        }
    }

//	        String lastName=user.getLastName();
//	        String role=user.getRole();

    //
//    @PostMapping("/submitContact")
//    public ResponseEntity<String> submitContactForm(@RequestParam("fullName") String fullName,
//                                                     @RequestParam("email") String email,
//                                                     @RequestParam("message") String message) {
//        // Create a new Contact object
//        Contact contact = new Contact();
//       // contact.setId(id);
//        contact.setFullName(fullName);
//        contact.setEmail(email);
//        contact.setMessage(message);
//
//        // Save contact data
//        Contact savedContact = contactService.createContact(contact);
//        if (savedContact != null) {
//            return ResponseEntity.status(HttpStatus.CREATED).body("Contact saved successfully");
//        } else {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save contact");
//        }
//    }
    @GetMapping("/getAllContacts")
    public ResponseEntity<List<Contact>> getAllContacts() {
        List<Contact> contacts = contactService.getAllContacts();
        return ResponseEntity.ok(contacts);
    }

    @GetMapping("getContactById/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
        Contact contact = contactService.getContactById(id);
        if (contact != null) {
            return ResponseEntity.ok(contact);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
//
}
