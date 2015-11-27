package spark.hive;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.hive.HiveContext;

/**
 * Created by deepak.barr on 20/10/15.
 */
public class HiveSparkIntegration {

  public static void main(String[] args) {
    SparkConf sparkConf=new SparkConf();
    sparkConf.setAppName("contextja").setMaster("local[1]").set("spark.executor.memory","1g");
    JavaSparkContext javaSparkContext=new JavaSparkContext(sparkConf);
    HiveContext hiveContext=new HiveContext(javaSparkContext.sc());
    DataFrame df=hiveContext.sql("select * from test_data");
    long count=df.count();
    System.out.println("count = " + count);
  }
}
