package item;

/**
 *
 * @author johnkufta
 */

import java.util.Arrays;

public class Crystal extends Item {
    private String color; //Color of the crystal (Acts like the name)
    private int colorID; //ID of the Crystal
    private int maxEffects; //Integer that tells how many effects the crystal can hold
    private Effect[] effects; //Array of effects that the crystal holds
    private String description; //Description of the crystal
    private int goldValue; //Buy value of the Crystal
    
    /**
     * Crystals to go on the staffs and utilize effects
     * @param color Name of the crystal color
     * @param colorID Id of the Crystal color
     * 0: No Crystal (useless)
     * 1: White (no effects)
     * 2: Red (1 Effect)
     * 3: Green (2 Effects)
     * @param maxEffects Integer that tells how many effects the crystal can hold
     * @param effects Array of effects that the crystal holds
     * @param description Description of the crystal
     * @param goldValue Buy value of the Crystal
     */
    
    public Crystal(String color, int colorID, int maxEffects, Effect[] effects, String description, int goldValue)
    {
        super(color, description, goldValue);
        this.color = color;
        this.colorID = colorID;
        this.maxEffects = maxEffects;
        this.effects = effects;
        this.description = description;
        this.goldValue = goldValue;
    }
    
    /**
     * Returns the color of the crystal in a string
     * @return color/name
     */
    
    public String getColor()
    {
        return this.color;
    }
    
    /**
     * Returns the ID of the crystal
     * 0: No Crystal (useless)
     * 1: White (no effects)
     * 2: Red (1 Effect)
     * 3: Green (2 Effects)
     * @return colorID
     */

    public int getColorID()
    {
        return this.colorID;
    }
    
    /**
     * Returns the item description
     * @return String with description of item
     */
    
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
    
    public int addEffect(Effect effect)
    {
        int length = this.effects.length;
        if (length != this.getMaxEffects())
            {
                Effect[] newArray = new Effect[length + 1];
                for (int i = 0; i < length; i++) {
                    newArray[i] = this.effects[i];
                }

                newArray[length] = effect;
                this.effects = newArray;
                return 0;
            }
        else
        {
            return 1;
        }
        
    }
    
    /**
     * Returns array of EffectIDs
     * @return EffectID Array
     */
    
    public Effect[] getEffects()
    {
        return Arrays.copyOf(this.effects, this.effects.length);
    }

    /**
     * Returns an integer of the maximum effects a crystal can contain
     * @return integer maxEffects
     */
    
    public int getMaxEffects()
    {
        return this.maxEffects;
    }
    
}
