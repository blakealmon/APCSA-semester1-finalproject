package src;

import src.Items.Item;

public class Room {
    //attributes
    private String roomName;
    private String description;
    private Item roomItem;
    private boolean dangerous;
    private String secondaryDescription;
    private boolean firstEncounter = true;

    //constructor for item and no item
    public Room(String roomName, Item roomItem, String description, boolean dangerous, String secondary) {
        this.roomName = roomName;
        this.roomItem = roomItem;
        this.description = description;
        this.secondaryDescription = secondary;
    }

    public Room(String roomName, String description, boolean dangerous, String secondary) {
        this.roomName = roomName;
        this.description = description;
        this.dangerous = dangerous;
        this.secondaryDescription = secondary; 
    }

    //gives different description based on whether you've been there before
    public String describe() {
        if (firstEncounter == true) {
            firstEncounter = false;
            return description;
        } else {
            return secondaryDescription;
        }
    }


    //getters
    public String getRoomName() {
        return roomName;
    }

    public Item getRoomItem() {
        return roomItem;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDangerous() {
        return dangerous;
    }

    public boolean hasItem() {
        return roomItem != null;
    }

    public String getSecondaryDescription() {
        return secondaryDescription;
    }

    public boolean isFirstEncounter() {
        return firstEncounter;
    }


    //setters
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
    public void setRoomItem(Item roomItem) {
        this.roomItem = roomItem;
    }
        
    public void setDescription(String description) {
        this.description = description;
    }

    public void setDangerous(boolean dangerous) {
        this.dangerous = dangerous;
    }

    public void setSecondaryDescription(String secondaryDescription) {
        this.secondaryDescription = secondaryDescription;
    }

    public void setFirstEncounter(boolean firstEncounter) {
        this.firstEncounter = firstEncounter;
    }



}
