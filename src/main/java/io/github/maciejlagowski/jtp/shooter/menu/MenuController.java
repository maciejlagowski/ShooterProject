package io.github.maciejlagowski.jtp.shooter.menu;

import io.github.maciejlagowski.jtp.shooter.content.Content;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuController {

    @FXML
    protected void handleNewGameAction(ActionEvent event) {
        StageControllerClass stageControllerClass = Menu.getStageControllerClass();
        Stage actualStage = stageControllerClass.getActualStage();
        actualStage.close();
        actualStage = new Stage();
        stageControllerClass.setActualStage(actualStage);
        stageControllerClass.setActualController(null);
        actualStage.setTitle("Maciej Łagowski JTP Project - Shooter");
        Scene scene = new Scene(new Content().createContent());
        scene.setCursor(Cursor.CROSSHAIR);
        actualStage.setScene(scene);
        actualStage.show();
    }
}
//TODO handlersy do reszty przyciskow