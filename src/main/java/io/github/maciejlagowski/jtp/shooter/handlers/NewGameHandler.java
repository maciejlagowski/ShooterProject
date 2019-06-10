package io.github.maciejlagowski.jtp.shooter.handlers;

import io.github.maciejlagowski.jtp.shooter.config.ConfigReader;
import io.github.maciejlagowski.jtp.shooter.menu.Menu;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NewGameHandler implements EventHandler {

    @Override
    public void handle(final Event event) {
        ConfigReader.readConfig();
        StageControllerClass stageControllerClass = Menu.getStageControllerClass();
        Stage actualStage = stageControllerClass.getActualStage();
        actualStage.close();
        actualStage = new Stage();
        stageControllerClass.setActualStage(actualStage);
        FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            Parent root = fxmlLoader.load(getClass().getResource("/fxml/name.fxml").openStream());
            actualStage.setTitle("Maciej Łagowski JTP Project - Shooter");
            actualStage.setScene(new Scene(root));
            actualStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
