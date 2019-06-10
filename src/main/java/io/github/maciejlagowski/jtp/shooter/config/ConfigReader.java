package io.github.maciejlagowski.jtp.shooter.config;

import io.github.maciejlagowski.jtp.shooter.enemies.Difficulty;
import io.github.maciejlagowski.jtp.shooter.logger.LoggerClass;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConfigReader {

    private static final int[][] windowSizes = {{640, 480}, {800, 600}, {1280, 720}, {1600, 900}};
    private static final Difficulty[] difficulties = {Difficulty.EASY, Difficulty.MEDIUM, Difficulty.HARD, Difficulty.IMPOSSIBLE};

    private static int[] windowSize;
    private static Difficulty difficultyLevel;
    private static int timerSpeed;


    public static int getTimerSpeed() {
        return timerSpeed;
    }

    public static int[] getWindowSize() {
        return windowSize;
    }

    public static Difficulty getDifficultyLevel() {
        return difficultyLevel;
    }

    public static void readConfig() {
        int[] configTab = {0, 0};
        try {
            Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/csv/config.csv"));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
            for (CSVRecord csvRecord : csvParser) {
                configTab[0] = Integer.parseInt(csvRecord.get(0));
                configTab[1] = Integer.parseInt(csvRecord.get(1));
            }
        } catch (IOException e) {
            LoggerClass.getLogger().error("Cannot read config file, loading defaults");
        } finally {
            windowSize = windowSizes[configTab[0]];
            difficultyLevel = difficulties[configTab[1]];
            switch (configTab[0]) {
                case 0:
                case 1:
                    timerSpeed = 320;
                    break;
                case 2:
                    timerSpeed = 150;
                    break;
                case 3:
                    timerSpeed = 120;
            }
        }
    }
}
