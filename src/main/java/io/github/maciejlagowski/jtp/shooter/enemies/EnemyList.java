package io.github.maciejlagowski.jtp.shooter.enemies;

import io.github.maciejlagowski.jtp.shooter.config.ConfigReader;
import io.github.maciejlagowski.jtp.shooter.handlers.MouseClickHandler;
import io.github.maciejlagowski.jtp.shooter.logic.Logic;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import java.util.LinkedList;
import java.util.List;

public class EnemyList {

    private List<Enemy> enemyList = new LinkedList<>();
    private Pane root;
    private Logic logic;

    public EnemyList(Pane root, Logic logic) {
        this.logic = logic;
        this.root = root;
    }

    public void generateEnemies(int quantity) {
        enemyList.clear();
        for (int i = 0; i < quantity; i++) {
            enemyList.add(new Enemy(ConfigReader.getWindowSize(), logic, this));
        }
        MouseClickHandler mouseClickHandler = new MouseClickHandler();
        for (Enemy enemy : enemyList) {
            enemy.setOnMouseClicked(mouseClickHandler);
            root.getChildren().add(enemy);
        }
    }

    public Boolean isEmpty() {
        return enemyList.isEmpty();
    }

    public void moveEveryone() {
        enemyList.forEach(Enemy::moveRandom);
    }

    public int attackEveryone() {
        int howMuchDecrement = 0;
        for (Enemy enemy : enemyList) {
            enemy.setImage(new Image("/img/ufo.png"));
            if (enemy.attack()) {
                howMuchDecrement++;
            }
        }
        return howMuchDecrement;
    }

    public void hideEveryone() {
        enemyList.forEach(enemy -> enemy.setVisible(false));
    }

    List<Enemy> getEnemyList() {
        return enemyList;
    }
}
