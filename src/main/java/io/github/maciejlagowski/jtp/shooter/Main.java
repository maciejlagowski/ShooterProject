package io.github.maciejlagowski.jtp.shooter;

import io.github.maciejlagowski.jtp.shooter.logic.Timer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private Timer timer = new Timer();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Maciej Lagowski Rail-Shooter");
        primaryStage.setScene(new Scene(timer.createContent()));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
