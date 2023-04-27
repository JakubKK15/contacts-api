package com.jakubk.contactsapi;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
public class Contact {
  private int id;
  private String address;
  private String email;
  private String name;
  private String phone;
}
