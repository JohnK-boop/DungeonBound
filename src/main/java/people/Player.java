package people;

/**
 *
 * @author johnkufta
 */


import java.util.List;

import item.Item;

public class Player {
    
    private String name;
    private int build;
    // 0 : Knight  1 : Mage  2: Critter Rangler
    private Inventory inv = new Inventory(10);
    private int health;
    private int strength;
    private int gold;
    
    
    public Player(String name, int build)
    {
        this.name = name;
        this.build = build;
        this.gold = 0;
    }
    
    private void setName(String name)
    {
        this.name = name;
    }
    
    private void setBuild(int pClass)
    {
        this.build = build;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public int getBuild()
    {
        return this.build;
    }
    
    public List<Item> getInv()
    {
        return this.inv.showInventory(0);
    }
    
    public void addItem(Item item)
    {
        this.inv.addItem(item);
        
    }
    
    public void removeItem(Item item)
    {
        this.inv.removeItem(item);
    }
    
    public void announceItem(Item item)
    {
        System.out.println("\n_______________________________________\n\n"
                         + "You have obtained a " + item.getName() + "!\n"
                         + "_______________________________________");
        this.addItem(item);
    }
    
    public int getGold()
    {
        return this.gold;
    }
    
    public void buyItem(Item item)
    {
        this.gold =- item.getValue();
        
    }
    
}
