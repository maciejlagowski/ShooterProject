package io.github.maciejlagowski.jtp.shooter.lives;

import io.github.maciejlagowski.jtp.shooter.content.Content;
import io.github.maciejlagowski.jtp.shooter.enemies.EnemyList;
import io.github.maciejlagowski.jtp.shooter.logic.Logic;
import javafx.scene.layout.Pane;

import java.util.LinkedList;
import java.util.List;

public class LivesList {
    private static List<Live> livesList = new LinkedList<>();
    private final static int startQuantity = 9;
    private static int quantity = startQuantity;
    private static Pane root;

    public static void initLivesList(Pane root) {
        LivesList.root = root;
        for (int i = 0; i < startQuantity; i++) {
            livesList.add(new Live(i));
        }
        livesList.forEach(live -> root.getChildren().add(live));
    }

    public static List<Live> getLivesList() {
        return livesList;
    }

    public static void decrementLives() {
        quantity--;
        livesList.get(quantity).setVisible(false);
        livesList.remove(quantity);
        if(quantity == 0) {
            Content.setDiedLabelVisible();
            Content.setScoreLabel(Logic.getScore());
            EnemyList.getEnemyList().forEach(enemy -> enemy.setVisible(false));
        }
    }

    public static int getQuantity () {
        return quantity;
    }

    public static void renewLives () {
        Live live;
        for (int i = quantity; i < startQuantity; i++) {
            live = new Live(i);
            livesList.add(live);
            root.getChildren().add(live);
        }
        quantity = startQuantity;
    }
}
