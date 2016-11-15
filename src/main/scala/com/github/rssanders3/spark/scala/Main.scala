package com.github.rssanders3.spark.scala

import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}


/**
 * Created by robertsanders on 11/9/16.
 */
object Main {

  val APP_NAME: String = "TO-BE-COMPLETED"

  def main(args: Array[String]): Unit = {

    if (args.contains("-help") || args.contains("--help")) {
      println(MainArgs.argsUsage)
      System.exit(-1)
    }

    val jobArgs = MainArgs.parseJobArgs(args.toList)
    if (jobArgs == null) {
      println(MainArgs.argsUsage)
      System.exit(-1)
    }

    jobArgs.validate()
    println(jobArgs)

    val conf = new SparkConf().setAppName(APP_NAME)
    val sc = new SparkContext(conf)
    val sqlContext = new HiveContext(sc)


  }

}
