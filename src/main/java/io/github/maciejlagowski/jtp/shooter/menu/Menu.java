package io.github.maciejlagowski.jtp.shooter.menu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Menu extends Application {

    private static StageControllerClass stageControllerClass = new StageControllerClass();

    public static void main(String[] args) {
        launch(args);
    }

    public static StageControllerClass getStageControllerClass() {
        return stageControllerClass;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("/menu.fxml").openStream());
        stageControllerClass.setActualController(fxmlLoader.getController());
        stageControllerClass.setActualStage(primaryStage);
        primaryStage.setTitle("Maciej Łagowski JTP Project - Shooter");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}


//TODO tablica highscores; config