package io.github.maciejlagowski.jtp.shooter.menu;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Menu extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("/menu.fxml").openStream());
        MenuController menuController = fxmlLoader.getController();
        menuController.setPrimaryStage(primaryStage);
        primaryStage.setTitle("Maciej Łagowski JTP Project - Shooter");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


//TODO tablica highscores
//TODO menu
//TODO config
// ??