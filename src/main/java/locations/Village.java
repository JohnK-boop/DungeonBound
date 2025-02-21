package locations;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.mycompany.dungeon.ParseInput.getInt;
import static com.mycompany.dungeon.Time.sleep;
import static com.mycompany.dungeon.Time.sleepMil;
import static com.mycompany.dungeon.Typewriter.printSlow;

import item.Registries;
import people.Player;

/**
 *
 * @author johnkufta
 */

public class Village extends Location {
    
    private String name;
    private String Description;
    private boolean visited;
    private Player player;
    private boolean firstTimeWelcome;
    private Scanner txt = new Scanner(System.in);
    
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
        this.firstTimeWelcome = true;
    }

    public void main(Player player)
    {
        this.player = player;
        Welcome();
    }
    
    public void Welcome()
    {
        if (!visited)
        {
            printSlow(15, "You wake up on a hill.", 2, 60);

            sleepMil(1500);

            player.speak("Where Am I?", 50);

            sleep(2);

            printSlow(2, "Suddenly looking up, you notice the tiny town, hidden within the valley.", 0, 35);

            sleep(1);

            printSlow(2, "Like a fly stuck in your room, beckoning for the imaginary sun it will never reach, ", 0, 45);

            sleepMil(700);

            printSlow(0, "you push onward.", 0, 50);

            sleepMil(1500);

            visited = true;
            Welcome();
        }
        else
        {
            if(firstTimeWelcome)
            {
                //Will add more story about going to the town
                firstTimeWelcome = false;
            }
            else
            {
                System.out.println("You enter the village");
                int rand = (int)(Math.random() * 2);
                switch(rand)
                {
                    case 0:
                        player.speak("Smells like chicken...", 45);
                        break;
                    case 1:
                        player.speak("I wonder what Jerry's up to...", 45);
                        break;
                    case 2:
                        player.speak("*YYYYAAAAAAAAWWWWWWWNNNNNNNN*", 65);
                        break;
                    default:
                        System.out.println("Error when getting Village Welcome");
                        break;
                }
            }

            printSlow(3, "Where to?", 1, 40);

            HashMap<String, Location> connections = Registries.getLocation("village").getConnections();

            for(int i = 0; i < connections.size(); i++)
            {
                Map.Entry<String, Location> temp = Registries.getLocation("village").getConnections(i);
                printSlow(0, (i + 1) + ") [" + temp.getKey() + "] " + temp.getValue().getName(), 1, 15);
            }

            int go = getInt(1, connections.size(), "Error");

            printSlow(5 , "Traveling to", 0, 30);
            sleep(1);
            printSlow(0, "...", 0, 1000);
            printSlow(0, " [" + Registries.getLocation("village").getConnections(go - 1).getValue().getName() + "]", 0, 40);

            sleep(3);

            printSlow(12, "", 0, 0);

            Registries.getLocation("village").getConnections(go - 1).getValue().main(player);
            
        }

    }

    
}
