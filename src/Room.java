package src;

import src.Items.Item;

public class Room {
    private String roomName;
    private Item roomItem;

    public Room(String roomName, Item roomItem) {
        this.roomName = roomName;
        this.roomItem = roomItem;
    }

    public String getRoomName() {
        return roomName;
    }
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
    public Item getRoomItem() {
        return roomItem;
    }
    public void setRoomItem(Item roomItem) {
        this.roomItem = roomItem;
    }


}
