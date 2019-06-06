package io.github.maciejlagowski.jtp.shooter.enemies;

import io.github.maciejlagowski.jtp.shooter.lives.LivesList;
import io.github.maciejlagowski.jtp.shooter.logic.Logic;
import javafx.animation.PathTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import java.util.Random;

import static io.github.maciejlagowski.jtp.shooter.enemies.DifficultyEnum.*;
import static java.lang.Thread.sleep;

public class Enemy extends ImageView {

    private final static int recSize = 40;
    private final int[] windowSize;
    private final int duration = 1; //speed^-1
    private final int maxJumpLength = 500;
    private final DifficultyEnum difficultyLevel = EASY;
    private double[] position = new double[2];

    Enemy(int[] windowSize) {
        super("/img/ufo.png");
        this.windowSize = windowSize;
        Random rand = new Random();
        this.position[0] = rand.nextInt(windowSize[0]) + 1;
        this.position[1] = rand.nextInt(windowSize[1]) + 1;
    }

    public void moveRandom() {
        PathTransition transition = new PathTransition();
        double coordinateX = position[0];
        double coordinateY = position[1];
        randNewPosition();
        Line line = new Line(coordinateX, coordinateY, position[0], position[1]);
        transition.setDuration(Duration.seconds(duration));
        transition.setPath(line);
        transition.setNode(this);
        transition.play();
    }

    public void kill() {
        Logic.incrementScore();
        EnemyList.getEnemyList().remove(this);
        setImage(new Image("/img/ufoDead.gif"));
        PathTransition transition = new PathTransition();
        transition.setDuration(new Duration(1000));
        transition.setNode(this);
        transition.setPath(new Line(position[0], position[1], position[0], windowSize[1] + 60));
        transition.play();
    }

    public void attack() {
        Random random = new Random();
        if(random.nextInt(difficultyLevel.getDifficulty()) == 0) {
            setImage(new Image("/img/ufoAttack.gif"));
            LivesList.decrementLives();
        }
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
