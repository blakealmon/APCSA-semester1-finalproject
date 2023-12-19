package src.playerStats;

import java.util.concurrent.TimeUnit;

import src.Items.Item;

public class Stats {
    private int awakeLevel = 10;
    private Item[] hotbar = new Item[3];
    private int x = 0;
    private int y = 0;
    private boolean silent = false;
    private boolean cookie = false;

    public void setCookie(boolean cookie) {
        this.cookie = cookie;
    }

    public void setAwakeLevel(int awakeLevel) {
        this.awakeLevel = awakeLevel;
    }

    public void setHotbar(Item[] hotbar) {
        this.hotbar = hotbar;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSilent(boolean silent) {
        this.silent = silent;
    }

    public int getAwakeLevel() {
        return awakeLevel;
    }

    public Item[] getHotbar() {
        return hotbar;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isSilent() {
        return silent;
    }

    public boolean getCookie() {
        return cookie;
    }

    public void displayHotBar() throws InterruptedException {
        for (int i = 0; i < hotbar.length; i++) {
            if (hotbar[i] == null){

                // printing 
                String isEmptyPrint = i + ": " + "empty\n";

                for (int count=0; count < isEmptyPrint.length(); count++){
                    System.out.print(isEmptyPrint.charAt(count));
                    TimeUnit.MILLISECONDS.sleep(40);
                }

                
            } else {

                // printing
                String isItemPrint = i + ": " + hotbar[i].getName() + "\n";

                for (int count=0; count < isItemPrint.length(); count++){
                    System.out.print(isItemPrint.charAt(count));
                    TimeUnit.MILLISECONDS.sleep(40);
                }
            }

            
        }



    }

    public void swapHotbar(int x, Item item) {
        hotbar[x] = item;
    }

    //  METHOD THAT CLEARS CONSOLE
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  

    
}
