package com.github.rssanders3.spark.java;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

/**
 * Created by robertsanders on 11/14/16.
 */
public class MainArgs {

    /**
     * https://softwaresanders.wordpress.com/2016/10/17/command-line-arguments-for-java-programs/
     *
     * spark-submit spark_quick_start-jar-with-dependencies.jar --arg1 test
     */

    @Option(name="-arg1", usage="Argument 1", required = true)
    private String arg1;

    public MainArgs(String... args) throws CmdLineException {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            parser.printUsage(System.err);
            throw e;
        }
    }

    public String getArg1() {
        return arg1;
    }

    public void setArg1(String arg1) {
        this.arg1 = arg1;
    }

    @Override
    public String toString() {
        return "MainArgs{" +
                "arg1='" + arg1 + '\'' +
                '}';
    }

}
