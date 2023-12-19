package src.Items;

public class Note extends Item{
    //attributes
    private String message;
    private String wish;

    //constructor
    public Note(String message, String wish) {
        super(true, "note");
        this.message = message;
        this.wish = wish;
    }
    
    //getters
    public String getMessage() {
        return message;
    }

    public String getWish() {
        return wish;
    }

    //setters
    public void setMessage(String message) {
        this.message = message;
    }
        
    public void setWish(String wish) {
        this.wish = wish;
    }

    //description of item
    public String toString() {
        return "this a valuable note from the kid (hint: remember the gift, it'll be important later on)";
    }
}
