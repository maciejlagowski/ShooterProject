package io.github.maciejlagowski.jtp.shooter.handlers;

import io.github.maciejlagowski.jtp.shooter.menu.StageControllerClass;
import io.github.maciejlagowski.jtp.shooter.menu.Menu;
import io.github.maciejlagowski.jtp.shooter.menu.MenuController;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class BackToMenuHandler implements EventHandler {

    @Override
    public void handle(final Event event) {
        StageControllerClass stageControllerClass = Menu.getStageControllerClass();
        Stage actualStage = stageControllerClass.getActualStage();
        actualStage.close();
        actualStage = new Stage();
        stageControllerClass.setActualStage(actualStage);
        FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            Parent root = fxmlLoader.load(getClass().getResource("/menu.fxml").openStream());
            MenuController controller = (MenuController) fxmlLoader.getController();
            actualStage.setTitle("Maciej Łagowski JTP Project - Shooter");
            stageControllerClass.setActualController(controller);
            actualStage.setScene(new Scene(root));
            actualStage.setResizable(false);
            actualStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
