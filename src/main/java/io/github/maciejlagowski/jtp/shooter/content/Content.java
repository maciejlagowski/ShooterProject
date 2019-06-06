package io.github.maciejlagowski.jtp.shooter.content;

import io.github.maciejlagowski.jtp.shooter.config.ConfigReader;
import io.github.maciejlagowski.jtp.shooter.lives.LivesList;
import io.github.maciejlagowski.jtp.shooter.logic.Logic;
import javafx.animation.AnimationTimer;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.awt.geom.Point2D;

public class Content {

    private final int[] windowSize = ConfigReader.getWindowSize();
    private static Label levelLabel = new Label();
    private static Label diedLabel = new Label();
    private static Label scoreLabel = new Label();
    private Pane root = new Pane();
    private Logic logic = new Logic();

    public Parent createContent() {
        root.setPrefSize(windowSize[0], windowSize[1]);
        createLabels();
        LivesList.initLivesList(root);
//        LivesList.getLivesList().forEach(live -> {});
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                logic.update(root);
            }
        };
        timer.start();
        return root;
    }

    public static void setTextOnLevelLabel(String text) {
        levelLabel.setText(text);
    }

    public static void setDiedLabelVisible() {
        diedLabel.setVisible(true);
    }

    public static void setScoreLabel(int score) {
        scoreLabel.setText("Your score: " + score);
        scoreLabel.setVisible(true);
    }

    private void createLabels() {
        levelLabel.setStyle("-fx-font-size: 20px");
        levelLabel.setLayoutY(windowSize[1] - 23);
        root.getChildren().add(levelLabel);

        diedLabel.setStyle("-fx-font-size: 120px; -fx-text-fill: #A70000; -fx-font-family: serif");
        diedLabel.setText("YOU DIED.");
        diedLabel.setLayoutX(windowSize[0] / 2 - 300);
        diedLabel.setLayoutY(windowSize[1] / 2 - 100);
        diedLabel.setVisible(false);
        root.getChildren().add(diedLabel);

        scoreLabel.setStyle("-fx-font-size: 30px");
        scoreLabel.setLayoutX(windowSize[0] / 2 - 60);
        scoreLabel.setLayoutY(windowSize[1] / 2 + 20);
        scoreLabel.setVisible(false);
        root.getChildren().add(scoreLabel);
    }
}
