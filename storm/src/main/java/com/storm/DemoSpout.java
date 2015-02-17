package com.storm;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;

import java.util.Map;

/**
 * Created by deepak.barr on 17/2/15.
 */
public class DemoSpout extends BaseRichSpout {

    private SpoutOutputCollector collector;
    private static int currentNum=1;

    @Override
    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
        this.collector=spoutOutputCollector;
    }

    @Override
    public void nextTuple() {
        collector.emit( new Values(currentNum++));
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare( new Fields( "number" ) );
    }
}
