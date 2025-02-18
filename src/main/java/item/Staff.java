package item;

/**
 *
 * @author johnkufta
 */

import java.util.Arrays;

public class Staff extends Weapon {
    private String name;
    private double damage;
    private Crystal crystal;
    private String description;
    private int build = 1;
    private int goldValue;
    
    public Staff(String name, double damage, Crystal crystal, String description, int goldValue)
    {
        super(name, description, damage, goldValue);
        this.name = name;
        this.damage = damage;
        this.crystal = crystal;
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
     * Returns the item description
     * @return String with description of item
     */
    
    @Override
    public String getDescription()
    {
        return this.description;
    }
    
    /**
     * Adds an effect to the staffs crystal
     * @param effectID What effect you will add to it
     * 0: Poison
     * 1: Fire
     * 2: Electricity
     */
    
    public int addCrystalEffect(Effect effect)
    {
        return this.crystal.addEffect(effect);
    }
    
    /**
     * Returns array of EffectIDs of the staffs crystal
     * @return EffectID Array
     */
    
    public Effect[] getEffects()
    {
        return Arrays.copyOf(this.crystal.getEffects(), this.crystal.getEffects().length);
    }
    
    /**
     * Gets the name/color of the Crystal that's on the staff
     * @return String name of Crystal
     */
    public String getCrystalColor()
    {
        return this.crystal.getColor();
    }
    
    /**
     * Gets the Description of the Crystal that's on the staff
     * @return String Description of Crystal
     */
    public String getCrystalDescription()
    {
        return this.crystal.getDescription();
    }
    
    /**
     * Changes the crystal that is on the staff
     * @param crystal Crystal (Need to grab/create crystal from the Registry)
     */
    public void changeCrystal(Crystal crystal)
    {
        this.crystal = crystal;
    }
    
    
}
