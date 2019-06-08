package io.github.maciejlagowski.jtp.shooter.handlers;

import io.github.maciejlagowski.jtp.shooter.menu.Menu;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ConfigHandler implements EventHandler {
    @Override
    public void handle(final Event event) {
        StageControllerClass stageControllerClass = Menu.getStageControllerClass();
        Stage actualStage = stageControllerClass.getActualStage();
        actualStage.close();
        actualStage = new Stage();
        stageControllerClass.setActualStage(actualStage);
        FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            Parent root = fxmlLoader.load(getClass().getResource("/fxml/config.fxml").openStream());
            actualStage.setTitle("Maciej Łagowski JTP Project - Shooter");
            actualStage.setScene(new Scene(root));
            actualStage.show();
        } catch (IOException e) {
            System.err.println("FXML config not found");
        }
    }
}
