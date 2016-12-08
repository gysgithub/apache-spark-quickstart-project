package com.github.rssanders3.spark.scala

import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}
import org.slf4j.{Logger, LoggerFactory}


/**
 * Created by robertsanders on 11/9/16.
 */
object Main {

  val LOGGER: Logger = LoggerFactory.getLogger(Main.getClass.getName)

  val APP_NAME: String = "TO-BE-COMPLETED"

  def main(args: Array[String]): Unit = {

    //if arguments include -help or --help then print Argument Usage
    if (args.contains("-help") || args.contains("--help")) {
      LOGGER.info(MainArgs.argsUsage)
      System.exit(0)
    }

    val jobArgs = MainArgs.parseJobArgs(args.toList)
    if (jobArgs == null) {
      LOGGER.error("")
      LOGGER.info(MainArgs.argsUsage)
      System.exit(-1)
    }

    jobArgs.validate()
    LOGGER.info(jobArgs.toString())

    val conf = new SparkConf().setAppName(APP_NAME)
    val sc = new SparkContext(conf)
    val sqlContext = new HiveContext(sc)


  }

}
