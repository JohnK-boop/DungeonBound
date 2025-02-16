package item;

/**
 *
 * @author johnkufta
 */

import java.util.*;

abstract class Weapon extends Item {
    
    protected String name;
    protected String description;
    protected double damage;
    protected int goldValue;
    
    public Weapon(String name, String description, double damage, int goldValue)
    {
        super(name, description, goldValue);
        this.name = name;
        this.description = description;
        this.damage = damage;
    }
    
    //public abstract void attack();
    
    @Override
    public void getInfo()
    {
        System.out.println("Name: " + this.name);
        System.out.println("Damage: " + this.damage);
        System.out.println("Description: " + this.description);

    }

}
