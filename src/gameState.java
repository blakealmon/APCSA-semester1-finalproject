package src;

import src.Items.*;

public class GameState {
    //end condition
    private boolean end;

    private Room[][] map = new Room[5][5];
    //reference
    //1: safe, 2: dangerous, 0: none
    //[1, 2, 0, 0, 0]
    //[1, 1, 1, 0, 2]
    //[0, 2, 1, 1, 1]
    //[0, 0, 0, 2, 0]
    //[0, 0, 0, 0, 0]

    public GameState() {
        this.end = false;
        //different rooms for different places in the map

        //starting room
        Room livingroom = new Room("livingroom", "You are in the living room right now. Get the cookie then hurry up and get back here.", false, "You are in the living room now");
        map[0][0] = livingroom;
        //dangerous room
        Room bedroom1 = new Room("bedroom1", "This is the bedroom of a little boy.):", true, "You're back in the little boy's bedroom");
        map[0][1] = bedroom1;
        //safe room
        Room hallway = new Room("hallway", "You're in the hallway right now, look for the kitchen to find the cookies and milk", false, "You're in the hallway right now");
        map[1][0] = hallway;
        //safe room with flashlight item
        Room garage = new Room("garage", new Flashlight(), "You're in the garage now. Hmmm. Maybe you can find something to help 'illuminate' the layout of the house", false, "You're in the garage now");
        map[1][1] = garage;
        //safe room with important info
        Room bedroom2 = new Room("bedroom2", new Note("Dear Santa, thanks for stopping by! My name is Colby, and I really really really want a new laptop for christmas.", "laptop"), "This bedroom is empty, but it seems the kid has left a note for you.", false, "You're back in Colby's bedroom");
        map[1][2] = bedroom2;
        //unsafe room
        Room bedroom3 = new Room("bedroom3","Careful, there's a little kid in here.", true, "Careful, there's a little kid in here");
        map[2][1] = bedroom3;

        Room closet = new Room("closet", new Slippers(), "You just found some quiet slippers!", false, "You're in the closet now");
        map[2][2] = closet;

        Room bedroom4 = new Room("bedroom4", new Note("Dear Santa, my name is Stevie and I could really use some new pokemon cards for Christmas", "pokemon cards"), "This bedroom is empty, but it seems the kid has left a note for you", false, "You're back in Stevie's bedroom");
        map[2][3] = bedroom4;

        Room kitchen = new Room("kitchen", new Cookie(), "Congratulations, you've found the cookie of the house. Eat the cookie and return back through the chimney without being spotted", false, "You're in the kitchen right now");
        map[2][4] = kitchen;

    }


    //getter
    public Room[][] getMap() {
        return map;
    }

    public boolean getEnd() {
        return end;
    }


    //setter
    public void setMap(Room[][] map) {
        this.map = map;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    
}
