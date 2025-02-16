package com.mycompany.dungeon;
import people.Player;
import item.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import locations.*;
import people.*;
import static com.mycompany.dungeon.Typewriter.printSlow;


/**
 *
 * @author johnkufta
 */
public class game {

    public static void run()
    {
        
        Player p1 = welcome();
        
        Registries.giveItem("jerry", Registries.getItem("rustySword"));
        Registries.giveItem("jerry", Registries.getItem("rustySword"));
        Registries.giveItem("jerry", Registries.getItem("rustySword"));
        Registries.giveItem("jerry", Registries.getItem("rustySword"));
        Registries.giveItem("jerry", Registries.getItem("rustySword"));
        
        ((BlackSmith)Registries.getLocation("forgeries")).main(p1);
        
        
    }
    
    public static Player welcome()
    {
        /*
        int build = 0;
        Scanner txt = new Scanner(System.in);
        
        printSlow("Welcome to my dungeon crawler!\nPlease select your class!\n1) Knight\n2) Mage\n3) Critter Rangler", 40, true);
        build = txt.nextInt();
        
        while(build != 1 && build != 2 && build != 3)
        {

            System.out.println("That was an invalid input!\nPlease try again");
            build = txt.nextInt();
            
        }
        
        txt.nextLine();
        
        printSlow("\nAnd what is this travelers name? ", 40, true);
        String name = txt.nextLine();
        System.out.println("");
        
        printSlow("Creating traveler", 80, false);
        printSlow("...", 180, true);
        
        Player p1 = new Player(name, build - 1);
        */
        Player p1 = new Player("John", 0);
        
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(game.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return p1;
    }

}
