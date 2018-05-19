package com.example;

import scala.Tuple2;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.SparkSession;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

        System.out.println( "Hello World!" );
        SparkSession spark = SparkSession
                .builder()
                .appName("JavaWordCount")
                .master("local[*]")
                .getOrCreate();

        JavaRDD<String> lines = spark.read().textFile("/home/synerzip/IdeaProjects/sample/pom.xml").javaRDD();

        JavaRDD<String> words = lines.flatMap(s -> Arrays.asList(s.split(" ")).iterator());

        JavaPairRDD<String, Integer> ones = words.mapToPair(s -> new Tuple2<>(s, 1));

        JavaPairRDD<String, Integer> counts = ones.reduceByKey((i1, i2) -> i1 + i2);

        List<Tuple2<String, Integer>> output = counts.collect();
        for (Tuple2<?,?> tuple : output) {
            System.out.println(tuple._1() + ": " + tuple._2());
        }
        spark.stop();
    }
}
