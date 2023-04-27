package com.jakubk.contactsapi;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacts")
public class ContactController {

  @Autowired
  ContactRepository contactRepository;

  @GetMapping("")
  public List<Contact> getAll() {
    return contactRepository.getAll();
  }

  @GetMapping("/{id}")
  public Contact getById(@PathVariable("id") int id) {
    return contactRepository.getById(id);
  }

  @PutMapping("/add/multiple")
  public int addContacts(@RequestBody List<Contact> contacts) {
    return contactRepository.addContacts(contacts);
  }

  @PutMapping("/add")
  public int addContact(@RequestBody Contact contact) {
    return contactRepository.addContact(contact);
  }

  @PatchMapping("/{id}")
  public int editContact(@PathVariable("id") int id, @RequestBody Contact updatedContact) {
    Contact contact = contactRepository.getById(id);

    if (contact != null) {
      if (updatedContact.getName() != null) {
        contact.setName(updatedContact.getName());
      }
      if (updatedContact.getEmail() != null) {
        contact.setEmail(updatedContact.getEmail());
      }
      if (updatedContact.getAddress() != null) {
        contact.setAddress(updatedContact.getAddress());
      }
      if (updatedContact.getPhone() != null) {
        contact.setPhone(updatedContact.getPhone());
      }
      contactRepository.editContact(contact);
      return 1;
    } else {
      return -1;
    }
  }


  @DeleteMapping("/{id}")
  public int delete(@PathVariable("id") int id) {
    return contactRepository.deleteContact(id);
  }
}
