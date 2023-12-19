package src.Items;
import src.playerStats.*;

public class Slippers extends Item{
    //constructor
    public Slippers() {
        super(true, "slippers");
    }

    //method for use
    public void consume(Stats stats) {
        stats.setSilent(true);
    }

    //item description
    public String toString() {
        return "These silent slippers will allow you to walk through a dangerous room once without being detected";
    }


}
