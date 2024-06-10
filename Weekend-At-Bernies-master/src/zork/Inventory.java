package zork;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
  private ArrayList<Item> items;
  private int maxWeight;
  private int currentWeight;

  public Inventory(int maxWeight) {
    this.items = new ArrayList<Item>();
    this.maxWeight = maxWeight;
    this.currentWeight = 0;
  }

  public int getMaxWeight() {
    return maxWeight;
  }

  public int getCurrentWeight() {
    return currentWeight;
  }

  public boolean addItem(Item item) {
    if (item.getWeight() + currentWeight <= maxWeight)
      return items.add(item);
    else {
      System.out.println("There is no room to add the item.");
      return false;
    }
  }

public Item removeItem(Item item) {
  if (items.remove(item)) {
        currentWeight -= item.getWeight();
        return item;
    }
    return null; // Item not found in the inventory
}

public List<Item> getItems() {
    return items;
  }

}



