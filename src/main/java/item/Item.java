package item;

/**
 *
 * @author johnkufta
 */

import java.util.*;

public abstract class Item {
    
    protected String name;
    protected String description;
    protected int goldValue;
    
    public Item(String name, String description, int goldValue)
    {
        
        this.name = name;
        this.description = description;
        this.goldValue = goldValue;
        
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public String getDescription()
    {
        return this.description;
    }
    
    public void getInfo()
    {
        System.out.println("Name: " + this.getName());
        System.out.println("Description " + this.getDescription());
    }
    
    public int getValue()
    {
        return this.goldValue;
    }
}
