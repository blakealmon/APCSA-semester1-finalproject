package src.playerStats;

import java.util.concurrent.TimeUnit;

public class stats {
    
    int health = 100;
   

    int shield = 100;

    int arrows = 25;


    int apples = 2;
    int crackers = 1;

    public stats(){
        
    }


    public String toString(){
        String playerStats =  "MAIN PLAYER STATS" + "\n" + "health : " + getHealth() + "\n" + "shield : " + getShield() + "\n" + "arrows : " + getArrows() + "\n" + "apples : " + getApples() + "\n" + "crackers : " + getCrackers() + "\n";
        
        return playerStats;
    }
    // ---- SETTERS ----

    public void setHealth(int health) {
        this.health = health;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public void setArrows(int arrows) {
        this.arrows = arrows;
    }

    public void setApples(int apples) {
        this.apples = apples;
    }

    public void setCrackers(int crackers) {
        this.crackers = crackers;
    }


    // ---- GETTERS ----
    
    public int getHealth() {
        return health;
    }

    public int getShield() {
        return shield;
    }

    public int getArrows() {
        return arrows;
    }

    public int getApples() {
        return apples;
    }

    public int getCrackers() {
        return crackers;
    }
}
