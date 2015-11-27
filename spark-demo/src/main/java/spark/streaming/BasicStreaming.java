//package spark.streaming;
//
//import org.apache.spark.SparkConf;
//import org.apache.spark.api.java.function.FlatMapFunction;
//import org.apache.spark.api.java.function.Function;
//import org.apache.spark.examples.streaming.StreamingExamples;
//import org.apache.spark.streaming.Durations;
//import org.apache.spark.streaming.api.java.JavaDStream;
//import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
//import org.apache.spark.streaming.api.java.JavaStreamingContext;
//
//import java.util.Arrays;
//
///**
// * Created by deepak.barr on 10/05/15.
// */
//public class BasicStreaming {
//    public static void main(String[] args) throws InterruptedException {
//
//        StreamingExamples.setStreamingLogLevels();
//        SparkConf conf = new SparkConf().setMaster("local[5]").setAppName("NetworkWordCount");
//        conf.setSparkHome(System.getenv("SPARK_HOME"));
//        JavaStreamingContext jssc = new JavaStreamingContext(conf, Durations.seconds(5));
//
//        JavaReceiverInputDStream<String> lines = jssc.socketTextStream("localhost", 9090);
//
//        JavaDStream<String> words = lines.flatMap(
//                new FlatMapFunction<String, String>() {
//                    public Iterable<String> call(String x) {
//                        return Arrays.asList(x.split(" "));
//                    }
//                });
//
////        JavaDStream<String> filtered = words.filter(new Function<String, Boolean>() {
////            public Boolean call(String s) throws Exception {
////                return s.contains("s");
////            }
////        });
////
//       words.print();
//
//        jssc.start();
//        Thread.sleep(100000);
//        jssc.stop();
//    }
//}
