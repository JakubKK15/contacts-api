package com.jakubk.contactsapi;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ContactRepository {

  @Autowired
  JdbcTemplate jdbcTemplate;

  public List<Contact> getAll() {
    return jdbcTemplate.query("SELECT * FROM contactlist",
        BeanPropertyRowMapper.newInstance(Contact.class));
  }

  public Contact getById(int id) {
    return jdbcTemplate.queryForObject("SELECT * FROM contactlist where id = ?",
        BeanPropertyRowMapper.newInstance(Contact.class), id);
  }

  public int addContacts(List<Contact> contacts) {
    contacts.forEach(contact -> jdbcTemplate.update(
        "INSERT INTO contactlist (`name`, email, address, phone)" + " VALUES (?, ?, ?, ?)",
        contact.getName(), contact.getEmail(), contact.getAddress(), contact.getPhone()));
    return 1;
  }

  public int addContact(Contact contact) {
    return jdbcTemplate.update(
        "INSERT INTO contactlist (`name`, email, address, phone)" + " VALUES (?, ?, ?, ?)",
        contact.getName(), contact.getEmail(), contact.getAddress(), contact.getPhone());

  }

  public int editContact(Contact contact) {
    return jdbcTemplate.update(
        "UPDATE contactlist SET `name`=?, email=?, address=?, phone=? WHERE id=?",
        contact.getName(), contact.getEmail(), contact.getAddress(), contact.getPhone(),
        contact.getId());
  }

  public int deleteContact(int id) {
    return jdbcTemplate.update("DELETE FROM contactlist WHERE id=?", id);
  }
}
