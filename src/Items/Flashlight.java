package src.Items;
import src.Room;

public class Flashlight extends Item {


    //basic constructor
    public Flashlight() {
        super(true, "flashlight");
    }

    //consume function for flashlight (look one step forward in any direction)
    //takes current x and y value and, a direction, and the curent gamestate
    public String consume(int x, int y, String direction, Room[][] map) {
        if (direction == "N") {
            if (map[y - 1][x].isDangerous()) {
                return "that room has someone in it";
            } else {
                return "that room is safe to go into";
            }
        } else if (direction == "S") {
            if (map[y + 1][x].isDangerous()) {
                return "that room has someone in it";
            } else {
                return "that room is safe to go into";
            }
        } else if (direction == "E") {
            if (map[y][x + 1].isDangerous()) {
                return "that room has someone in it";
            } else {
                return "that room is safe to go into";
            }
        } else if (direction == "W") {
            if (map[y][x - 1].isDangerous()) {
                return "that room has someone in it";
            }
        }
        //in case user enters something other than these 4
        return "that is not a valid direction, your options are (N, E, S, W)";
    }

    //description of flashlight
    public String toString() {
        return "This flashlight can be used to see one space ahead in any direction in the house. Use it wisely to plan out your next move.";
    }
}
