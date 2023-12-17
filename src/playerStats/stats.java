package src.playerStats;

import java.util.concurrent.TimeUnit;
import src.Items.Item;

public class Stats {

    // private int health = 100;
    // private int shield = 100;
    // private int arrows = 25;
    // private int apples = 2;
    // private int crackers = 1;
    private int awakeLevel = 10;
    private Item[] hotbar = new Item[3];
    private int x = 0;
    private int y = 0;
    private boolean silent = false;

    

    

    public Stats() {

    }

    // public String toString() {
    //     String playerStats = "MAIN PLAYER STATS" + "\n" + "health : " + getHealth() + "\n" + "shield : " + getShield()
    //             + "\n" + "arrows : " + getArrows() + "\n" + "apples : " + getApples() + "\n" + "crackers : "
    //             + getCrackers() + "\n";

    //     return playerStats;
    // }

    // ---- SETTERS ----

    // public void setHealth(int health) {
    //     this.health = health;
    // }

    // public void setShield(int shield) {
    //     this.shield = shield;
    // }

    // public void setArrows(int arrows) {
    //     this.arrows = arrows;
    // }

    // public void setApples(int apples) {
    //     this.apples = apples;
    // }

    // public void setCrackers(int crackers) {
    //     this.crackers = crackers;
    // }

    public void setAwakeLevel(int awakeLevel) {
        this.awakeLevel = awakeLevel;
    }

    public void setHotbar(Item[] hotbar) {
        this.hotbar = hotbar;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSilent(boolean silent) {
        this.silent = silent;
    }

    // ---- GETTERS ----

    // public int getHealth() {
    //     return health;
    // }

    // public int getShield() {
    //     return shield;
    // }

    // public int getArrows() {
    //     return arrows;
    // }

    // public int getApples() {
    //     return apples;
    // }

    // public int getCrackers() {
    //     return crackers;
    // }

    public int getAwakeLevel() {
        return awakeLevel;
    }

    public Item[] getHotbar() {
        return hotbar;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isSilent() {
        return silent;
    }
}
