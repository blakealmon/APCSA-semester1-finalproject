package storyline;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import playerStats.*;

public class tutorial {
    
    private boolean begin;

    public tutorial(boolean begin){
        this.begin = begin;
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

        Scanner statsInput = new Scanner(System.in);
        String theInput = statsInput.nextLine();

        

        if(theInput.equals("stats")){
            stats myStats = new stats();

            String playerStats = myStats.toString();

            statsInput.close();

            for (int count=0; count < playerStats.length(); count++){
                System.out.print(playerStats.charAt(count));
                TimeUnit.MILLISECONDS.sleep(40);
            }
        }
        else{
            statsInput.close();
            
        }
    }
}
