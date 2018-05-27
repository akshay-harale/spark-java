package com.example.dataset;

import com.example.wordcount.SparkUtil;
import org.apache.spark.sql.*;

import java.util.Collections;

public class DatasetExample {
    public static void main(String ... args){
        SparkSession spark = SparkUtil.getSparkSession("createDataset", "local[*]");
        Person person = new Person();
        person.setName("Andy");
        person.setAge(32);
        Encoder<Person> personEncoder = Encoders.bean(Person.class);
        Dataset<Person> dataset = spark.createDataset(Collections.singletonList(person), personEncoder);
        dataset.show();
        String jsonPath="/home/synerzip/IdeaProjects/sample/src/main/resources/people.json";
        Dataset<Row> jsonData = spark.read().json(jsonPath);
        jsonData.show();

    }
}
