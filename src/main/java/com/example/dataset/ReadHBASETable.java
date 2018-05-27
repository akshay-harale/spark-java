//package com.example.dataset;
//
//import com.example.wordcount.SparkUtil;
//import org.apache.hadoop.conf.Configuration;
//import org.apache.hadoop.hbase.HBaseConfiguration;
//import org.apache.hadoop.hbase.TableName;
//import org.apache.hadoop.hbase.client.*;
//import org.apache.hadoop.hbase.mapreduce.TableInputFormat;
//import org.apache.hadoop.hbase.spark.JavaHBaseContext;
//import org.apache.hadoop.hbase.util.Bytes;
//import org.apache.spark.SparkConf;
//import org.apache.spark.api.java.JavaRDD;
//import org.apache.spark.api.java.JavaSparkContext;
//import org.apache.spark.api.java.function.VoidFunction;
//import org.apache.spark.sql.Dataset;
//import org.apache.spark.sql.Row;
//import org.apache.spark.sql.SQLContext;
//import org.apache.spark.sql.SparkSession;
//import org.apache.spark.sql.datasources.hbase.HBaseTableCatalog;
//import scala.Tuple2;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//public class ReadHBASETable {
//    public static void main(String ... args){
//        String catlog="{\n" +
//                "       \"table\":{\"namespace\":\"default\", \"name\":\"table1\"},\n" +
//                "       \"rowkey\":\"key\",\n" +
//                "       \"columns\":{\n" +
//                "         \"col0\":{\"cf\":\"rowkey\", \"col\":\"key\", \"type\":\"string\"},\n" +
//                "         \"col1\":{\"cf\":\"a\", \"col\":\"col1\", \"type\":\"string\"},\n" +
//                "         \"col2\":{\"cf\":\"b\", \"col\":\"col2\", \"type\":\"string\"}\n" +
//                "       }\n" +
//                "     }";
//        SparkSession app = SparkUtil.getSparkSession("app", "local[*]");
//        Dataset<Row> test = app.read()
//                .option(HBaseTableCatalog.tableCatalog(), catlog)
//                .format("org.apache.hadoop.hbase.spark")
//                .load();
//        test.show();
//
//    }
//
//}
