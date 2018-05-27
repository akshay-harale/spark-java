package com.example.dataset;

import com.example.wordcount.SparkUtil;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.*;

public class RddToDataset {
    public static void main(String... args) {
        SparkSession spark = SparkUtil.getSparkSession("RDDtoDs", "local[*]");
        JavaRDD<Person> personJavaRDD = spark.read()
                .textFile("/home/synerzip/IdeaProjects/sample/src/main/resources/people.txt")
                .javaRDD()
                .map(line -> {
                    String[] split = line.split(",");
                    Person p = new Person();
                    p.setAge(Integer.parseInt(split[0]));
                    p.setName(split[1]);
                    return p;
                });
        Encoder<Person> personEncoder = Encoders.bean(Person.class);
        Dataset<Row> dataFrame = spark.createDataFrame(personJavaRDD, Person.class);

    }
}
