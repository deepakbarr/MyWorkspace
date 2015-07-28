    package com.hackathon;

    /**
     * Created by deepak.barr on 05/06/15.
     */

    import java.util.*;
    import java.util.concurrent.SynchronousQueue;
    import javax.mail.*;

    public class ReadEmail {

        public static void main(String[] args) {
            Properties props = new Properties();
            props.setProperty("mail.store.protocol", "imaps");
            try {
                Session session = Session.getInstance(props, null);
                Store store = session.getStore();
                store.connect("imap.gmail.com", "deepak.barr@gmail.com", Constants.password);
                Folder inbox = store.getFolder("INBOX");
                inbox.open(Folder.READ_ONLY);

                int count = inbox.getMessageCount();
                System.out.println(count);
                Message[] msgs = inbox.getMessages(count - 5, count);

                for (Message msg : msgs) {
                    Address[] in = msg.getFrom();
                    for (Address address : in) {
                        System.out.println("FROM:" + address.toString());
                    }
                    Multipart mp = (Multipart) msg.getContent();
                    BodyPart bp = mp.getBodyPart(0);
                    System.out.println("SENT DATE:" + msg.getSentDate());
                    System.out.println("SUBJECT:" + msg.getSubject());

                }
            } catch (Exception mex) {
                mex.printStackTrace();
            }

        }
    }