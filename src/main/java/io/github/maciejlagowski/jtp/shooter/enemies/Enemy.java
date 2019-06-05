package io.github.maciejlagowski.jtp.shooter.enemies;

import javafx.animation.PathTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.Random;

public class Enemy extends Rectangle {

    private final static int recSize = 40;
    private final int[] windowSize;
    private final int duration = 1;
    private final int maxJumpLength = 200;
    private double[] position = new double[2];

    public Enemy(int[] windowSize) {
        super(recSize, recSize, Color.BLUE);
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
        setVisible(false);
        EnemyList.getEnemyList().remove(this);
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
