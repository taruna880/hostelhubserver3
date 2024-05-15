package com.usermanagement.repository;

import com.usermanagement.modelentity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    //Contact save(Contact contact);
    // You can define additional query methods here if needed
}
