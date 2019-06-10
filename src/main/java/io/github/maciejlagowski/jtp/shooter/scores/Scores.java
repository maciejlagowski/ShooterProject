package io.github.maciejlagowski.jtp.shooter.scores;

import io.github.maciejlagowski.jtp.shooter.handlers.ScoresHandler;
import io.github.maciejlagowski.jtp.shooter.logger.LoggerClass;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Scores {

    private String[][] scoresTab = new String[2][6];

    public Scores() {
        load();
    }

    public void show(GridPane gridPane) {
        for (int i = 0; i < 5; i++) {
            gridPane.add(new Label(scoresTab[0][i]), 0, i);
            gridPane.add(new Label(scoresTab[1][i]), 1, i);
        }
    }

    private void load() {
        try {
            Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/csv/scores.csv"));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
            int i = 0;
            for (CSVRecord csvRecord : csvParser) {
                scoresTab[0][i] = csvRecord.get(0);
                scoresTab[1][i] = csvRecord.get(1);
                i++;
            }
        } catch (IOException e) {
            LoggerClass.getLogger().error("No scores file");
            for (int i = 0; i < 5; i++) {
                scoresTab[0][i] = "";
                scoresTab[1][i] = "0";
            }

        }
    }

    public void addScore(String name, String score) {
        scoresTab[0][5] = name;
        scoresTab[1][5] = score;
        sort();
        save();
    }

    private void save() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("src/main/resources/csv/scores.csv")));
            for (int i = 0; i < 5; i++) {
                writer.write(scoresTab[0][i] + "," + scoresTab[1][i]);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            LoggerClass.getLogger().error(e);
        }
    }

    private void sort() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                if (Integer.parseInt(scoresTab[1][j]) < Integer.parseInt(scoresTab[1][j + 1])) {
                    swap(j, j + 1);
                }
            }
        }
    }

    private void swap(int from, int where) {
        String tempName = scoresTab[0][where];
        String tempScore = scoresTab[1][where];
        scoresTab[0][where] = scoresTab[0][from];
        scoresTab[1][where] = scoresTab[1][from];
        scoresTab[0][from] = tempName;
        scoresTab[1][from] = tempScore;

    }

    void clear() {
        for (int i = 0; i < 5; i++) {
            scoresTab[0][i] = "";
            scoresTab[1][i] = "0";
        }
        save();
        new ScoresHandler().handle(new ActionEvent());
    }
}
