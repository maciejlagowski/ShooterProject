package io.github.maciejlagowski.jtp.shooter.logger;

import org.apache.log4j.*;

import java.io.IOException;

public class LoggerClass {

    private static Logger logger = makeLogger();

    private LoggerClass() {
    }

    private static Logger makeLogger() {
        Layout layout = new PatternLayout("[%p] %c - %m - DateOfLog: %d %n");
        Appender appender = null;
        try {
            appender = new FileAppender(layout, "src/main/resources/log.txt");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        BasicConfigurator.configure(appender);
        return Logger.getRootLogger();
    }

    public static Logger getLogger() {
        return logger;
    }
}