package io.github.maciejlagowski.jtp.shooter.lives;

import javafx.scene.image.ImageView;

public class Live extends ImageView {

    Live(int i) {
        super("/img/live.png");
        this.setLayoutX(62 * i);
    }
}
