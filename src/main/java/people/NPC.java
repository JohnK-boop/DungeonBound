package people;

/**
 *
 * @author johnkufta
 */

import java.util.List;

import com.mycompany.dungeon.Typewriter;

import item.EmptySlot;
import item.Item;
import locations.Location;

public class NPC {
    
    private String name;
    private Location location;
    private int maxCapacity;
    private Inventory inv;
    
    /**
     * Creates an NPC
     * @param name name
     * @param maxCapacity Inventory Capacity of NPC
     */
    public NPC(String name, int maxCapacity)
    {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.inv = new Inventory(maxCapacity);
    }
    
    /**
     * Prints the NPC name and a message
     *        |Example|        
     * Jerry:
     * Hello!
     * @param message Message the NPC will say
     * @param delay Delay of the printSlow command for message
     */
    public void speak(String message, int delay)
    {
        System.out.println("\n" + this.name + ":");
        Typewriter.printSlow(1, message, 1, delay);
    }
    
    /**
     * Gets the Inventory of the NPC at the specified Indesies
     * @param slotStart Start Index
     * @param slotEnd End Index
     * @return List of Items
     */
    public List<Item> getInv(int slotStart, int slotEnd)
    {
        if (slotStart != 0 && slotStart != 0)
        {
            return this.inv.showInventory(slotStart, slotEnd);
        }
        else
        {
            return this.inv.showInventory(0, 0);
        }
    }

    /**
     * Checks to see if the specified inventory slot has an item
     * @param index Inventory index
     * @return true if has Item | false if EmptySlot
     */
    public boolean hasItem(int index)
    {
        if(this.inv.getItem(index) instanceof EmptySlot)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    /**
     * Gets an Item at specified index
     * @param index Inventory index
     * @return Item
     */
    public Item getItem(int index)
    {
        return this.inv.getItem(index);
    }

    /**
     * Adds an Item to the end of the inventory
     * Only really used for giving EmptySlots when creating inventory
     * @param item Item added
     */

    public void addItem(Item item)
    {
        this.inv.addItem(item);
    }
    
    /**
     * Adds an item to the inventory at the specified index
     * @param item Item Given
     * @param index Inventory Index
     */
    public void addItemIndex(Item item, int index)
    {
        this.inv.addItemIndex(item, index);
    }
            
    /**
     * Gets the name of the NPC
     * @return String name
     */
    public String getName()
    {
        return this.name;
    }

//Edit base remove code to change Slot to empty instead of adding a new one
    public void removeItem(Item item)
    {
        this.inv.removeItem(item);
    }

    /**
     * Removes an item at the specified index
     * @param index Inventory index
     */
    public void removeItemIndex(int index)
    {
        this.inv.removeItemIndex(index);
    }
}
