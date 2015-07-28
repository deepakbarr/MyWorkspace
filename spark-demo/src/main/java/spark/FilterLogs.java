package spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.util.Arrays;

/**
 * Created by deepak.barr on 9/2/15.
 */
public class FilterLogs {

    private static String input = "/Users/deepak.barr/coderep/MyWorkspace/spark-demo/src/main/files/filter/input/input.txt";
    private static String output = "/Users/deepak.barr/coderep/MyWorkspace/spark-demo/src/main/files/output";

    private static String inputHDFS = "/user/spark/filter/input/input.txt";
    private static String outputHDFS = "/user/spark/filter/output";

    private static boolean useHadoop = true;


    public static void main(String[] args) {

        JavaSparkContext sparkContext = new JavaSparkContext(new SparkConf());
//        JavaSparkContext spark = new JavaSparkContext("local[1]",
//                "Java Wordcount", System.getenv("SPARK_HOME"),
//                JavaSparkContext.jarOfClass(WordCount.class));

        JavaRDD<String> logs = sparkContext.textFile(useHadoop ? inputHDFS : input);
        JavaRDD<String> filteredLogs = logs.filter(new Function<String, Boolean>() {
            public Boolean call(String s) throws Exception {
                return s.contains("INFO");
            }
        });
        filteredLogs.saveAsTextFile(useHadoop ? outputHDFS : output);
    }
}