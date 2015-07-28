package spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import spark.dto.Employee;

/**
 * Created by deepak.barr on 10/05/15.
 */
public class Aggregations {

    private static String input = "/Users/deepak.barr/coderep/MyWorkspace/spark-demo/src/main/files/filter/input/input.txt";
    private static String output = "/Users/deepak.barr/coderep/MyWorkspace/spark-demo/src/main/files/output";

    private static String inputHDFS = "/user/spark/sum/input/input.txt";
    private static String outputHDFS = "/user/spark/sum/output";

    private static boolean useHadoop = true;


    public static void main(String[] args) {

        JavaSparkContext sparkContext = new JavaSparkContext(new SparkConf());

        JavaRDD<String> file = sparkContext.textFile(useHadoop ? inputHDFS : input);

        JavaRDD<Employee> empRDD = file.map(new Function<String, Employee>() {
            public Employee call(String s) throws Exception {
                String[] tokens = s.split(",");
                Employee e = new Employee(tokens[0], tokens[1], Long.parseLong(tokens[2]));
                return e;
            }
        });

        JavaRDD<Employee> hrEmp = empRDD.filter(new Function<Employee, Boolean>() {
            public Boolean call(Employee employee) throws Exception {
                return employee.getDept().equals("HR");
            }
        });

        hrEmp.saveAsTextFile(useHadoop?outputHDFS:output);
    }
}
