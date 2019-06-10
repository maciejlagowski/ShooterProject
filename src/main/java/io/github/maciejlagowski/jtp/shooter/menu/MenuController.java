package io.github.maciejlagowski.jtp.shooter.menu;

import io.github.maciejlagowski.jtp.shooter.handlers.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MenuController {

    @FXML
    protected void handleNewGameAction(ActionEvent event) {
        new NewGameHandler().handle(event);
    }

    @FXML
    protected void handleConfigAction(ActionEvent event) {
        new ConfigHandler().handle(event);
    }

    @FXML
    protected void handleScoresAction(ActionEvent event) {
        new ScoresHandler().handle(event);
    }

    @FXML
    protected void handleAboutAction(ActionEvent event) {
        new AboutHandler().handle(event);
    }

    @FXML
    protected void handleExitAction(ActionEvent event) {
        StageControllerClass stageControllerClass = Menu.getStageControllerClass();
        stageControllerClass.getActualStage().close();
    }
}
