package spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.util.Arrays;

/**
 * Created by deepak.barr on 9/2/15.
 */
public class WordCount {

    private static String input = "/Users/deepak.barr/coderep/MyWorkspace/spark-demo/src/main/files/wc/input/input.txt";
    private static String output = "/Users/deepak.barr/coderep/MyWorkspace/spark-demo/src/main/files/wc/output";

    private static String inputHDFS = "/user/spark/wc/input/input.txt";
    private static String outputHDFS = "/user/spark/wc/output";

    private static boolean useHadoop=true;


    public static void main(String[] args) {

//        SparkConf sparkConf=new SparkConf();

        JavaSparkContext spark=new JavaSparkContext(new SparkConf());
//        JavaSparkContext spark = new JavaSparkContext("local[1]",
//                "Java Wordcount", System.getenv("SPARK_HOME"),
//                JavaSparkContext.jarOfClass(WordCount.class));


        JavaRDD<String> file = spark.textFile(useHadoop?inputHDFS:input);

        JavaRDD<String> words = file.flatMap(new FlatMapFunction<String, String>() {
            public Iterable<String> call(String s) {
                return Arrays.asList(s.split(" "));
            }
        });
        JavaPairRDD<String, Integer> pairs = words.mapToPair(new PairFunction<String, String, Integer>() {
            public Tuple2<String, Integer> call(String s) {
                return new Tuple2<String, Integer>(s, 1);
            }
        });
        JavaPairRDD<String, Integer> counts = pairs.reduceByKey(new Function2<Integer, Integer, Integer>() {
            public Integer call(Integer a, Integer b) {
                return a + b;
            }
        });
        counts.saveAsTextFile(useHadoop?outputHDFS:output);
    }
}