__author__ = 'robertsanders'

from pyspark import SparkConf, SparkContext
from pyspark.sql import SQLContext, HiveContext
import logging

APP_NAME = "TO-BE-COMPLETED"

if __name__ == "__main__":
    conf = SparkConf().setAppName(APP_NAME)
    sc = SparkContext(conf)
    sqlContext = HiveContext(sc)

