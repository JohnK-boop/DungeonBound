package com.mycompany.dungeon;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        
        printSlow("Welcome to my dungeon crawler!\nPlease select your class!", 30, true);
        sleepMil(200);
        System.out.println("1) Knight\n2) Mage\n3) Critter Rangler");

        build = txt.nextInt();
        
        while(build != 1 && build != 2 && build != 3)
        {

            printSlow("That was an invalid input!\nPlease try again", 40, true);
            build = txt.nextInt();
            
        }
        
        txt.nextLine();
        
        printSlow("\nAnd what is this travelers name? ", 30, true);
        String name = txt.nextLine();
        System.out.println("");
        
        printSlow("Creating ", 80, false);
        sleep(1);
        printSlow(name, 80, false);
        printSlow("...", 180, true);
        
        Player p1 = new Player(name, build - 1);
        
        //Player p1 = new Player("John", 0);
        
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException ex) {
            Logger.getLogger(game.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        return p1;
    }

}
