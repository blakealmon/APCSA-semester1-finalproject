package src.Items;
import src.playerStats.*;

public class Slippers extends Item{
    public Slippers() {
        super(true, "slippers");
    }

    public void consume(Stats stats) {
        stats.setSilent(true);
    }

    public String toString() {
        return "These silent slippers will allow you to walk through a dangerous room once without being detected before going away";
    }


}
