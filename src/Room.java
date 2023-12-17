package src;

import src.Items.Item;

public class Room {
    private String roomName;
    private String description;
    private Item roomItem;
    private boolean dangerous;

    

    

    public Room(String roomName, Item roomItem, String description, boolean dangerous) {
        this.roomName = roomName;
        this.roomItem = roomItem;
        this.description = description;
    }

    public Room(String roomName, String description, boolean dangerous) {
        this.roomName = roomName;
        this.description = description;
        this.dangerous = dangerous;
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



}
