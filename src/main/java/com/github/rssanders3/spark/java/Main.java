package com.github.rssanders3.spark.java;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.hive.HiveContext;
import org.kohsuke.args4j.CmdLineException;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by robertsanders on 11/9/16.
 */
public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    private static String APP_NAME = "TO-BE-COMPLETED";

    public static void main(String[] args) throws CmdLineException {

        //if arguments include -help or --help then print Argument Usage
        List argsList = Arrays.asList(args);
        if(argsList.contains("-help") || argsList.contains("--help")) {
            new MainArgs().printUsage();
            System.exit(0);
        }

        MainArgs mainArgs = new MainArgs(args);
        System.out.println(mainArgs);

        SparkConf conf = new SparkConf().setAppName(APP_NAME);
        JavaSparkContext sc = new JavaSparkContext(conf);
        SQLContext sqlContext = new HiveContext(sc);


    }

}
