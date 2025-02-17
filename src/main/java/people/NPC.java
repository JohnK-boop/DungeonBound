package people;

/**
 *
 * @author johnkufta
 */

import java.util.List;

import com.mycompany.dungeon.Typewriter;

import item.Item;
import locations.Location;

public class NPC {
    
    private String name;
    private Location location;
    private int maxCapacity;
    private Inventory inv;
    
    
    
    public NPC(String name, int maxCapacity)
    {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.inv = new Inventory(maxCapacity);
    }
    
    public void speak(String message, int delay)
    {
        System.out.println("\n" + this.name + ":");
        Typewriter.printSlow(message, delay, true);
    }
    
    public List<Item> getInv(int slots)
    {
        if (slots != 0)
        {
            return this.inv.showInventory(slots);
        }
        else
        {
            return this.inv.showInventory(maxCapacity);
        }
    }
    
    public Item getItem(int index)
    {
        return this.inv.getItem(index);
    }
    
    public void addItem(Item item)
    {
        this.inv.addItem(item);
    }
            
    public String getName()
    {
        return this.name;
    }
}
