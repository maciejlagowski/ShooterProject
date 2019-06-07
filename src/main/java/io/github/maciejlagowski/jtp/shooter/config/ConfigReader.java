package io.github.maciejlagowski.jtp.shooter.config;

import io.github.maciejlagowski.jtp.shooter.enemies.DifficultyEnum;
import static io.github.maciejlagowski.jtp.shooter.enemies.DifficultyEnum.*;

public class ConfigReader {
    //TODO make this work
    private final static int[] windowSize = {1600, 900};
    private final static int maxJumpLength = 500;
    private final static DifficultyEnum difficultyLevel = IMPOSSIBLE;

    public static int getMaxJumpLength() {
        return maxJumpLength;
    }

    public static int[] getWindowSize() {
        return windowSize;
    }

    public static DifficultyEnum getDifficultyLevel() {
        return difficultyLevel;
    }
}
