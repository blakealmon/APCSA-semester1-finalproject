import src.playerStats.Stats;
import src.GameState;
import java.util.Scanner;
import src.Room;
import src.Items.*;
import java.util.concurrent.TimeUnit;

public class Play {
    public static void main(String[] args) throws InterruptedException {
        Stats stats = new Stats();
        GameState gameState = new GameState();
        Room[][] map = gameState.getMap();
        Room currentRoom = map[stats.getY()][stats.getX()];
        Scanner scanner = new Scanner(System.in);

        // beginning message
        String welcomeMessage = "You've just entered a house as Santa for Christmas. \nBut watch out, you must not wake up the kids in their rooms, otherwise the surprise will be spoiled.\nVenture throughout the map and find the cookies they left out in the kitchen by finding items to help you get past the dangerous room.\nGood luck, and Merry Christmas!\nType 1 to begin!\n";
            
        // printing beginning message
        for (int count=0; count < welcomeMessage.length(); count++){
            System.out.print(welcomeMessage.charAt(count));
            TimeUnit.MILLISECONDS.sleep(40);
        }

        // beginning scanner
        Scanner beginningScanner = new Scanner(System.in);

        // scanner for response
        int beginningResponse = beginningScanner.nextInt();

        //closing scanner
        beginningScanner.close();

        if(beginningResponse == 1){

            // loading effect
            clearScreen();

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
            currentRoom = map[stats.getY()][stats.getX()];
            //end condition
            if (stats.getX() == 0 && stats.getY() == 0 && stats.getCookie()) {
                boolean present1 = false;
                while (present1 == false) {
                    System.out.println("Santa, it's time for you to leave some presents. What was the present that the first kid asked for? ");
                    String gift1 = scanner.nextLine();
                    if (gift1.equals("laptop")) {
                        present1 = true;
                    }
                }
                boolean present2 = false;
                while (present2 == false) {
                    System.out.println(" What was the present that the second kid asked for? ");
                    String gift2 = scanner.nextLine();
                    if (gift2.equals("pokemon cards")) {
                        present2 = true;
                    }
                }
                System.out.println("Congratulations, you ate the cookie and have succesfully left both corret presents for the kids. You're made these kids a wonderful christmas.");
            } else {
                if (currentRoom.isDangerous()) {
                    if (stats.isSilent()) {
                        System.out.println("close call, you've lost your silence and need to find a new room quickly");
                        stats.setSilent(false);
                        move(scanner, stats, map, stats.getX(), stats.getY());
                    } else {
                        System.out.println("You've been spotted by the person in the room. Yikes, now Christmas is ruined ):");
                        break;
                    }
                }

                if (currentRoom.hasItem()) {
                    if (currentRoom.getRoomItem().isConsumable()){
                        System.out.println("This room has an item! Would you like to claim it? y/n note: choosing a index with an item will overwrite that item and it will not be reclaimable");
                        String answer = scanner.nextLine();
                        if (answer.equals("y")) {
                            System.out.println(currentRoom.getRoomItem().toString());
                            stats.displayHotBar();
                            System.out.println("Please enter an index from 0 to 2");
                            int index = scanner.nextInt();
                            scanner.nextLine();
                            stats.swapHotbar(index, currentRoom.getRoomItem());
                            currentRoom.getRoomItem().setConsumable(false);
                        }
                    }
                }

                


                // ------ PRINTING OPTIONS TO CHOOSE FROM --------

                

                // clears console
        

                String beginningQuestion = "What would you like to do?\n";
               
                for (int count=0; count < beginningQuestion.length(); count++){
                    System.out.print(beginningQuestion.charAt(count));
                    TimeUnit.MILLISECONDS.sleep(40);
                }

                String hotbarQuestion  = "1: Check Hotbar\n";

                for (int count=0; count < hotbarQuestion.length(); count++){
                    System.out.print(hotbarQuestion.charAt(count));
                    TimeUnit.MILLISECONDS.sleep(40);
                }

                String consumeItemQuestion = "2: Consume an Item\n";

                for (int count=0; count < consumeItemQuestion.length(); count++){
                    System.out.print(consumeItemQuestion.charAt(count));
                    TimeUnit.MILLISECONDS.sleep(40);
                }

                String moveRoomQuestion = "3: Move to a new room\n";

                for (int count=0; count < moveRoomQuestion.length(); count++){
                    System.out.print(moveRoomQuestion.charAt(count));
                    TimeUnit.MILLISECONDS.sleep(40);
                }

                // --------------------------------------------------------


                String response = scanner.nextLine();

                if (response.equals("1")) {

                    clearScreen();

                    stats.displayHotBar();
                } 
                
                else if (response.equals("2")) {

                    clearScreen();

                    stats.displayHotBar();

                    // --- WHICH ITEM QUESTION ---

                    clearScreen();
                    
                    String whichItemQuestion = "Which item would you like to consume (0, 1, or 2)\n";

                    for (int count=0; count < whichItemQuestion.length(); count++){
                        System.out.print(whichItemQuestion.charAt(count));
                        TimeUnit.MILLISECONDS.sleep(40);
                    }

                    // ------------------

                    int index = scanner.nextInt();

                    scanner.nextLine();
                    Item item = stats.getHotbar()[index];

                    clearScreen();

                    // NOT VALID INDEX FOR HOT BAR
                    if (index > 2 || index < 0) {

                        // PRINTING MESSAGE
                        clearScreen();

                        String hotbarNotValidIndex = "that is not a valid index\n";

                        for (int count=0; count < hotbarNotValidIndex.length(); count++){
                            System.out.print(hotbarNotValidIndex.charAt(count));
                            TimeUnit.MILLISECONDS.sleep(40);
                        }

                        TimeUnit.MILLISECONDS.sleep(1000);

                        clearScreen();
                    }

                    // SHOWS IF SLOT IS EMPTY
                    if (item == null) {

                        // PRINTING 
                        clearScreen();

                        String hotbarEmptySlotCheck = "that's an empty slot\n";

                        for (int count=0; count < hotbarEmptySlotCheck.length(); count++){
                            System.out.print(hotbarEmptySlotCheck.charAt(count));
                            TimeUnit.MILLISECONDS.sleep(40);
                        }

                        TimeUnit.MILLISECONDS.sleep(1000);

                        clearScreen();
                    } 
                    // if cookie ->
                    else if (item instanceof Cookie) {

                        System.out.println(((Cookie) item).consume(stats));
                    } 
                    // if note ->
                    else if (item instanceof Note) {

                        ((Note) item).consume();
                    }  

                    // if flashlight ->
                    else if (item instanceof Flashlight) {

                        // printing

                        clearScreen();

                        String flashlightDirectionPrint = "enter a direction for the flashlight to point in (N, E, S, W)\n";

                        for (int count=0; count < flashlightDirectionPrint.length(); count++){
                            System.out.print(flashlightDirectionPrint.charAt(count));
                            TimeUnit.MILLISECONDS.sleep(40);
                        }
                        
                        // action of using flashlight
                        String direction = scanner.nextLine();
                        System.out.println(((Flashlight) item).consume(stats.getX(), stats.getY(), direction, map));
                    } 

                    // if slippers ->
                    else if (item instanceof Slippers) {
                        ((Slippers) item).consume(stats);
                    }

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

                    for (int count=0; count < mainOptionsNotValid.length(); count++){
                        System.out.print(mainOptionsNotValid.charAt(count));
                        TimeUnit.MILLISECONDS.sleep(40);
                    }
                }
            }

        }


        scanner.close();
    }

    public static void move(Scanner scanner, Stats stats, Room[][] map, int x, int y) {
        boolean valid = false;
        while (valid == false) {
            try {
                System.out.println("Enter a direction, use N, E, S, or W");
                String direction = scanner.nextLine();
                if (direction.equals("N")) {
                    if (map[y - 1][x] == null) {
                        System.out.println("This is a wall");
                    } else {
                        stats.setY(stats.getY() - 1);
                        System.out.println("Now you are currently at (" + stats.getX() +  ", " + stats.getY() + ")");
                        System.out.println(map[stats.getY()][stats.getX()].getDescription());
                        valid = true;
                    }
                } else if (direction.equals("S")) {
                    if (map[y + 1][x] == null) {
                        System.out.println("This is a wall");
                    } else {
                        stats.setY(stats.getY() + 1);
                        System.out.println("Now you are currently at (" + stats.getX() + ", " + stats.getY() + ")");
                        System.out.println(map[stats.getY()][stats.getX()].getDescription());
                        valid = true;
                    }
                } else if (direction.equals("E")) {
                    if (map[y][x + 1] == null) {
                        System.out.println("This is a wall");
                    } else {
                        stats.setX(stats.getX() + 1);
                        System.out.println("Now you are currently at (" + stats.getX() + ", " + stats.getY() + ")");
                        System.out.println(map[stats.getY()][stats.getX()].getDescription());
                        valid = true;
                    }
                } else if (direction.equals("W")) {
                    if (map[y][x - 1] == null) {
                        System.out.println("This is a wall");
                    } else {
                        valid = true;
                        stats.setX(stats.getX() - 1);
                        System.out.println("Now you are currently at ( " + stats.getX() +  ", " + stats.getY() + ")");
                        System.out.println(map[stats.getY()][stats.getX()].getDescription());
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("That is a wall");
            }
        }
    }


    //  METHOD THAT CLEARS CONSOLE
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
}
