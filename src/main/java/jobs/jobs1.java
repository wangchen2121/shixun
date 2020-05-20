package jobs;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;

import java.util.Arrays;
import java.util.Iterator;

public class jobs1 {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("jobs1").setMaster("local");
        JavaSparkContext jsc = new JavaSparkContext(conf);
        JavaRDD<String> javaRDD = jsc.textFile("E:/1026653290/任务/jobs1.jobs.csv");
        JavaRDD<String> flatMap = javaRDD.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public Iterator<String> call(String s) throws Exception {
                return Arrays.asList(s).iterator();
            }
        });
        flatMap.distinct().saveAsTextFile("E:/1026653290/任务/jobs/jobs1/input/xxx");
    }
}
