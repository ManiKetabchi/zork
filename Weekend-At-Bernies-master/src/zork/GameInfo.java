package zork;

public class GameInfo {
    public static String[] introMessage;
    
    public static String introMsg() {
        return "Welcome to \\\"Space Zork: Galactic Exploration,\\\" a text-based adventure set in the vast reaches of space. In this game, you are an explorer tasked with finding your lost friend, who has gone missing on this spaceship. As you step through the airlock and into the darkened corridors of the space station, you are drawn into a world of danger where every corner holds potential discoveries, from advanced artifacts to remnants of the station's past inhabitants. Your mission is to explore, gather resources, and solve puzzles to find your lost friend.";
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
    }
}
