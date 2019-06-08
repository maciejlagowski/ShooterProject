package io.github.maciejlagowski.jtp.shooter.menu;

import io.github.maciejlagowski.jtp.shooter.handlers.ConfigHandler;
import io.github.maciejlagowski.jtp.shooter.handlers.NewGameHandler;
import io.github.maciejlagowski.jtp.shooter.handlers.ScoresHandler;
import io.github.maciejlagowski.jtp.shooter.handlers.StageControllerClass;
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
    protected void handleExitAction(ActionEvent event) {
        StageControllerClass stageControllerClass = Menu.getStageControllerClass();
        stageControllerClass.getActualStage().close();
    }
}
