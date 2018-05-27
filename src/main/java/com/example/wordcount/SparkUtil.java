package com.example.wordcount;

import org.apache.spark.sql.SparkSession;

public class SparkUtil {
    public static SparkSession getSparkSession(String appName,String master){
        SparkSession spark = SparkSession
                .builder()
                .appName("JavaWordCount")
                .master("local[*]")
                .getOrCreate();
        return spark;
    }
}
