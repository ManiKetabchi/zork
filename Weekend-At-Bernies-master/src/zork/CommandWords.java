package zork;
 
import java.util.ArrayList;
 
public class CommandWords {
    // A constant array that holds all valid command words
    private static final String validCommands[] = {
        "go", "quit", "help", "eat", "look",
        "drop", "inventory", "examine", "use",
        "open", "close", "attack"
    };
 
    private Inventory inventory;
 
    /**
     * Constructor - initialise the command words.
     */
    public CommandWords(Inventory inventory) {
        this.inventory = inventory;
    }
 
    /**
     * Check whether a given String is a valid command word. Return true if it is,
     * false if it isn't.
     **/
    public boolean isCommand(String aString) {
        for (String c : validCommands) {
            if (c.equals(aString))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }
 
    /*
     * Print all valid commands to System.out.
     */
    public void showAll() {
        for (String c : validCommands) {
            System.out.print(c + "  ");
        }
        System.out.println();
    }
 
    // Implementing commands
 
    public void go(String direction, Player player) {
        Room nextRoom = player.getCurrentRoom().nextRoom(direction);
        if (nextRoom != null) {
            player.setCurrentRoom(nextRoom);
            System.out.println(player.getCurrentRoom().longDescription());
        } else {
            System.out.println("There is no door to " + direction + "!");
        }
    }
 
    public void quit() {
        System.out.println("Thank you for playing. Goodbye!");
        System.exit(0);
    }
 
    public void help() {
        System.out.println("You are lost. You are alone. You wander around the space station.");
        System.out.println("Your command words are:");
        showAll();
    }
 
    public void eat() {
      int healthBenefit = item.getHealthBenefit();
      if (healthBenefit > 0) {
        player.increaseHealth(healthBenefit);
        player.removeFromInventory(item);
        System.out.println("You have eaten" + item.getName() + " and restored" + item.healthBenefit + "health points.");
    } else{
      System.out.println(item.getName() + " cannot be eaten.");
            }
    }
  }

    public void look(Player player) {
        System.out.println(player.getCurrentRoom().longDescription());
    }
 
    public void drop(Item item, Player player) {
        if (player.getInventory().removeItem(item) != null) {
            player.getCurrentRoom().addItem(item);
            System.out.println("You drop the " + item.getName() + " in the " + player.getCurrentRoom().getRoomName() + ".");
        } else {
            System.out.println("You don't have " + item.getName() + " in your inventory.");
        }
    }
 
    public void inventory(Player player) {
        System.out.println("You are carrying:");
        for (Item item : player.getInventory().getItems()) {
            System.out.println(item.getName() + ": " + item.getDescription());
        }
    }
 
    public void examine(Item item) {
        System.out.println("You examine the " + item.getName() + ": " + item.getDescription());
    }
 
    public void use(Item item) {
        System.out.println("You use the " + item.getName() + ".");
        // implement 
    }
 
    public void open(Item item) {
        if (item.isOpenable()) {
            System.out.println("You open the " + item.getName() + ".");
            item.open();
        } else {
            System.out.println("The " + item.getName() + " cannot be opened.");
        }
    }
 
    public void close(Item item) {
        if (item.isOpenable()) {
            System.out.println("You close the " + item.getName() + ".");
            // Implement 
        } else {
            System.out.println("The " + item.getName() + " cannot be closed.");
        }
    }
 
    public void attack(Item item) {
        System.out.println("You attack with the " + item.getName() + ".");
        // Implement 
    }

public class Player { // PLAYER CLASS
    private Room currentRoom;
    private Inventory inventory;

    public Player(Room startingRoom) {
        this.currentRoom = startingRoom;
        this.inventory = new Inventory(100); // MAXWEIGHT TO BE UPDATED
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public Inventory getInventory() {
        return inventory;
    }

    
}

}