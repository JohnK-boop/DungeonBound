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
    
    public Inventory(int maxCapacity)
    {
        this.maxCapacity = maxCapacity;
        this.inv = new ArrayList<>();

        for (int i = 0; i < maxCapacity; i++) {
        this.inv.add(new EmptySlot());
}
    }
    
    protected boolean addItem(Item item)
    {
        if (this.inv.size() == maxCapacity)
        {
            Typewriter.printSlow(0, "Your inventory is full!", 1, 20);
            return false;
        }
        else
        {
            this.inv.add(item);
            return true;
        }
        
    }

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
    
    protected void removeItem(Item item)
    {
        this.inv.remove(item);
        this.inv.add(new EmptySlot());
    }

    protected void removeItemIndex(int index)
    {
        this.inv.remove(index);
        this.addItemIndex(new EmptySlot(), index);
    }
    
    protected Item getItem(int index)
    {
        return this.inv.get(index);
    }
    
    protected List<Item> showInventory(int slots) 
    {
        List<Item> temp = new ArrayList<>();
        if (slots == 0)
        {

            for(Item item : this.inv)
            {
                temp.add(item);
            }

            return temp;
        }
        else
        {
            for (int i = 0; i < slots && i < this.inv.size(); i++)
            {
                temp.add(this.inv.get(i));
            }
            return temp;
        }
    }

    public int getMaxCapacity()
    {
        return this.maxCapacity;
    }

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
