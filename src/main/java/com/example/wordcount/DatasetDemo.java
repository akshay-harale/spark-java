package com.example.wordcount;

import org.apache.spark.api.java.function.FilterFunction;
import static org.apache.spark.sql.functions.col;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;

public class DatasetDemo {
    public static void main(String... args) {

        Logger.getLogger("org").setLevel(Level.WARN);
        Logger.getLogger("akka").setLevel(Level.WARN);
        String logFile = "/home/synerzip/IdeaProjects/sample/src/main/resources/people.json";
        SparkSession sparkSession = SparkUtil.getSparkSession("DataSetExample", "local[*]");
//        Dataset<String> logData = sparkSession.read().textFile(logFile)
//                .cache();
//        long numsA=logData.filter((FilterFunction<String>) s -> s.contains("a")).count();
//        long numsb=logData.filter((FilterFunction<String>)s -> s.contains("b")).count();
//        System.out.println("Lines with a: " + numsA + ", lines with b: " + numsb);
        Dataset<Row> jsonDf = sparkSession.read().json(logFile);
//        jsonDf.show();
//        jsonDf.printSchema();
//        jsonDf.select("name").show();
//        jsonDf.select(col("name")).show();
//        jsonDf.groupBy(col("name")).count().show();

        /**
         * sql programming
         */
        // register the dataframe as sql view
        jsonDf.createOrReplaceTempView("people");
        Dataset<Row> sql = sparkSession.sql("select * from people");
        sql.show();
        sparkSession.stop();
    }
}
