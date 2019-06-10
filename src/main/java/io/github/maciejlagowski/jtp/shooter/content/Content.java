package io.github.maciejlagowski.jtp.shooter.content;

import io.github.maciejlagowski.jtp.shooter.config.ConfigReader;
import io.github.maciejlagowski.jtp.shooter.handlers.BackToMenuHandler;
import io.github.maciejlagowski.jtp.shooter.logic.Logic;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class Content {

    private final int[] windowSize = ConfigReader.getWindowSize();
    private final Label levelLabel = new Label();
    private final Label diedLabel = new Label();
    private final Label scoreLabel = new Label();
    private final Button backToMenuButton = new Button();
    private final Pane root = new Pane();

    Parent createContent(String name) {
        root.setPrefSize(windowSize[0], windowSize[1]);
        createLabels();
        createButton();
        new Logic(root, this, name);
        return root;
    }

    public void setTextOnLevelLabel(String text) {
        levelLabel.setText(text);
    }

    public void setDiedLabelVisible() {
        diedLabel.setVisible(true);
    }

    public void setEnding(Integer score) {
        scoreLabel.setText("Your score: " + score);
        scoreLabel.setVisible(true);
        backToMenuButton.setVisible(true);
    }

    private void createLabels() {
        levelLabel.setStyle("-fx-font-size: 20px");
        levelLabel.setLayoutY(windowSize[1] - 23);
        root.getChildren().add(levelLabel);

        diedLabel.setStyle("-fx-font-size: 118px; -fx-text-fill: #A70000; -fx-font-family: serif");
        diedLabel.setText("YOU DIED.");
        diedLabel.setLayoutX(windowSize[0] / 2 - 310);
        diedLabel.setLayoutY(windowSize[1] / 2 - 100);
        diedLabel.setVisible(false);
        root.getChildren().add(diedLabel);

        scoreLabel.setStyle("-fx-font-size: 30px");
        scoreLabel.setLayoutX(windowSize[0] / 2 - 60);
        scoreLabel.setLayoutY(windowSize[1] / 2 + 20);
        scoreLabel.setVisible(false);
        root.getChildren().add(scoreLabel);
    }

    private void createButton() {
        backToMenuButton.setText("Back to menu");
        backToMenuButton.setLayoutX(windowSize[0] / 2 + 60);
        backToMenuButton.setLayoutY(windowSize[1] / 2 + 80);
        backToMenuButton.setVisible(false);
        backToMenuButton.setOnAction(new BackToMenuHandler());
        root.getChildren().add(backToMenuButton);
    }
}
