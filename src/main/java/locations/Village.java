package locations;

/**
 *
 * @author johnkufta
 */

public class Village extends Location {
    
    private String name;
    private String Description;
    
    /**
     * Creates the Village Location
     * Will probably be the main hub
     * @param name name of the Location
     * @param description Description of the Location
     */
    public Village(String name, String description)
    {
        super(name, description);
        this.name = name;
        this.description = description;
    }
    
    
    
}
