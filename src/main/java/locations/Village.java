package locations;

/**
 *
 * @author johnkufta
 */
import java.util.*;

public class Village extends Location {
    
    private String name;
    private String Description;
    
    public Village(String name, String description)
    {
        super(name, description);
        this.name = name;
        this.description = description;
    }
    
    
    
}
