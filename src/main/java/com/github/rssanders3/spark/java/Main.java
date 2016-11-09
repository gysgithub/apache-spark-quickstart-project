package com.github.rssanders3.spark.java;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.hive.HiveContext;

/**
 * Created by robertsanders on 11/9/16.
 */
public class Main {

    private static String APP_NAME = "TO-BE-COMPLETED";

    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName(APP_NAME);
        JavaSparkContext sc = new JavaSparkContext(conf);
        SQLContext sqlContext = new HiveContext(sc);


    }

}
