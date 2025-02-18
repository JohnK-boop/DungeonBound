package item;

import java.util.HashMap;
import java.util.Map;

import locations.BlackSmith;
import locations.Location;
import locations.PotionShop;
import locations.Village;
import people.NPC;

/**
 *
 * @author johnkufta
 */
public class Registries 
{
    private static final Map<String, Item> items = new HashMap<>();
    private static final Map<String, Sword> swords = new HashMap<>();
    private static final Map<String, Staff> staffs = new HashMap<>();
    private static final Map<String, Crystal> crystals = new HashMap<>();
    private static final Map<String, Effect> effects = new HashMap<>();
    private static final Map<String, NPC> NPCs = new HashMap<>();
    private static final Map<String, Location> locations = new HashMap<>();

    static 
    {
        swords.put("rustySword", new Sword("Rusty Sword", 1.0, 0.2, new Effect[0], "It tastes like metal...", 50));
        swords.put("ironSword", new Sword("Iron Sword", 1.2, 0.1, new Effect[0], "Looks a little... pixelated", 150));
        
        crystals.put("none", new Crystal("None", 0, 0, new Effect[0], "Nothing here...", 0));
        crystals.put("white", new Crystal("White", 1, 0, new Effect[0], "There's a smudge that looks like Zach Galifianakis on it.", 50));
        crystals.put("red", new Crystal("Red", 2, 1, new Effect[1], "Blood red...", 150));
        crystals.put("green", new Crystal("Green", 3, 2, new Effect[2], "Greed. It beckons you closer.", 300));
        
        staffs.put("stick", new Staff("Stick", 1, crystals.get("none"), "Fetch?", 20));
        staffs.put("metalBanister", new Staff("Metal Banister", 1.2, crystals.get("none"), "You know you want to use it...", 60));
        
        effects.put("poison", new Effect("Poison", 1, 3, 0.67));
        effects.put("fire", new Effect("Fire", 1, 2, 0.80));
        
        NPCs.put("jerry", new NPC("Jerry", 10));
        //Potion shop NPC
        NPCs.put("nancy", new NPC("Nancy", 60));
        
        locations.put("berkshire", new Village("Berkshire", "Home"));
        locations.put("forgeries", new BlackSmith("Forgeries", "For all things metal", NPCs.get("jerry")));
        locations.put("potionShop", new PotionShop("PotionShop", "testDescription", NPCs.get("nency")));
        
        locations.get("berkshire").addConnection("Forgeries", locations.get("forgeries"));
        locations.get("forgeries").addConnection("Outside", locations.get("berkshire"));
        
        items.putAll(swords);
        items.putAll(staffs);
        items.putAll(crystals);
    }

    /**
     * Returns an item from the item registry
     * @param name Key of item
     * @return item
     */

    public static Item getItem(String name) 
    {
        return items.get(name);
    }

    /**
     * Adds an Item to the item registry
     * @param name Key of item
     * @param item Actual item
     */
    public static void addItem(String name, Item item) 
    {
        items.put(name, item);
    }

    /**
     * returns a sword from the sword registry
     * @param name Key of item
     * @return Sword item
     */
    public static Sword getSword(String name) 
    {
        return swords.get(name);
    }

    /**
     * returns a staff from the staff registry
     * @param name Key of item
     * @return Staff item
     */

    public static Staff getStaff(String name) 
    {
        return staffs.get(name);
    }

    public static Crystal getCrystal(String name) 
    {
        return crystals.get(name);
    }

    public static Effect getEffect(String name) 
    {
        return effects.get(name);
    }
    
    public static Location getLocation(String name)
    {
        return locations.get(name);
    }
    
    public static void giveItem(String nameID, Item item)
    {
        NPCs.get(nameID).addItem(item);
    }

    public static void giveItemIndex(String nameID, Item item, int index)
    {
        NPCs.get(nameID).addItemIndex(item, index);
    }
}
