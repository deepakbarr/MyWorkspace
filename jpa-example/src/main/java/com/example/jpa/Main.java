package com.example.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 */
public class Main {
  private static final String PERSISTENCE_UNIT = "Simplest";


  private static EntityManagerFactory createFactory() {
    return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
  }

  public static void main(String[] args) {
    EntityManager em = createFactory().createEntityManager();
//    em.getTransaction().begin();
    Person p = em.find(Person.class, 1);

    System.out.println("p = " + p);
    em.close();
//    em.persist(new Person(id,"d","b"));
//    em.getTransaction().commit();
  }
}
