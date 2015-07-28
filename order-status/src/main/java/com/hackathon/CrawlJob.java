package com.hackathon;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.mail.*;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Properties;

/**
 * Created by deepak.barr on 05/06/15.
 */


public class CrawlJob {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//    public void execute(JobExecutionContext jobContext) throws JobExecutionException {

    public static void main(String[] args) {






        DataManager.put("offset", "3430");
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect("imap.gmail.com", "deepak.barr@gmail.com", Constants.password);
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            int total = inbox.getMessageCount();
            int offset = Integer.parseInt(DataManager.get("offset"));

            Message[] msgs = inbox.getMessages(offset, total);

            if (total > offset) {
                for (Message msg : msgs) {
                    System.out.println("SUBJECT:" + msg.getSubject());
                    Order order = Crawler.fetchOrder(msg.getSubject());
                    if (null != order) {
                        order.setLastUpdated(dateFormat.format(msg.getSentDate()));
                        OrderManager.addOrder(order);
                    }
                }
                DataManager.put("offset", new Integer(total).toString());
            } else System.out.println("No new emails");

            OrderManager.printOrders();

        } catch (Exception mex) {
            mex.printStackTrace();
        }

    }
}