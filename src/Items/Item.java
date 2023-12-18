package src.Items;

public class Item {
    private boolean consumable;
    private String name;

    public boolean isConsumable() {
        return consumable;
    }

    public Item(boolean consumable, String name) {
        this.consumable = consumable;
        this.name = name;
    }

    public void setConsumable(boolean consumable) {
        this.consumable = consumable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item(boolean consumable) {
        this.consumable = consumable;
    }

    public String toString() {
        return "this is the base item";
    }

    
}
