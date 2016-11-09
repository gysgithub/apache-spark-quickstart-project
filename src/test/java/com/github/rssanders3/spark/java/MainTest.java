package com.github.rssanders3.spark.java;

import junit.framework.TestCase;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

/**
 * Created by robertsanders on 11/9/16.
 */
public class MainTest extends TestCase {

    private String master = "local[2]";
    private String appName = this.getClass().getSimpleName();

    private SparkConf conf = new SparkConf().setMaster(master).setAppName(appName);

    private JavaSparkContext sc;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        sc = new JavaSparkContext(conf);
    }

    @Override
    protected void tearDown() throws Exception {
        if (sc != null) {
            sc.stop();
            sc = null;
        }
        super.tearDown();
    }

    public void test() {
        //Main.{your_function}
        assertTrue(true);
    }

}
