package io.github.maciejlagowski.jtp.shooter.enemies;

import io.github.maciejlagowski.jtp.shooter.config.ConfigReader;
import io.github.maciejlagowski.jtp.shooter.logic.Logic;
import javafx.animation.PathTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.util.Duration;

import java.util.Random;

public class Enemy extends ImageView {

    private final int[] windowSize;
    private final int maxJumpLength = ConfigReader.getMaxJumpLength();
    private final Difficulty difficultyLevel = ConfigReader.getDifficultyLevel();
    private double[] position = new double[2];
    private Logic logic;
    private EnemyList enemyList;

    Enemy(int[] windowSize, Logic logic, EnemyList enemyList) {
        super("/img/ufo.png");
        this.windowSize = windowSize;
        Random rand = new Random();
        this.position[0] = rand.nextInt(windowSize[0]) + 1;
        this.position[1] = rand.nextInt(windowSize[1]) + 1;
        this.logic = logic;
        this.enemyList = enemyList;
    }

    public void kill() {
        logic.incrementScore();
        enemyList.getEnemyList().remove(this);
        setImage(new Image("/img/ufoDead.gif"));
        PathTransition transition = new PathTransition();
        transition.setDuration(Duration.seconds(1));
        transition.setNode(this);
        transition.setPath(new Line(position[0], position[1], position[0], windowSize[1] + 60));
        transition.play();
    }

    void moveRandom() {
        double coordinateX = position[0];
        double coordinateY = position[1];
        randNewPosition();
        PathTransition transition = new PathTransition();
        transition.setDuration(Duration.seconds(1));
        transition.setNode(this);
        transition.setPath(new Line(coordinateX, coordinateY, position[0], position[1]));
        transition.play();
    }

    Boolean attack() {
        Random random = new Random();
        if (random.nextInt(difficultyLevel.getDifficulty()) == 0) {
            setImage(new Image("/img/ufoAttack.gif"));
            return true;
        }
        return false;
    }

    private void randNewPosition() {
        Random rand = new Random();
        int posX, posY;
        do {
            posX = rand.nextInt(maxJumpLength) - (maxJumpLength / 2);
        } while (position[0] + posX > windowSize[0] || position[0] + posX < 0);
        do {
            posY = rand.nextInt(maxJumpLength) - (maxJumpLength / 2);
        } while (position[1] + posY > windowSize[1] || position[1] + posY < 0);
        position[0] += posX;
        position[1] += posY;
    }
}
