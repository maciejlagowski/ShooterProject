package io.github.maciejlagowski.jtp.shooter.logic;

import io.github.maciejlagowski.jtp.shooter.content.Content;
import io.github.maciejlagowski.jtp.shooter.enemies.EnemyList;
import io.github.maciejlagowski.jtp.shooter.lives.LivesList;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;

public class Logic {

    private EnemyList enemyList;
    private Content content;
    private LivesList livesList;
    private int score = 0;
    private int time = 0;
    private int level = 0;

    public Logic(Pane root, Content content) {
        this.content = content;
        this.livesList = new LivesList(root);
        this.enemyList = new EnemyList(root, this);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                update();
            }
        };
        timer.start();
    }

    public void incrementScore() {
        score++;
    }

    private void update() {
        if (!livesList.isEmpty()) {
            time++;
            if (time > 100) {
                time = 0;
                enemyList.moveEveryone();
                livesList.decrementLives(enemyList.attackEveryone());
            }
            if (enemyList.isEmpty()) {
                level++;
                content.setTextOnLevelLabel("level " + level);
                enemyList.generateEnemies(level * 3);
                enemyList.moveEveryone();
                livesList.renewLives();
            }
        } else {
            content.setDiedLabelVisible();
            content.setScoreLabel(score);
            enemyList.hideEveryone();
        }
    }
}
