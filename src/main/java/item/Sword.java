package item;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 
 * @author johnkufta
 */
public class Sword extends Weapon {
    
    private String name;
    private double damage;
    private double dullness;
    private Effect[] effects = new Effect[0];
    private String description;
    private int build = 0;
    private int goldValue;
    
    /**
     * Create a sword Item
     * @param name String name of sword
     * @param damage double damage of sword
     * @param dullness double dullness of sword
     * @param effects Effect List Effects
     * @param description String Description
     * @param goldValue int Value of item
     */
    public Sword(String name, double damage, double dullness, Effect[] effects, String description, int goldValue)
    {
        super(name, description, damage, goldValue);
        this.name = name;
        this.damage = damage;
        this.dullness = dullness;
        this.effects = effects;
        this.description = description;
        this.goldValue = goldValue;
    }
    
    /**
     * Returns the name of the item
     * @return name
     */
    
    @Override
    public String getName()
    {
        return this.name;
    }
    
    /**
     * Returns the amount of base damage
     * @return damage
     */
    
    public double getDamage()
    {
        return this.damage;
    }
    
    /**
     * Sets the dullness of the sword
     * @param dullenss How dull the object should be (0.0 - 1.0)
     */
    
    public void setDullness(double dullenss)
    {
        this.dullness = dullness;
    }
    
    /**
     * Changes the dullness of the sword
     * @param dullnessChange Amount of dullness you want changed (+ or -)
     */
    
    public void changeDullness(double dullnessChange)
    {
        this.dullness += dullnessChange;
    }
    
    public double getDullness()
    {
        return this.dullness;
    }
    
    /**
     * Returns the item description
     * @return String with description of item
     */
    
    @Override
    public String getDescription()
    {
        return this.description;
    }
    
    /**
     * Adds an effect to the object
     * @param effectID What effect you will add to it
     * 0: Poison
     * 1: Fire
     * 2: Electricity
     */
    
    public void addEffect(HashMap<String, Integer> effect)
    {
        //haven't implemented yet
    }
    
    /**
     * Returns array of EffectIDs
     * @return EffectID Array
     */
    
    public Effect[] getEffects()
    {
        return Arrays.copyOf(this.effects, this.effects.length);
    }
    
    @Override
    public void getInfo()
    {
        System.out.println("Name: " + this.getName());
        System.out.println("Damage: " + this.getDamage());
        System.out.println("Dullness: " + this.getDullness());
        System.out.print("Effects: [");
    }
}
