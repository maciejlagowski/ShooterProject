package io.github.maciejlagowski.jtp.shooter.menu;

import io.github.maciejlagowski.jtp.shooter.content.Content;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuController {

    private Stage primaryStage;

    @FXML
    protected void handleNewGameAction(ActionEvent event) {
        Platform.runLater( () -> {
            primaryStage.setTitle("Maciej Łagowski JTP Project - Shooter");
            Scene scene = new Scene(new Content().createContent());
            scene.setCursor(Cursor.CROSSHAIR);
            primaryStage.setScene(scene);
            primaryStage.show();
        });
    }

    void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
