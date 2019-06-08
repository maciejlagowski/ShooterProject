package io.github.maciejlagowski.jtp.shooter.menu;

import io.github.maciejlagowski.jtp.shooter.handlers.StageControllerClass;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Menu extends Application {

    private static StageControllerClass stageControllerClass = new StageControllerClass();

    public static void main(String[] args) {
        launch(args);
    }

    public static StageControllerClass getStageControllerClass() {
        return stageControllerClass;
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = fxmlLoader.load(getClass().getResource("/menu.fxml").openStream());
            stageControllerClass.setActualController(fxmlLoader.getController());
            stageControllerClass.setActualStage(primaryStage);
            primaryStage.setTitle("Maciej Łagowski JTP Project - Shooter");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            System.err.println("FXML menu file not found");
        }
    }
}
