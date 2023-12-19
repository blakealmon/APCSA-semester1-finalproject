package src.Items;

public class Item {
    //basic attributes
    private boolean consumable;
    private String name;



    //constructors
    public Item(boolean consumable, String name) {
        this.consumable = consumable;
        this.name = name;
    }

    public Item(boolean consumable) {
        this.consumable = consumable;
    }

    

    //getters
    public String getName() {
        return name;
    }

    public boolean isConsumable() {
        return consumable;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setConsumable(boolean consumable) {
        this.consumable = consumable;
    }

    

    //base description of items
    public String toString() {
        return "this is the base item";
    }

    
}
