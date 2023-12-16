package src.Items;

import src.playerStats.Stats;

public class Coffee extends Item {

    public Coffee() {
        super(true);
    }

    public void consume(Stats stats) {
        stats.setAwakeLevel(stats.getAwakeLevel() + 3);
    }

    public String toString() {
        return "This item increases your awake level by 3 points, allowing you to extend the time you have before falling asleep";
    }
}
