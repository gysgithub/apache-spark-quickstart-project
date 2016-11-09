package com.github.rssanders3.spark.scala

import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}


/**
 * Created by robertsanders on 11/9/16.
 */
object Main {

  val APP_NAME: String = "TO-BE-COMPLETED"

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName(APP_NAME)
    val sc = new SparkContext(conf)
    val sqlContext = new HiveContext(sc)


  }

}
