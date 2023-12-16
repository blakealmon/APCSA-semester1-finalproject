package src.storyline;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import src.launch;
import src.playerStats.*;

public class tutorial {
    
    private boolean begin;
    private Scanner scanner;

    public tutorial(boolean begin, Scanner scanner){
        this.begin = begin;
        this.scanner = scanner;
    }


    public boolean getBegin(){
        return begin;
    }
    public void tutorialStart() throws InterruptedException{

        String welcome = "welcome to the game!\n";

        for (int count=0; count < welcome.length(); count++){
            System.out.print(welcome.charAt(count));
            TimeUnit.MILLISECONDS.sleep(40);
        }
        

        String statsHowTo = "You may type 'stats' anytime to see your stats! \nTry it now by typing 'stats' into the console!\n";

        for (int count=0; count < statsHowTo.length(); count++){
            System.out.print(statsHowTo.charAt(count));
            TimeUnit.MILLISECONDS.sleep(40);
        }


        // WILL ADD GAME LOOP AND REMOVE THIS IF STATEMENT FOR STATS

        String statsInput = scanner.nextLine();

        if(statsInput.equals("stats")){
            Stats myStats = new Stats();

            String playerStats = myStats.toString();

            

            for (int count=0; count < playerStats.length(); count++){
                System.out.print(playerStats.charAt(count));
                TimeUnit.MILLISECONDS.sleep(40);
            }
        }
        else{
            
            clearScreen();

            String badInput = "bad input. Try again";

            for (int count=0; count < badInput.length(); count++){
                System.out.print(statsHowTo.charAt(count));
                TimeUnit.MILLISECONDS.sleep(40);
            }

             TimeUnit.MILLISECONDS.sleep(750);

             tutorialStart();
        }
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
}
