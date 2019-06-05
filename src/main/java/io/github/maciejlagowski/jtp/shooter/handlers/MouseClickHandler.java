package io.github.maciejlagowski.jtp.shooter.handlers;

import io.github.maciejlagowski.jtp.shooter.enemies.Enemy;
import javafx.event.Event;
import javafx.event.EventHandler;

public class MouseClickHandler implements EventHandler {

    @Override
    public void handle(final Event event) {
        Enemy enemy = (Enemy) event.getTarget();
        enemy.kill();
    }
}
