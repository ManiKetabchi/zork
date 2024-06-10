package zork;

import java.util.ArrayList;

public class Room {

  private String roomName;
  private String longDescription;
  private String shortDescription;
  private ArrayList<Exit> exits;
  private Inventory inventory;

  public ArrayList<Exit> getExits() {
    return exits;
  }

  public void setExits(ArrayList<Exit> exits) {
    this.exits = exits;
  }

  /**
   * Create a room described "description". Initially, it has no exits.
   * "description" is something like "a kitchen" or "an open court yard".
   */
  public Room(String description) {
    this.longDescription = description;
    exits = new ArrayList<Exit>();
  }

  public Room() {
    roomName = "DEFAULT ROOM";
    longDescription = "DEFAULT DESCRIPTION";
    shortDescription = "DEFAULT DESCRIPTION";

    exits = new ArrayList<Exit>();
    inventory = new Inventory(Integer.MAX_VALUE);
  }

  public void addExit(Exit exit) throws Exception {
    exits.add(exit);
  }

  /**
   * Return the description of the room (the one that was defined in the
   * constructor).
   */
  public String shortDescription() {
    return "Room: " + roomName + "\n\n" + shortDescription;
  }

  /**
   * Return a long description of this room, on the form: You are in the kitchen.
   * Exits: north west
   */
  public String longDescription() {

    return "Room: " + roomName + "\n\n" +longDescription + "\n" + exitString();
  }

  /**
   * Return a string describing the room's exits, for example "Exits: north west
   * ".
   */

   public void pressButton() {
    if (this.getRoomName().equals("Captain's Quarters")) {
       
        System.out.println("You press the red button, it opens the door to the bridge.");
        unlockExits("1111");
    } else {
        System.out.println("There is no button to press in this room.");
    }

    if (this.getRoomName().equals("Droid Maintenence")) {
       
      System.out.println("You press the red button, it opens the door to the supply room");
      unlockExits("4444");
  } else {
      System.out.println("There is no button to press in this room.");
  }
}

  private String exitString() {
    String returnString = "\nExits: ";
    for (Exit exit : exits) {
      returnString += exit.getDirection() + " ";
    }

    return returnString;
  }
  private void unlockExits(String keyId) {
    for (Exit exit : exits) {
        if (exit.isLocked() && exit.getKeyId().equals(keyId)) {
            exit.unlock(keyId);
        }
      }
      }
  /**
   * Return the room that is reached if we go from this room in direction
   * "direction". If there is no room in that direction, return null.
   */
  public Room nextRoom(String direction) {
    try {
      for (Exit exit : exits) {

        if (exit.getDirection().equalsIgnoreCase(direction)) {
          String adjacentRoom = exit.getAdjacentRoom();

          return Game.roomMap.get(adjacentRoom);
        }

      }
    } catch (IllegalArgumentException ex) {
      System.out.println(direction + " is not a valid direction.");
      return null;
    }

    System.out.println(direction + " is not a valid direction.");
    return null;
  }

  public void captainsQuarters(){

  }
  
  public String getRoomName() {
    return roomName;
  }

  public void setRoomName(String roomName) {
    this.roomName = roomName;
  }

  public String getLongDescription() {
    return longDescription;
  }

  public void setLongDescription(String description) {
    this.longDescription = description;
  }

  public String getShortDescription() {
    return shortDescription;
  }

  public void setShortDescription(String description) {
    this.shortDescription = description;
  }

public boolean addItem(Item item) {
    return inventory.addItem(item);
}

public Item removeItem(Item item){
    return inventory.removeItem(item);
}
}
