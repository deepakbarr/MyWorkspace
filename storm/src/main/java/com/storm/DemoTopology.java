package com.storm;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.utils.Utils;

/**
 * Created by deepak.barr on 17/2/15.
 */
public class DemoTopology {

    public static void main(String[] args) {

        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout("spout", new DemoSpout());
        builder.setBolt("bolt5", new DemoBolt()).shuffleGrouping("spout");
        builder.setBolt("bolt10", new DemoBolt2()).shuffleGrouping("bolt5");

        Config conf = new Config();
        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("test", conf, builder.createTopology());
        Utils.sleep(10000);
        cluster.killTopology("test");
        cluster.shutdown();
    }
}
