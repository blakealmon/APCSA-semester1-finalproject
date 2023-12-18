import src.playerStats.Stats;
import src.GameState;
import java.util.Scanner;
import src.Room;
import src.Items.*;
public class Play {
    public static void main(String[] args) {
        Stats stats = new Stats();
        GameState gameState = new GameState();
        Room[][] map = gameState.getMap();
        Room currentRoom = map[stats.getY()][stats.getX()];
        Scanner scanner = new Scanner(System.in);

        //beginning message
        System.out.println("You've just entered a house as Santa for Christmas. But watch out, you must not wake up the kids in their rooms, otherwise the surprise will be spoiled. Venture throughout the map and find the cookies they left out in the kitchen by finding items to help you get past the dangerous room. Good luck, and Merry Christmas!");

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

                System.out.println("What would you like to do?");
                System.out.println("1: Check Hotbar");
                System.out.println("2: Consume an Item");
                System.out.println("3 Move to a new room");

                String response = scanner.nextLine();
                if (response.equals("1")) {
                    stats.displayHotBar();
                } else if (response.equals("2")) {
                    stats.displayHotBar();
                    System.out.println("Which item would you like to consume (0, 1, or 2)");
                    int index = scanner.nextInt();
                    scanner.nextLine();
                    Item item = stats.getHotbar()[index];
                    if (index > 2 || index < 0) {
                        System.out.println("that is not a valid index");
                    }
                    if (item == null) {
                        System.out.println("that's an empty slot");
                    } else if (item instanceof Cookie) {
                        System.out.println(((Cookie) item).consume(stats));
                    } else if (item instanceof Note) {
                        ((Note) item).consume();
                    }  else if (item instanceof Flashlight) {
                        System.out.println("enter a direction for the flashlight to point in (N, E, S, W)");
                        String direction = scanner.nextLine();
                        System.out.println(((Flashlight) item).consume(stats.getX(), stats.getY(), direction, map));
                    } else if (item instanceof Slippers) {
                        ((Slippers) item).consume(stats);
                    }
                    stats.getHotbar()[index] = null;
                } else if (response.equals("3")) {
                    move(scanner, stats, map, stats.getX(), stats.getY());
                } else {
                    System.out.println("that is not a valid option");
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
}
