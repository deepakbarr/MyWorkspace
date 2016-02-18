package com.example.jpa;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by deepak.barr on 13/01/16.
 */

@Entity
@Table(name = "person")
public class Person {
  int id;
  String firstName;
  String lastName;

  public Person(int id, String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return "Person{" +
      "id=" + id +
      ", firstName='" + firstName + '\'' +
      ", lastName='" + lastName + '\'' +
      '}';
  }
}
