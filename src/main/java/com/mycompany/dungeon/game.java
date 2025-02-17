package com.mycompany.dungeon;
import java.util.Scanner;

import static com.mycompany.dungeon.Time.sleep;
import static com.mycompany.dungeon.Time.sleepMil;
import static com.mycompany.dungeon.Typewriter.printSlow;

import item.Registries;
import locations.BlackSmith;
import people.Player;


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
        
        int build = 0;
        Scanner txt = new Scanner(System.in);
        
        printSlow(0, "Welcome to my dungeon crawler!\nPlease select your class!", 0, 30);
        sleepMil(100);
        System.out.println("\n1) Knight\n2) Mage\n3) Critter Rangler");

        build = txt.nextInt();
        
        while(build != 1 && build != 2 && build != 3)
        {

            printSlow(0, "That was an invalid input!\nPlease try again", 1, 40);
            build = txt.nextInt();
            
        }
        
        txt.nextLine();
        
        printSlow(1, "And what is this travelers name? ", 1, 30);
        String name = txt.nextLine();
        System.out.println("");
        
        printSlow(0, "Creating ", 0, 80);
        sleep(1);
        printSlow(0, name, 0, 80);
        printSlow(0, "...", 0, 180);
        
        Player p1 = new Player(name, build - 1);
        
        //Player p1 = new Player("John", 0);
        
        sleep(3);
        
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        return p1;
    }

}
