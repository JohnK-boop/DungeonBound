package people;

/**
 *
 * @author johnkufta
 */

import java.util.ArrayList;
import java.util.List;

import com.mycompany.dungeon.Typewriter;

import item.EmptySlot;
import item.Item;

public class Inventory {
    
    private List<Item> inv;
    private int maxCapacity;
    
    /**
     * Creates an Inventory with the specified Capacity
     * @param maxCapacity Maximum amount of inventory slots
     */
    public Inventory(int maxCapacity)
    {
        this.maxCapacity = maxCapacity;
        this.inv = new ArrayList<>();

        for (int i = 0; i < maxCapacity; i++) {
        this.inv.add(new EmptySlot());
}
    }
    
    /**
     * Adds an Item to the end of the inventory returns true or false if it worked
     * Only really used for giving EmptySlots when creating inventory
     * @param item Item added
     */
    protected void addItem(Item item)
    {
        if (this.inv.size() == maxCapacity)
        {
            Typewriter.printSlow(0, "Your inventory is full!", 1, 20);
        }
        else
        {
            this.inv.add(item);
        }
        
    }

    /**
     * Adds an Item to a Specific Index (No return)
     * @param item Item added
     * @param index Inventory index
     */
    protected void addItemIndex(Item item, int index)
    {
        try
        {
            this.inv.add(index, item);
        }
        catch (ArrayIndexOutOfBoundsException exception)
        {
            System.out.println("Error when adding to index");
        }
    }
    
    /**
     * Removes THE FIRST INSTANCE of the Specified Item from inventory 
     * @param item Item that is removed
     */
    protected void removeItem(Item item)
    {
        int index = this.inv.indexOf(item);
        if (index != -1) 
        {
            this.inv.set(index, new EmptySlot());
        }
    }

    /**
     * Removes Item at the specified index and replaces it with an Empty slot
     * @param index Inventory index
     */
    protected void removeItemIndex(int index)
    {
        this.inv.remove(index);
        this.addItemIndex(new EmptySlot(), index);
    }

    /**
     * Removes ALL instances of the specified item
     * @param item Item the is removed
     */
    protected void removeAllItem(Item item)
    {
        for (int i = 0; i < this.inv.size(); i++) 
        {
            if (this.inv.get(i).equals(item)) 
            {
                this.inv.set(i, new EmptySlot());  // Replace with EmptySlot
            }
        }
    }
    
    /**
     * Gets Item at specified index
     * @param index Inventory index
     * @return Item at Inventory index
     */
    protected Item getItem(int index)
    {
        return this.inv.get(index);
    }
    
    /**
     * Shows the Inventory at the Specified Inventory index slots
     * @param slotStart Start inventory index
     * @param slotEnd End inventory index
     * @return List of Item of items at those slots
     */
    protected List<Item> showInventory(int slotStart, int slotEnd) 
    {
        List<Item> temp = new ArrayList<>();
        if (slotStart == 0 && slotEnd == 0)
        {

            for(Item item : this.inv)
            {
                temp.add(item);
            }

            return temp;
        }
        else
        {
            for (int i = slotStart; i <= slotEnd && i < this.inv.size(); i++)
            {
                temp.add(this.inv.get(i));
            }
            return temp;
        }
    }

    /**
     * Gets the Inventory Max Capacity
     * @return int How many slots are in the inventory
     */
    public int getMaxCapacity()
    {
        return this.maxCapacity;
    }

    /**
     * Checks if inventory has an item at index
     * @param index Inventory Index that will be checked
     * @return true if the slot has an item that IS NOT an EmptSlot
     */
    public boolean hasItem(int index)
    {
        if(this.inv instanceof EmptySlot)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    /**
     * Checks to see if the Specified inventory has a free slot
     * @return true if Inventory has slots free
     */
    public boolean hasFreeSlot()
    {
        for(int i = 0; i < this.maxCapacity; i++)
        {
            if(this.getItem(i) instanceof EmptySlot)
            {
                return true;
            }
        }

        return false;
    }

//Maybe make a way to check if it has a free slot from within the method
    /**
     * Returns free slot of Inventory
     * (Check with hasFreeSlot first to make sure it has free slot
     * else return will be 999999 if inventory is full)
     * @return slot index
     */
    public int getFreeSlot()
    {
        for(int i = 0; i < this.maxCapacity; i++)
        {
            if(this.getItem(i) instanceof EmptySlot)
            {
                return i;
            }
        }
        return 999999;
    }

}
