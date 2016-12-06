__author__ = 'robertsanders'

from pyspark import SparkConf, SparkContext
from pyspark.sql import SQLContext
import unittest


class MainTest(unittest.TestCase):

    master = "local[2]"

    conf = SparkConf().setAppName(__name__).setMaster(master)
    sc = None
    sqlContext = None

    @staticmethod
    def setUp(**kwargs):
        sc = SparkContext(conf)
        sqlContext = SQLContext(sc)

    @staticmethod
    def tearDown(**kwargs):
        if sc != None:
            sc.stop()
            sc = None

    def test_contexts_not_none(self):
        self.assertNotEquals(None, sc)
        self.assertNotEquals(None, sqlContext)

if __name__ == '__main__':
    unittest.main()