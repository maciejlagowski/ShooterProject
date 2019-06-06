package io.github.maciejlagowski.jtp.shooter.enemies;

public enum DifficultyEnum {

    EASY(15), MEDIUM(10), HARD(5);  //balance difficulty by changing this numbers

    private int difficulty;

    DifficultyEnum(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getDifficulty() {
        return difficulty;
    }
}
