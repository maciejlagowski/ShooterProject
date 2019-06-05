package io.github.maciejlagowski.jtp.shooter.logic;

import io.github.maciejlagowski.jtp.shooter.config.ConfigReader;
import io.github.maciejlagowski.jtp.shooter.enemies.Enemy;
import io.github.maciejlagowski.jtp.shooter.enemies.EnemyList;
import javafx.animation.AnimationTimer;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.util.List;

public class Timer {

    private Pane root = new Pane();

    private int time = 0;
    private int level = 0;
    private List<Enemy> enemyList = EnemyList.getEnemyList();
    private Label levelLabel = new Label();
    private int[] windowSize = ConfigReader.getWindowSize();

    public Parent createContent() {
        root.setPrefSize(windowSize[0], windowSize[1]);
        levelLabel.setStyle("-fx-font-size: 20px");
        levelLabel.setLayoutX(200);
        levelLabel.setVisible(true);
        root.getChildren().add(levelLabel);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                update();
            }
        };
        timer.start();
        return root;
    }

    private void update() {
        time++;
        if (time > 300) {
            time = 0;
            enemyList.forEach(Enemy::moveRandom);
        }
        if (enemyList.isEmpty()) {
            level++;
            levelLabel.setText("level " + level);
            EnemyList.generateEnemies(level * 5, root);
        }
    }

}
