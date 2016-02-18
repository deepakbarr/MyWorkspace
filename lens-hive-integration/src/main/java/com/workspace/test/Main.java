package com.workspace.test;

import java.util.Map;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hive.service.cli.HiveSQLException;
import org.apache.hive.service.cli.ICLIService;
import org.apache.hive.service.cli.SessionHandle;

import com.google.common.collect.Maps;

/**
 * Created by deepak.barr on 29/12/15.
 */
public class Main {

  static final String QUERY = "select count(*) from default.test_data_big limit 33";
  static final String USER = "deepak.barr";

  static RemoteThriftConnection tconn = null;

  public static void main(String[] args) throws HiveSQLException, InterruptedException {
    init();
    SessionHandle session=getSession();
    getClient().executeStatementAsync(session, QUERY, getConf());
    getClient().closeSession(session);
    Thread.sleep(2000);
    System.out.println("Closed session");
  }

  private static SessionHandle getSession() throws HiveSQLException {
    return getClient().openSession(USER, "", getConf());
  }

  private static ICLIService getClient() throws HiveSQLException {
    return tconn.getClient();
  }

  private static void init() {
    HiveConf conf=new HiveConf();
    conf.addResource(new Path("/Users/deepak.barr/Softwares/hadoop-2.6.0/etc/hadoop/core-site.xml"));
    conf.addResource(new Path("/Users/deepak.barr/coderep/hive-source/hive/packaging/target/apache-hive-2.1.0-SNAPSHOT-bin/apache-hive-2.1.0-SNAPSHOT-bin/conf/hive-site.xml"));
    conf.set("hive.server2.thrift.bind.host","localhost");
    conf.set("hive.server2.thrift.port","10000");
    conf.set("hive.server2.enable.doAs","true");
    conf.set("hive.server2.authentication","NONE");
    conf.set("hadoop.proxyuser.hive.groups","*");
    conf.set("hadoop.proxyuser.hive.hosts","*");
    conf.set("hadoop.proxyuser.root.groups", "*");
    conf.set("hadoop.proxyuser.root.hosts", "*");
    conf.set("hadoop.proxyuser.fk-dp-test.groups", "*");
    conf.set("hadoop.proxyuser.fk-dp-test.hosts", "*");
    tconn = new RemoteThriftConnection();
    tconn.init(conf, USER);
  }

  private static Map<String, String> getConf() {
    Map<String,String> conf=Maps.newHashMap();
    conf.put("hive.server2.thrift.bind.host", "localhost");
    conf.put("hive.server2.thrift.port", "10000");
    conf.put("hive.server2.enable.doAs", "true");
    conf.put("hive.server2.authentication", "NONE");
    conf.put("hadoop.proxyuser.hive.groups", "*");
    conf.put("hadoop.proxyuser.hive.hosts", "*");
    conf.put("hadoop.proxyuser.root.groups", "*");
    conf.put("hadoop.proxyuser.root.hosts", "*");
    conf.put("hadoop.proxyuser.fk-dp-test.groups", "*");
    conf.put("hadoop.proxyuser.fk-dp-test.hosts", "*");
    return conf;
  }
}
