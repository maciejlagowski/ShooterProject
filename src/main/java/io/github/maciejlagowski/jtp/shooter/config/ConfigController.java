package io.github.maciejlagowski.jtp.shooter.config;

import io.github.maciejlagowski.jtp.shooter.handlers.BackToMenuHandler;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConfigController {

    public ListView<String> resolutionList;
    public ListView<String> difficultyList;


    public void init() {
        this.resolutionList.getItems().addAll(FXCollections.observableArrayList("640x480", "800x600", "1280x720", "1600x900"));
        this.difficultyList.getItems().addAll(FXCollections.observableArrayList("Easy", "Medium", "Hard", "Impossible"));
    }

    @FXML
    protected void handleSaveButton(ActionEvent event) {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("src/main/resources/csv/config.csv"));
            int resolution = resolutionList.getSelectionModel().getSelectedIndex();
            int difficulty = difficultyList.getSelectionModel().getSelectedIndex();
            if (resolution == -1) {
                resolution = 0;
            }
            if (difficulty == -1) {
                difficulty = 0;
            }
            writer.write(resolution + "," + difficulty);
            writer.close();
            new BackToMenuHandler().handle(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void handleCancelButton(ActionEvent event) {
        new BackToMenuHandler().handle(event);
    }
}
