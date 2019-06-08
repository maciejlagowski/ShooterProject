package io.github.maciejlagowski.jtp.shooter.enemies;

public enum Difficulty {

    EASY(15), MEDIUM(10), HARD(5), IMPOSSIBLE(1);  //balance difficulty by changing this numbers

    private int difficulty;

    Difficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getDifficulty() {
        return difficulty;
    }
}
