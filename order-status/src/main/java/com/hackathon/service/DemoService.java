package com.hackathon.service;


import com.hackathon.CrawlJob;
import com.hackathon.Main;
import com.hackathon.service.DemoServiceConfiguration;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


/**
 * Created by deepak.barr on 19/2/15.
 */

public class DemoService extends Application<DemoServiceConfiguration> {

    public static void main(String[] args) throws Exception {
        //Can load properties file, cache loaders, workflows schedulars , crons etc etc
        new DemoService().run(args);
    }

    @Override
    public void initialize(Bootstrap<DemoServiceConfiguration> bootstrap) {
    }

    @Override
    public void run(DemoServiceConfiguration conf, Environment env) throws Exception {
        DemoResource resource = new DemoResource(conf);
        env.jersey().register(resource);
        CrawlJob.main(null);
    }


}