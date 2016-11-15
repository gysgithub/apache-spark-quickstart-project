package com.github.rssanders3.spark.scala

import java.security.InvalidParameterException
import java.util


/**
 * Created by robertsanders on 11/14/16.
 */
object MainArgs {

  /**
   * https://softwaresanders.wordpress.com/2016/10/17/command-line-arguments-for-java-programs/
   *
   * spark-submit spark_quick_start-jar-with-dependencies.jar --arg1 test
   */

  val argsUsage = s"MainJobArgs Usage: \n" +
    s"\t[--arg1 <string> (required=true, description=Argument 1)]\n" +
    s"\n"


  case class JobArgs(arg1: String = null) {

    override def toString(): String = {
      s"MainJobArgs(\n" +
        s"arg1=$arg1, \n" +
        s")"
    }

    def validate(): Unit = {
      val invalidMessageList = new util.ArrayList[String]()

      if(arg1 == null) {
        invalidMessageList.add("--arg1 needs to be provided")
      }

      if (invalidMessageList.size() > 0) {
        throw new InvalidParameterException("Invalid Arguments: " + invalidMessageList)
      }
    }

  }

  /**
   * Parses the input arguments to
   *
   * @param args
   * @param jobArgs
   * @return JobArgs
   */
  def parseJobArgs(args: List[String], jobArgs: JobArgs = JobArgs()): JobArgs = {
    args.toList match {
      case Nil => jobArgs
      case "--arg1" :: value :: otherArgs => parseJobArgs(otherArgs, jobArgs.copy(arg1 = value))
      case option :: tail => println("Unknown option " + option); return null;
    }
  }


}
