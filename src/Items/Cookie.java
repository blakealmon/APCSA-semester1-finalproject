package src.Items;

import src.playerStats.Stats;

public class Cookie extends Item {

    //constructor that sets name of item
    public Cookie() {
        super(true, "cookie");
    }

    //consume the cookie
    public String consume(Stats stats) {
        stats.setCookie(true);
        //subject to change
        return "Congratulations, you've found the cookie of the house. Eat the cookie and return back through the chimney without being spotted. Hint: take note of the items the kids wanted";
    }

    //prints description of item
    public String toString() {
        return "yummy cookie";
    }
}

