package src;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import src.playerStats.stats;
import src.storyline.tutorial;

public class launch {

    public static void main(String[] args) throws InterruptedException {

        String test = "type 1 to start -> only way to start\n";

        for (int count=0; count < test.length(); count++){
            System.out.print(test.charAt(count));
            TimeUnit.MILLISECONDS.sleep(40);
        }
        

        Scanner myScanner = new Scanner(System.in);

        int userInput = myScanner.nextInt();

        if(userInput == 1){

            String userResult = "you chose 1, starting simulation\n";

            for (int count=0; count < userResult.length(); count++){
                System.out.print(userResult.charAt(count));
                TimeUnit.MILLISECONDS.sleep(40);
            }
            

            // pause so user can read outputted string before clear of console
            TimeUnit.SECONDS.sleep(1);

            myScanner.close();
            testing();
        }
        else{
            String tryRerunning = "Try the input again by re-running the code. Your input was bad";

            for (int count=0; count < tryRerunning.length(); count++){
                System.out.print(tryRerunning.charAt(count));
                TimeUnit.MILLISECONDS.sleep(40);
            }
           
            myScanner.close();
            System.exit(0);

        }
        
            
        
    }

    public static void testing() throws InterruptedException{
        
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
        
        Scanner tutorialScanner = new Scanner(System.in);

        tutorial myTutorial = new tutorial(true, tutorialScanner);
        myTutorial.tutorialStart();
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  


    public String scannerStringInput(){

        Scanner statsInput = new Scanner(System.in);
        String theInput = statsInput.nextLine();

        statsInput.close();

        return theInput;

    }

   
}
