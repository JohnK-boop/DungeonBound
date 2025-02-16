package people;

/**
 *
 * @author johnkufta
 */

import com.mycompany.dungeon.Typewriter;
import item.Item;
import java.util.*;
import java.util.List;
import java.util.ArrayList;

public class Inventory {
    
    private List<Item> inv;
    private int maxCapacity;
    
    public Inventory(int maxCapacity)
    {
        this.maxCapacity = maxCapacity;
        this.inv = new ArrayList<>();
    }
    
    protected boolean addItem(Item item)
    {
        if (this.inv.size() == maxCapacity)
        {
            Typewriter.printSlow("Your inventory is full!", 20, true);
            return false;
        }
        else
        {
            this.inv.add(item);
            return true;
        }
        
    }
    
    protected void removeItem(Item item)
    {
        this.inv.remove(item);
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
    
    
}
