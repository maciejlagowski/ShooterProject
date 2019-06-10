package io.github.maciejlagowski.jtp.shooter.about;

import io.github.maciejlagowski.jtp.shooter.handlers.BackToMenuHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AboutController {

    @FXML
    protected void OkButton(ActionEvent event) {
        new BackToMenuHandler().handle(event);
    }
}
