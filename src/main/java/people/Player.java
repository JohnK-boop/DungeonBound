package people;

import java.util.List;

import static com.mycompany.dungeon.Typewriter.printSlow;

import item.Item;

public class Player {
    
    private String name;
    private int build;
    // 0 : Knight  1 : Mage  2: Critter Rangler
    private Inventory inv = new Inventory(10);
    private int health;
    private int strength;
    private int gold;
    
    /**
     * Creates a player
     * Gold will be auto set to 0
     * @param name name of player
     * @param build Build of the player
     */
    public Player(String name, int build)
    {
        this.name = name;
        this.build = build;
        this.gold = 0;
    }
    
    /**
     * Changes the name of the Player
     * @param name name
     */
    private void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Changes the build of the Player
     * @param pClass Build 0 : Knight  1 : Mage  2: Critter Rangler
     */
    private void setBuild(int pClass)
    {
        this.build = build;
    }
    
    /**
     * Gets the name of the Player
     * @return String name
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * Gets the build of the player
     * @return int buid
     */
    public int getBuild()
    {
        return this.build;
    }
    
    /**
     * Gets the full inventory of the Player in a list
     * @return List of Items
     */
    public List<Item> getInv()
    {
        return this.inv.showInventory(0, 0);
    }
    
    /**
     * Adds an Item and the specified index
     * @param item Item
     * @param index Inventory Index
     */
    public void addItemIndex(Item item, int index)
    {
        this.inv.addItemIndex(item, index);
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
     * Removes THE FIRST INSTANCE of the Specified Item from inventory 
     * @param item Item that is removed
     */
    public void removeItem(Item item)
    {
        this.inv.removeItem(item);
    }

    /**
     * Removes Item at the specified index and replaces it with an Empty slot
     * @param index Inventory index
     */
    public void removeItemIndex(int index)
    {
        this.inv.removeItemIndex(index);
    }
    
    /**
     * Give an item to the player at the earliest free slot
     * Prints Inventory is full if not
     * Returns 1 if worked
     * Returns 0 if inventory is full
     * @param item Item given
     * @return If it worked
     */
    public int announceItem(Item item)
    {
        if(hasFreeSlot())
        {
            int index = getFreeSlot();
            System.out.println("\n_______________________________________\n\n"
                            + "You have obtained a " + item.getName() + "!\n"
                             + "_______________________________________");
            this.addItemIndex(item, index);
            return 1;
        }
        else
        {
            printSlow(0, "Your inventory is full!", 1, 20);
            return 0;
        }
        
    }
    
    /**
     * Gets the gold of the Player
     * @return int gold
     */
    public int getGold()
    {
        return this.gold;
    }

    /**
     * Changes the amount of gold the player has
     * (CAN BE NEGATIVE)
     * @param goldChange gold change amount
     */
    public void changeGold(int goldChange)
    {
        this.gold += goldChange;
    }

//Add a way to check if too poor so we can use buyItem for everything, including price check
    /**
     * Removes gold and adds item to closest EmptySlot
     * Returns 1 if worked
     * Returns 0 if not
     * @param item Item to buy
     * @return if had free slot
     */
    public int buyItem(Item item)
    {
        if(hasFreeSlot())
        {
            this.gold =- item.getValue();
            int index = getFreeSlot();
            this.addItemIndex(item, index);
            return 1;
        }
        else
        {
            printSlow(0, "Your inventory is full!", 1, 20);
            return 0;
        }

    }

    /**
     * 
     * @return
     */
    public boolean hasFreeSlot()
    {
        return this.inv.hasFreeSlot();
    }

    /**
     * Returns free slot of Inventory
     * (Check with hasFreeSlot first to make sure it has free slot)
     * else return will be 999999 if inventory is full)
     * @return slot index
     */
    public int getFreeSlot()
    {
        return this.inv.getFreeSlot();
    }

//Implemented later
    /**
     * Update all Player information after turn
     */
    public void update()
    {
        for(int i = 0; i < this.inv.getMaxCapacity(); i++)
        {
            if(this.inv.getItem(i) == null)
            {
                
            }
        }
    }
    
}
