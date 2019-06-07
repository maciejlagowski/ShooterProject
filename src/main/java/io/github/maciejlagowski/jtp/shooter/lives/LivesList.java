package io.github.maciejlagowski.jtp.shooter.lives;

import javafx.scene.layout.Pane;
import java.util.LinkedList;
import java.util.List;

public class LivesList {

    private final int startQuantity = 9;
    private List<Live> livesList = new LinkedList<>();
    private int quantity = 0;
    private Pane root;

    public LivesList(Pane root) {
        this.root = root;
        renewLives();
    }

    public void decrementLives(int howMany) {
        for (int i = 0; i < howMany; i++) {
            quantity--;
            if (quantity >= 0) {
                livesList.get(quantity).setVisible(false);
                livesList.remove(quantity);
            } else {
                quantity = 0;
                livesList.clear();
            }
        }
    }

    public void renewLives() {
        Live live;
        for (int i = quantity; i < startQuantity; i++) {
            live = new Live(i);
            livesList.add(live);
            root.getChildren().add(live);
        }
        quantity = startQuantity;
    }

    public Boolean isEmpty() {
        return livesList.isEmpty();
    }
}
