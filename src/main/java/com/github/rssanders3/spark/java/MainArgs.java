package com.github.rssanders3.spark.java;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;

/**
 * Created by robertsanders on 11/14/16.
 */
public class MainArgs {

    /**
     * https://softwaresanders.wordpress.com/2016/10/17/command-line-arguments-for-java-programs/
     *
     * spark-submit spark_quick_start-jar-with-dependencies.jar --arg1 test
     */

    private static final Logger LOGGER = LoggerFactory.getLogger(MainArgs.class);

    private CmdLineParser parser;

    private static final String ARG2_DEFAULT = "DEFAULT_VALUE";

    @Option(name="-arg1", usage="Argument 1", required = true)
    private String arg1;

    @Option(name="-arg2", usage="Argument 2 (Default: " + ARG2_DEFAULT + ")", required = false)
    private String arg2 = ARG2_DEFAULT;

    public MainArgs(String... args) throws CmdLineException {
        this.parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            LOGGER.error("An exception occurred while parsing the arguments: ", e);
            printUsage();
            throw e;
        }
    }

    public void printUsage() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        this.parser.printUsage(baos);
        LOGGER.info("\n" + baos.toString());
    }

    public String getArg1() {
        return arg1;
    }

    public void setArg1(String arg1) {
        this.arg1 = arg1;
    }

    public String getArg2() {
        return arg2;
    }

    public void setArg2(String arg2) {
        this.arg2 = arg2;
    }

    @Override
    public String toString() {
        return "MainArgs{" +
                "arg2='" + arg2 + '\'' +
                ", arg1='" + arg1 + '\'' +
                '}';
    }
}
