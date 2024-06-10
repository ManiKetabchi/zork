package zork;

/**
 * Exit
 */
public class Exit extends OpenableObject {
  private String direction;
  private String adjacentRoom;
public static String NORTH = "North";
public static String SOUTH = "South";
public static String EAST = "East";
public static String WEST = "West";

  public Exit(String direction, String adjacentRoom, boolean isLocked, String keyId) {
    super(isLocked, keyId);
    this.direction = direction;
    this.adjacentRoom = adjacentRoom;
  }

  public Exit(String direction, String adjacentRoom, boolean isLocked, String keyId, Boolean isOpen) {
    super(isLocked, keyId, isOpen);
    this.direction = direction;
    this.adjacentRoom = adjacentRoom;
  }

  public Exit(String direction, String adjacentRoom) {
    this.direction = direction;
    this.adjacentRoom = adjacentRoom;
  }

  public String getDirection() {
    return direction;
  }

  public void setDirection(String direction) {
    this.direction = direction;
  }

  public String getAdjacentRoom() {
    return adjacentRoom;
  }

  public void setAdjacentRoom(String adjacentRoom) {
    this.adjacentRoom = adjacentRoom;
  }

  public void unlock(String keyId) {
    if (isLocked() && keyId != null && keyId.equals(getKeyId())) {
      setOpen(true);
      System.out.println("You have unlocked the door to the " + getDirection() + ".");
    } else {
      System.out.println("You don't have the right key to unlock this door.");
    }
  }
}

