package locations;

/**
 *
 * @author johnkufta
 */

import java.util.*;

public abstract class Location {
    
    protected String name;
    protected String description;
    protected HashMap<String, Location> connections;
    
    public Location(String name, String description)
    {
        this.name = name;
        this.description = description;
        this.connections = new HashMap<>();
    }
    
    public void addConnection(String direction, Location location)
    {
        connections.put(direction, location);
    }
    
    public Location getLocation(String direction) 
    {
        return connections.getOrDefault(direction, null);
    }
    
    public void enter()
    {
        System.out.println("You have arrived at the " + this.name);
        
        System.out.println("Available routes: " + connections.keySet());
    }
    
    
}
