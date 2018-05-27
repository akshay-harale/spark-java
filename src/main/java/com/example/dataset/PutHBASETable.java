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
//import org.apache.spark.sql.SQLContext;
//import org.apache.spark.sql.SparkSession;
//import scala.Tuple2;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//public class PutHBASETable {
//    public static void main(String ... args){
//        SparkConf spconf = new SparkConf();
//        spconf.setMaster("local[2]");
//        spconf.setAppName("HBase");
//        JavaSparkContext jsc = new JavaSparkContext(spconf);
//        //sqlContext.read()
//        Configuration conf = HBaseConfiguration.create();
//        conf.set("hbase.master", "localhost:60000");
//        conf.setInt("timeout", 120000);
////        conf.set("hbase.zookeeper.quorum", "localhost");
//        //conf.set("zookeeper.znode.parent", "/hbase-unsecure");
//        conf.set(TableInputFormat.INPUT_TABLE, "test");
//        JavaHBaseContext hbaseContext = new JavaHBaseContext(jsc, conf);
//
//        List<byte[]> list = new ArrayList<>();
//        list.add(Bytes.toBytes("1"));
//
//        list.add(Bytes.toBytes("5"));
//
//        JavaRDD<byte[]> rdd = jsc.parallelize(list);
//
//        hbaseContext.foreachPartition(rdd,
//                new VoidFunction<Tuple2<Iterator<byte[]>, Connection>>() {
//                    public void call(Tuple2<Iterator<byte[]>, Connection> t)
//                            throws Exception {
//                        Table table = t._2().getTable(TableName.valueOf("nos"));
//                        BufferedMutator mutator = t._2().getBufferedMutator(TableName.valueOf("nos"));
//                        while (t._1().hasNext()) {
//                            byte[] b = t._1().next();
//                            Result r = table.get(new Get(b));
//                            if (r.getExists()) {
//                                mutator.mutate(new Put(b));
//                            }
//                        }
//
//                        mutator.flush();
//                        mutator.close();
//                        table.close();
//                    }
//                });
//
//
//    }
//
//}
