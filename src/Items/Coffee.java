package src.Items;

import src.playerStats.Stats;

public class Coffee extends Item {

    //constructor that sets name of item
    public Coffee() {
        super(true, "coffee");
    }

    //consume method for coffee to use item
    public void consume(Stats stats) {
        //subject to change
        stats.setAwakeLevel(stats.getAwakeLevel() + 3);
    }

    //prints description of item
    public String toString() {
        return "This item increases your awake level by 3 points, allowing you to extend the time you have before falling asleep";
    }
}
