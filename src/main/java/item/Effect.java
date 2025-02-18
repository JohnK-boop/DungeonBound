package item;

/**
 *
 * @author johnkufta
 */

public class Effect {
    private String name;
    private int level;
    private int duration;
    
    /**
     * Effect object creation
     * @param name Name of the effect
     * @param effectID ID of the effect
     * 0: Poison
     * 1: Fire
     * 2: Electricity
     * 3: Sleepy
     * @param level
     * @param duration 
     * @param chance Chance the given effect takes place when used
     */
    public Effect(String name, int level, int duration, double chance)
    {
        this.name = name;
        this.level = level;
        this.duration = duration;
    }
    
    /**
     * Returns the Name of the effect
     * @return String name
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * Returns the level of the effect
     * @return int level
     */
    public int getLevel()
    {
        return this.level;
    }
    
    /**
     * Sets the level of the effect
     * @param level
     */
    public void setLevel(int level)
    {
        this.level = level;
    }
    
    /**
     * Changes the level of the effect by a specified amount
     * @param change int amount to change level by (can be negative)
     */
    public void changeLevel(int change)
    {
        this.level += change;
    }
    
    /**
     * Gets the duration of the effect
     * @return int duration
     */
    public int getDuration()
    {
        return this.duration;
    }
    
    /**
     * Sets the duration of the effect
     * @param duration int duration that will be set
     */
    public void setDurtion(int duration)
    {
        this.duration = duration;
    }
    
    /**
     * Changes the duration of the effect
     * @param change int amount to change by (can be negative)
     */
    public void changeDuration(int change)
    {
        this.duration += change;
    }
    
}
