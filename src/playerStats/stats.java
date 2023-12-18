package src.playerStats;

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

    public void displayHotBar() {
        for (int i = 0; i < hotbar.length; i++) {
            if (hotbar[i] == null){
                System.out.println(i + ": " + "empty");
            } else {
                System.out.println(i + ": " + hotbar[i].getName());
            }
        }
    }

    public void swapHotbar(int x, Item item) {
        hotbar[x] = item;
    }
}
