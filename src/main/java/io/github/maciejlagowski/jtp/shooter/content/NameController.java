package io.github.maciejlagowski.jtp.shooter.content;

import io.github.maciejlagowski.jtp.shooter.handlers.StageControllerClass;
import io.github.maciejlagowski.jtp.shooter.logger.LoggerClass;
import io.github.maciejlagowski.jtp.shooter.menu.Menu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NameController {

    public TextField nameTextField;

    @FXML
    protected void handleOKButton(ActionEvent event) {
        StageControllerClass stageControllerClass = Menu.getStageControllerClass();
        Stage actualStage = stageControllerClass.getActualStage();
        actualStage.close();
        actualStage = new Stage();
        stageControllerClass.setActualStage(actualStage);
        stageControllerClass.setActualController(null);
        actualStage.setTitle("Maciej Łagowski JTP Project - Shooter");
        Scene scene = new Scene(new Content().createContent(nameTextField.getText()));
        scene.setCursor(Cursor.CROSSHAIR);
        actualStage.setScene(scene);
        actualStage.show();
        LoggerClass.getLogger().info("Starting game");
    }
}
