package io.github.maciejlagowski.jtp.shooter.handlers;

import io.github.maciejlagowski.jtp.shooter.menu.MenuController;
import javafx.stage.Stage;
import lombok.Data;

@Data
public class StageControllerClass {
    private Stage actualStage;
    private MenuController actualController;
}
