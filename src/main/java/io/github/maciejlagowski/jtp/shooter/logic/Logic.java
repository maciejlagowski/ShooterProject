package io.github.maciejlagowski.jtp.shooter.logic;

import io.github.maciejlagowski.jtp.shooter.content.Content;
import io.github.maciejlagowski.jtp.shooter.enemies.Enemy;
import io.github.maciejlagowski.jtp.shooter.enemies.EnemyList;
import io.github.maciejlagowski.jtp.shooter.lives.Live;
import io.github.maciejlagowski.jtp.shooter.lives.LivesList;
import javafx.scene.layout.Pane;
import java.util.List;

public class Logic {

    private static int score = 0;
    private int time = 0;
    private int level = 0;
    private List<Enemy> enemyList = EnemyList.getEnemyList();

    public void update(Pane root) {
        if(LivesList.getQuantity() > 0) {

            time++;
            if (time > 100) {
                time = 0;
                enemyList.forEach(enemy -> {
                    enemy.attack();
                    enemy.moveRandom();
                });
            }
            if (enemyList.isEmpty()) {
                level++;
                Content.setTextOnLevelLabel("level " + level);
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
                EnemyList.generateEnemies(level * 3, root);
                enemyList.forEach(Enemy::moveRandom);
                LivesList.renewLives();
            }
        }
    }

    public static void incrementScore() {
        score++;
    }

    public static int getScore() {
        return score;
    }
}
