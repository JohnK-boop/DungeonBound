package item;

import static com.mycompany.dungeon.Typewriter.printSlow;

/**
 *
 * @author johnkufta
 */

public abstract class Item {
    
    protected String name;
    protected String description;
    protected int goldValue;
    
    /**
     * Creates an Item
     * @param name name of item
     * @param description description of item
     * @param goldValue Value of item
     */
    public Item(String name, String description, int goldValue)
    {     
        this.name = name;
        this.description = description;
        this.goldValue = goldValue;   
    }
    
    /**
     * Get the name of an Item
     * @return String name
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * Returns description of item
     * @return String description
     */
    public String getDescription()
    {
        return this.description;
    }

    /**
     * Prints the Information of an item
     * Name: 
     * Description: 
     * Gold Value: 
     */
    public void getInfo()
    {
        printSlow(0, "Name: " + this.getName(), 1, 30);
        printSlow(0, "Description " + this.getDescription(), 1, 30);
        printSlow(0, "Gold Value: " + this.getValue(), 1, 30);
    }
    
    /**
     * Returns the Value of the item
     * @return int goldValue
     */
    public int getValue()
    {
        return this.goldValue;
    }
}
