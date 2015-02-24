package com.workspace.demos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by deepak.barr on 23/2/15.
 */
public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Item item = new Item();
        item.setName("ipad");
        item.setPrice(20000);
        session.save(item);
        session.getTransaction().commit();
    }
}
