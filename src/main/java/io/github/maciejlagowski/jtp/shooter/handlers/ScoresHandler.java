package io.github.maciejlagowski.jtp.shooter.handlers;

import io.github.maciejlagowski.jtp.shooter.menu.Menu;
import io.github.maciejlagowski.jtp.shooter.scores.Scores;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ScoresHandler implements EventHandler {
    @Override
    public void handle(final Event event) {
        StageControllerClass stageControllerClass = Menu.getStageControllerClass();
        Stage actualStage = stageControllerClass.getActualStage();
        actualStage.close();
        actualStage = new Stage();
        stageControllerClass.setActualStage(actualStage);
        FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            Parent root = fxmlLoader.load(getClass().getResource("/fxml/scores.fxml").openStream());
            actualStage.setTitle("Maciej Łagowski JTP Project - Shooter");
            Scene scene = new Scene(root);
            actualStage.setScene(scene);
            GridPane gridPane = (GridPane) scene.lookup("#gp");
            new Scores().show(gridPane);
            actualStage.show();
        } catch (IOException e) {
            System.err.println("FXML scores not found");
        }
    }
}