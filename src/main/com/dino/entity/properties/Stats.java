package main.com.dino.entity.properties;

public class Stats {
    private static final int MAX_HP = 1000;
    private static final int MIN_HP = 50;

    private int hp;
    private int energy;

    // we have the knowledge that everything 1 -> 0.5
    // so 2 speed is 1
    private int speed;
    private int attackDmg;
    private int defense;

    public Stats() {
        this.hp = -1;
        this.energy = -1;
        this.speed = -1;
        this.attackDmg = -1;
        this.defense = -1;
    }

    public Stats(int hp, int energy, int speed, int attackDmg, int defense) {
        this.hp = hp;
        this.energy = energy;
        this.speed = speed;
        this.attackDmg = attackDmg;
        this.defense = defense;
    }

    public String toString() {
        String str = "Stats["
                + "\n\thp: " + this.hp
                + "\n\tenergy: " + this.energy
                + "\n\tspeed: " + this.speed
                + "\n\tattackDmg: " + this.attackDmg
                + "\n\tdefense: " + this.defense
                + "]";

        return str;
    }
}
