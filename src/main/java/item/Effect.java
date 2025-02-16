package item;

/**
 *
 * @author johnkufta
 */
import java.util.*;

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
    
    
    public String getName()
    {
        return this.name;
    }
    
    public int getLevel()
    {
        return this.level;
    }
    
    public void setLevel(int level)
    {
        this.level = level;
    }
    
    public void changeLevel(int change)
    {
        this.level += change;
    }
    
    public int getDuration()
    {
        return this.duration;
    }
    
    public void setDurtion(int duration)
    {
        this.duration = duration;
    }
    
    public void changeDuration(int change)
    {
        this.duration += change;
    }
    
}
