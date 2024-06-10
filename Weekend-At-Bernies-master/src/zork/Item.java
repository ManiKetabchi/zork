package zork;

public class Item extends OpenableObject {
  private int weight;
  private String name;
  private String description;
  private boolean isOpenable;
  public Inventory inventory;
  private Boolean isStationary;
  private int healthBenefit;

  public Item(int weight, String name, boolean isOpenable, String description) {
    this.weight = weight;
    this.name = name;

    this.isOpenable = isOpenable;
    this.description = description;
    this.isStationary = isStationary;
    this.healthBenefit =  healthBenefit;
    if (isOpenable)
    inventory = new Inventory(100);
  }

  public void open() {
    if (!isOpenable)
      System.out.println("The " + name + " cannot be opened.");
  }

  public String getDescription() {
    return description;
  }

  public int getWeight() {
    return weight;
  }
 

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isOpenable() {
    return isOpenable;
  }

  public void setOpenable(boolean isOpenable) {
    this.isOpenable = isOpenable;
  }
  public boolean isStationary() {
    return isStationary;
  }
  public boolean addItem(Item item) {
    if (isOpenable)
      return inventory.addItem(item);
    else 
      return false;
}
public void stationaryObject(Item item){
  
}

public int getHealthBenefit() {
  return healthBenefit;
}
public Item removeItem(Item item){
  if(isOpenable)
    return inventory.removeItem(item);
  else
    System.out.println("You cannot take the " + item.name + " from the " + name);
 
  return null;
}
}
