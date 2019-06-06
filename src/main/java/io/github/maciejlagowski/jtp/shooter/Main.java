package io.github.maciejlagowski.jtp.shooter;

import io.github.maciejlagowski.jtp.shooter.content.Content;
import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Maciej Łagowski JTP Project - Shooter");
        Scene scene = new Scene(new Content().createContent());
        scene.setCursor(Cursor.CROSSHAIR);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
