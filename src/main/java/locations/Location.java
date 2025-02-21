package locations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.mycompany.dungeon.Typewriter.printSlow;

import people.Player;

public abstract class Location {
    
    protected String name;
    protected String description;
    protected HashMap<String, Location> connections;
    
    /**
     * Creates a Location
     * @param name Name of Location
     * @param description Description of Location
     */
    public Location(String name, String description)
    {
        this.name = name;
        this.description = description;
        this.connections = new HashMap<>();
    }

    public void main(Player player)
    {
        System.out.println("Location main error");
    }

    /**
     * Returns the Location Name
     * @return String name
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * Creates a connection to the Location
     * Uses a HashMap<String, Location> to add the connection
     * allows program to see where they are able to go from where they are at
     * @param direction String Direction that will be Key and Outputed to the user 
     * (E.g: "Outside" the BlackSmith is the Village)
     * @param location Location that the connection is to
     */
    public void addConnection(String direction, Location location)
    {
        connections.put(direction, location);
    }

    public HashMap<String, Location> getConnections()
    {
        return this.connections;
    }

    public Map.Entry<String, Location> getConnections(int index)
    {
        List<Map.Entry<String, Location>> connectionList = new ArrayList<>(this.connections.entrySet());

        if (index < 0 || index >= connectionList.size()) {
            System.out.println("Invalid index!");
            return null;
        }
        
        return connectionList.get(index);
    }
    
    /**
     * Gets the location off the given direction
     * *Might be broken*
     * @param direction String Key of Direction
     * @return Location
     */
    public Location getLocation(String direction) 
    {
        return connections.getOrDefault(direction, null);
    }
    
    /**
     * Default enter 
     * *Hasn't been used yet*
     * May change later
     */
    public void enter()
    {
        printSlow(1, "You have arrived at the " + this.getName(), 1, 30);
        
        printSlow(0, "Available routes: " + connections.keySet(), 1, 30);
    }
    
    
}
