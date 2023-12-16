package src.Items;

public class Item {
    private boolean consumable;
    private String name;

    public boolean isConsumable() {
        return consumable;
    }

    public void setConsumable(boolean consumable, String name) {
        this.consumable = consumable;
        this.name = name;
    }

    public Item(boolean consumable) {
        this.consumable = consumable;
    }

    
}
