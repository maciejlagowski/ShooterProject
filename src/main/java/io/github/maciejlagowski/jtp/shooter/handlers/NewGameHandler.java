package io.github.maciejlagowski.jtp.shooter.handlers;

import io.github.maciejlagowski.jtp.shooter.content.Content;
import io.github.maciejlagowski.jtp.shooter.menu.Menu;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NewGameHandler implements EventHandler {

    @Override
    public void handle(final Event event) {
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