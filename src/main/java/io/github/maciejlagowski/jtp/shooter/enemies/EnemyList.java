package io.github.maciejlagowski.jtp.shooter.enemies;

import io.github.maciejlagowski.jtp.shooter.config.ConfigReader;
import io.github.maciejlagowski.jtp.shooter.handlers.MouseClickHandler;
import javafx.scene.layout.Pane;

import java.util.LinkedList;
import java.util.List;

public class EnemyList {

    private static List<Enemy> enemyList = new LinkedList<>();

    public static List<Enemy> getEnemyList() {
        return enemyList;
    }

    public static void generateEnemies(int quantity, Pane root) {
        for (int i = 0; i < quantity; i++) {
            enemyList.add(new Enemy(ConfigReader.getWindowSize()));
        }
        MouseClickHandler mouseClickHandler = new MouseClickHandler();
        for (Enemy enemy : enemyList) {
            enemy.setOnMouseClicked(mouseClickHandler);
            root.getChildren().add(enemy);
        }
    }
}
