package zork;

public class Player {
        private Room currentRoom;
        private Inventory inventory;
        private int health;

    
        public Player(Room startingRoom) {
            this.currentRoom = startingRoom;
            this.inventory = new Inventory(100); 
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

   
    public boolean hasItem(String itemId) {
        return inventory.contains(itemId);
    }

  /*   public void interactWithItem(String itemName) {
        currentRoom.interactWithItem(itemName);
    }
*/
    public int getHealth() {
        return health;
    }

    public void increaseHealth(int amount) {
        this.health += amount;
    }
    }

