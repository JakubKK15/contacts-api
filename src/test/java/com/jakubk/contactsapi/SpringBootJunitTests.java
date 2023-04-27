package com.jakubk.contactsapi;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringBootJunitTests {

  @Autowired
  ContactRepository contactRepository;

  @Test
  public void getAll() {
    List<Contact> contacts = contactRepository.getAll();
    assert contacts.size() > 0;
  }

  @Test
  public void getById() {
    contactRepository.getById(11);
  }

  @Test
  public void testAddContact() {
    Contact contact = new Contact();
    contact.setId(1);
    contact.setName("test");
    contact.setEmail("test.test@gmail.com");
    contact.setAddress("dummy address");
    contact.setPhone("24092404");
  }

  @Test
  public void testEditContact() {
    Contact contact = new Contact();
    contact.setId(1);
    contact.setName("test");
    contact.setEmail("test.test@gmail.com");
    contact.setAddress("dummy address");
    contact.setPhone("24092404");

    contactRepository.editContact(contact);
  }

  @Test
  public void testDelete() {
    contactRepository.deleteContact(1);
  }

}
