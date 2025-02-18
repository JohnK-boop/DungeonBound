package locations;

import people.NPC;

public class PotionShop extends Location {
    private String name;
    private String description;
    private NPC owner;
    public PotionShop(String name, String description, NPC owner)
    {
        super(name, description);
        this.name = name;
        this.description = description;
        this.owner = owner;    
    }
}
