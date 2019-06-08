package io.github.maciejlagowski.jtp.shooter.scores;

import io.github.maciejlagowski.jtp.shooter.handlers.BackToMenuHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ScoresController {

    @FXML
    protected void handleBackAction(ActionEvent event) {
        new BackToMenuHandler().handle(event);
    }

    @FXML
    protected void handleClearScores(ActionEvent event) {
        new Scores().clear();
    }
}
