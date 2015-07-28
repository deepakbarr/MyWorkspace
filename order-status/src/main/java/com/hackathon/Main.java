package com.hackathon;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

import javax.xml.crypto.Data;
import java.text.ParseException;

/**
 * Created by deepak.barr on 05/06/15.
 */
public class Main {

    public static void main(String[] args) {

        try {

            DataManager.put("offset", "3420");


            Scheduler scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.start();

            JobDetail job = new JobDetail();
            job.setName("Email Crawl Job");
            job.setJobClass(CrawlJob.class);

            CronTrigger trigger = new CronTrigger();
            String cropExp = "0 0/3 * * * ?";
            trigger.setCronExpression(cropExp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
