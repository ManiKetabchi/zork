package zork;
 
import java.util.Scanner;
 
public class Parser {
    private CommandWords commands; // holds all valid command words
    private Scanner in;
    private Inventory inventory;
 
    public Parser() {
        commands = new CommandWords();
        in = new Scanner(System.in);
        inventory = new Inventory(100); // Assuming maximum inventory weight is 100
    }
 
    public Command getCommand() throws java.io.IOException {
        String inputLine = "";
        String[] words;
 
        System.out.print("> "); // print prompt
 
        inputLine = in.nextLine();
 
        words = inputLine.split(" ");
 
        String word1 = words[0];
        String word2 = null;
        if (words.length > 1)
            word2 = words[1];
 
        if (commands.isCommand(word1)) {
            if (word1.equals("go") && word2 != null) {
                return new Command(word1, word2);
            } else if (word1.equals("quit")) {
                return new Command(word1, null);
            } else if (word1.equals("help")) {
                return new Command(word1, null);
            } else if (word1.equals("eat") && word2 != null) {
                Item item = inventory.findItem(word2);
                if (item != null) {
                    commands.eat(item);
                } else {
                    System.out.println("You don't have " + word2 + " in your inventory.");
                }
            } else if (word1.equals("look")) {
                return new Command(word1, null);
            } else if (word1.equals("drop") && word2 != null) {
                Item item = inventory.findItem(word2);
                if (item != null) {
                    commands.drop(item);
                } else {
                    System.out.println("You don't have " + word2 + " in your inventory.");
                }
            } else if (word1.equals("inventory")) {
                commands.inventory(inventory);
            } else if (word1.equals("examine") && word2 != null) {
                Item item = inventory.findItem(word2);
                if (item != null) {
                    commands.examine(item);
                } else {
                    System.out.println("You don't have " + word2 + " in your inventory.");
                }
            } else if (word1.equals("use") && word2 != null) {
                Item item = inventory.findItem(word2);
                if (item != null) {
                    commands.use(item);
                } else {
                    System.out.println("You don't have " + word2 + " in your inventory.");
                }
            } else if (word1.equals("open") && word2 != null) {
                Item item = inventory.findItem(word2);
                if (item != null) {
                    commands.open(item);
                } else {
                    System.out.println("You don't have " + word2 + " in your inventory.");
                }
            } else if (word1.equals("close") && word2 != null) {
                Item item = inventory.findItem(word2);
                if (item != null) {
                    commands.close(item);
                } else {
                    System.out.println("You don't have " + word2 + " in your inventory.");
                }
            } else if (word1.equals("attack") && word2 != null) {
                Item item = inventory.findItem(word2);
                if (item != null) {
                    commands.attack(item);
                } else {
                    System.out.println("You don't have " + word2 + " in your inventory.");
                }
            } else {
                return new Command(word1, word2);
            }
        } else {
            return new Command(null, word2);
        }
        return null; 
    }
}