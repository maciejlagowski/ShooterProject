package io.github.maciejlagowski.jtp.shooter.config;

import io.github.maciejlagowski.jtp.shooter.handlers.BackToMenuHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ConfigController {

    @FXML
    protected void handleBackAction(ActionEvent event) {
        new BackToMenuHandler().handle(event);
    }
}
