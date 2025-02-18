package item;

/**
 *
 * @author johnkufta
 */

public class Weapon extends Item {
    
    protected String name;
    protected String description;
    protected double damage;
    protected int goldValue;
    
    /**
     * Creates a Weapon
     * @param name Name of the Weapon
     * @param description Description of Weapon
     * @param damage Damage of the Weapon
     * @param goldValue Value of the Weapon
     */
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
