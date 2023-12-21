//By Blake Almon and Cody Luu
import src.playerStats.Stats;
import src.GameState;
import java.util.Scanner;
import src.Room;
import src.Items.*;
import java.util.concurrent.TimeUnit;

//winning pattern: S, E, E, S, E, E, W, W, N, W, W, N

public class Play {
    public static void main(String[] args) throws InterruptedException {
        Stats stats = new Stats();
        GameState gameState = new GameState();
        Room[][] map = gameState.getMap();
        Room currentRoom = map[stats.getY()][stats.getX()];
        Scanner scanner = new Scanner(System.in);

        // beginning message
        String welcomeMessage = "You've just entered a house as Santa for Christmas. \nBut watch out, you must not wake up the kids in their rooms, otherwise the surprise will be spoiled.\nVenture throughout the map and find the cookies and letters that they left out by finding and using items to help you get past the dangerous rooms.\nGood luck, and Merry Christmas!\nType 1 to begin!";
            
        // printing beginning message
        printWithDelay(welcomeMessage);

        // beginning scanner
        // Scanner beginningScanner = new Scanner(System.in);

        // scanner for response
        int beginningResponse = scanner.nextInt();
        scanner.nextLine();

        if (beginningResponse == 1){

            // loading effect
            clearScreen();

            //loading effect
            String loading[] = {"Loading", "Loading.", "Loading..", "Loading..."};

            for(int i = 0; i < 3; i++){

                clearScreen();
                System.out.println(loading[0]);
                TimeUnit.MILLISECONDS.sleep(400);

                clearScreen();
                System.out.println(loading[1]);
                TimeUnit.MILLISECONDS.sleep(400);

                clearScreen();
                System.out.println(loading[2]);
                TimeUnit.MILLISECONDS.sleep(400);

                clearScreen();
                System.out.println(loading[3]);
                TimeUnit.MILLISECONDS.sleep(400);
            }

            clearScreen();
        }

        // closes the program if the answer is not 1
        else{
            System.exit(0);
        }




        while (gameState.getEnd() == false) {
            //gets current room
            currentRoom = map[stats.getY()][stats.getX()];
            //end condition
            if (stats.getX() == 0 && stats.getY() == 0 && stats.getCookie()) {
                boolean present1 = false;
                //asks user about the presents from the first kid
                while (present1 == false) {
                    printWithDelay("Santa, it's time for you to leave some presents. What was the present that the first kid asked for? ");
                    String gift1 = scanner.nextLine();
                    if (gift1.equals("laptop")) {
                        present1 = true;
                    }
                }
                //asks about the second present for the second kid
                boolean present2 = false;
                while (present2 == false) {
                    printWithDelay(" What was the present that the second kid asked for? ");
                    String gift2 = scanner.nextLine();
                    if (gift2.equals("pokemon cards")) {
                        present2 = true;
                    }
                }
                //win sequence
                printWithDelay("Congratulations, you ate the cookie and have succesfully left both correct presents for the kids. You've made these kids a wonderful christmas.");
                printWithDelay(stats.endMessage());

            } else {
                //end conditions not met yet

                //user is in dangerous room
                if (currentRoom.isDangerous()) {
                    //checks for silent item
                    if (stats.isSilent()) {
                        printWithDelay("close call, you've lost your silence and need to find a new room quickly");
                        stats.setSilent(false);
                        move(scanner, stats, map, stats.getX(), stats.getY());
                    //user loses if in dangerous room without silent item used
                    } else {
                        printWithDelay("You've been spotted by the person in the room. Yikes, now Christmas is ruined ):");
                        printWithDelay(stats.endMessage());
                        break;
                    }
                }

                //checks if new item claimable in the room
                if (currentRoom.hasItem()) {
                    //checsk if item has been claimed or not
                    if (currentRoom.getRoomItem().isConsumable()){
                        //user decides if they want the item or not
                        printWithDelay("This room has an item! Would you like to claim it? y/n note: choosing a index with an item will overwrite that item and it will not be reclaimable");
                        String answer = scanner.nextLine();

                        //if yes
                        if (answer.equals("y")) {
                            //item and hotbar info
                            printWithDelay(currentRoom.getRoomItem().toString());
                            stats.displayHotBar();

                            //user chooses what slot they want the item to go in
                            printWithDelay("Please enter an index from 0 to 2");
                            int index = scanner.nextInt();
                            scanner.nextLine();
                            stats.swapHotbar(index, currentRoom.getRoomItem());
                            currentRoom.getRoomItem().setConsumable(false);
                        }
                    }
                }

                


                // ------ PRINTING OPTIONS TO CHOOSE FROM -------
                String beginningQuestion = "What would you like to do?"; 
                printWithDelay(beginningQuestion);

                String hotbarQuestion  = "1: Check Hotbar";
                printWithDelay(hotbarQuestion);

                String consumeItemQuestion = "2: Consume an Item";
                printWithDelay(consumeItemQuestion);

                String moveRoomQuestion = "3: Move to a new room";
                printWithDelay(moveRoomQuestion);


                // --------------------------------------------------------

                //Checks Hotbar
                String response = scanner.nextLine();
                if (response.equals("1")) {

                    clearScreen();

                    stats.displayHotBar();
                } 
                
                //Consumes an item
                else if (response.equals("2")) {

                    clearScreen();

                    stats.displayHotBar();

                    // --- WHICH ITEM QUESTION ---
                    
                    String whichItemQuestion = "Which item would you like to consume (0, 1, or 2)";

                    printWithDelay(whichItemQuestion);

                    // ------------------

                    int index = scanner.nextInt();
                    scanner.nextLine();

                    Item item = stats.getHotbar()[index];

                    //clearing screen makes it hard for user to remember what index they wanted
                    // clearScreen();

                    // NOT VALID INDEX FOR HOT BAR
                    if (index > 2 || index < 0) {

                        // PRINTING MESSAGE
                        clearScreen();

                        String hotbarNotValidIndex = "that is not a valid index";

                        printWithDelay(hotbarNotValidIndex);

                        TimeUnit.MILLISECONDS.sleep(1000);

                        clearScreen();
                    }

                    // SHOWS IF SLOT IS EMPTY
                    if (item == null) {

                        // PRINTING 
                        clearScreen();

                        String hotbarEmptySlotCheck = "that's an empty slot";

                        printWithDelay(hotbarEmptySlotCheck);

                        TimeUnit.MILLISECONDS.sleep(1000);

                        clearScreen();
                    } 
                    // if cookie ->
                    else if (item instanceof Cookie) {
                        printWithDelay(((Cookie) item).consume(stats));
                    } 
                    // if note ->
                    else if (item instanceof Note) {
                        printWithDelay(((Note) item).getMessage());
                        stats.setLettersFound(stats.getLettersFound() + 1);
                    }  

                    // if flashlight ->
                    else if (item instanceof Flashlight) {

                        // printing

                        clearScreen();

                        String flashlightDirectionPrint = "enter a direction for the flashlight to point in (N, E, S, W)";

                        printWithDelay(flashlightDirectionPrint);
                        
                        // action of using flashlight
                        String direction = scanner.nextLine();
                        printWithDelay(((Flashlight) item).consume(stats.getX(), stats.getY(), direction, map));
                    } 

                    // if slippers ->
                    else if (item instanceof Slippers) {
                        ((Slippers) item).consume(stats);
                    }

                    //removes item from hotbar after use
                    stats.getHotbar()[index] = null;
                } 
                // option 3 -> move
                else if (response.equals("3")) {
                    move(scanner, stats, map, stats.getX(), stats.getY());
                } 
                // non-valid optino ->
                else {

                    // printing
                    clearScreen();

                    String mainOptionsNotValid = "that is not a valid option";

                    printWithDelay(mainOptionsNotValid);
                }
            }

        }
        scanner.close();
    }

    //method to move to new position
    public static void move(Scanner scanner, Stats stats, Room[][] map, int x, int y) throws InterruptedException{
        //asks question until valid response given
        boolean valid = false;

        while (valid == false) {
            //tries to get input
            try {

                //gets direction from user
                printWithDelay("Enter a direction, use N, E, S, or W");
                String direction = scanner.nextLine();

                // direction -> north
                if (direction.equals("N")) {
                    //checks if moving to empty room
                    if (map[y - 1][x] == null) {
                        printWithDelay("This is a wall");
                    
                    //valid response
                    } else {
                        //updates current position and rooms visited
                        stats.setY(stats.getY() - 1);
                        stats.setRoomsVisited(stats.getRoomsVisited() + 1);

                        //prints info about new room and position
                        printWithDelay("Now you are currently at (" + stats.getX() +  ", " + stats.getY() + ")");
                        printWithDelay(map[stats.getY()][stats.getX()].describe());

                        //confirms valid response
                        valid = true;
                    }

                // direction -> south
                } else if (direction.equals("S")) {
                    //checks for empty room
                    if (map[y + 1][x] == null) {
                        printWithDelay("This is a wall");

                    //valid response
                    } else {
                        //updates position
                        stats.setY(stats.getY() + 1);
                        stats.setRoomsVisited(stats.getRoomsVisited() + 1);

                        //gives new info on room and position
                        printWithDelay("Now you are currently at (" + stats.getX() + ", " + stats.getY() + ")");
                        printWithDelay(map[stats.getY()][stats.getX()].describe());

                        //confirms valid response
                        valid = true;
                    }

                // direction -> east
                } else if (direction.equals("E")) {
                    //checks for empty room
                    if (map[y][x + 1] == null) {
                        printWithDelay("This is a wall");
                    
                    //valid response
                    } else {
                        //updates position
                        stats.setX(stats.getX() + 1);
                        stats.setRoomsVisited(stats.getRoomsVisited() + 1);

                        //gives new info
                        printWithDelay("Now you are currently at (" + stats.getX() + ", " + stats.getY() + ")");
                        printWithDelay(map[stats.getY()][stats.getX()].describe());

                        //confirms valid response
                        valid = true;
                    }

                // direction -> west
                } else if (direction.equals("W")) {
                    //checks for empty room
                    if (map[y][x - 1] == null) {
                        printWithDelay("This is a wall");

                    //valid response
                    } else {
                        //updates position   
                        stats.setX(stats.getX() - 1);
                        stats.setRoomsVisited(stats.getRoomsVisited() + 1);

                        //gives new info about room
                        printWithDelay("Now you are currently at ( " + stats.getX() +  ", " + stats.getY() + ")");
                        printWithDelay(map[stats.getY()][stats.getX()].describe());

                        //confirms valid response
                        valid = true;
                    }
                }

            //exception for index that goes out of bounds
            } catch (ArrayIndexOutOfBoundsException e) {
                printWithDelay("That is a wall");
            }
        }
    }


    //  METHOD THAT CLEARS CONSOLE
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  

    //print method for typing effect in console
    public static void printWithDelay(String x) throws InterruptedException{
        for (int count=0; count < x.length(); count++){
            System.out.print(x.charAt(count));
            TimeUnit.MILLISECONDS.sleep(40);
        }
        System.out.println();
    }
}
