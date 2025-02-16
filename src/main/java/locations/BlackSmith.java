package locations;

/**
 *
 * @author johnkufta
 */

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import people.*;
import com.github.javafaker.Faker;
import static com.mycompany.dungeon.Typewriter.printSlow;

import item.Item;
import item.Registries;


public class BlackSmith extends Location {
    
    private String name;
    private String description;
    private boolean visited;
    private NPC owner;
    private Player player;
    public static Scanner txt = new Scanner(System.in);
    
    public BlackSmith(String name, String description, NPC owner)
    {
        super(name, description);
        this.name = name;
        this.description = description;
        this.visited = false;
        this.owner = owner;
    }
    
    public void main(Player player)
    {
        this.player = player;

        int choice = 0;
        
        printSlow(getGreeting(), 50, false);
        
        while (choice != 5)
        {
            choice = welcome();
            
            if ((choice >= 1 && choice <= 4))
            {
                switch (choice) {
                    case 1:
                        stock();
                        break;
                    case 2:
                        

                }
                
            }
        }
        
        
    }
    
    
    public int welcome()
    {
        printSlow("\nWhat can I do for ya?", 30, true);
        printSlow("1) Check what's in stock\n2) Sell items\n3) Check quests\n4) Check the Smithopedia\n5) Leave the shop", 10, true);
                
        
        int choice = txt.nextInt();
        return choice;
    }
    
    public String getGreeting()
    {
        if(this.visited == true)
        {
            int ran = (int)(Math.random() * 3);
            switch (ran)
            {
                case 0:
                    return ("\n*Cough*\nWELL IF IT ISN'T " + this.player.getName().toUpperCase());
                case 1:
                    return ("\n*Weeze*\nLook what the cat dragged in.");
                case 2:
                    return ("\nAND I SET FIIIIIIIIRE\n\nTO THE RAIN!!\n\nOH! " + this.player.getName() + "! ehmm...");
                
            }
        }
        else
        {
            this.visited = true;
            /*
            this.owner.speak("", 0);
            printSlow("I dont think I've seen you here before.\n", 40, true);
            printSlow("LET ME GUESS YOUR NAME!\n", 20, true);
            printSlow("I'm pretty good with this type of thing.\n", 30, true);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(BlackSmith.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            printSlow("You look like you're called...", 50, true);
            
            try 
            {
                TimeUnit.SECONDS.sleep(2);
            } 
            catch (InterruptedException ex) 
            {
                Logger.getLogger(BlackSmith.class.getName()).log(Level.SEVERE, null, ex);
            }
             
            Faker faker = new Faker();
            String firstName = faker.name().firstName();
            
            printSlow(firstName.toUpperCase(), 30, true);
            
            if(firstName.toLowerCase().equals(player.getName().toLowerCase()))
            {
                printSlow("I GOT IT??", 30, true);
                printSlow("Well that doesn't normally happen...", 40, true);
                printSlow("In honor of this magnificent achivement, I want to give you a special gift!", 30, true);
                
            }
            
            else
            {
                printSlow("NO???", 30, true);
                
                printSlow("Your name is " + player.getName() + "?", 50, true);
                
                printSlow("Well it's nice to meet you " + player.getName() + "!", 60, true);
                
                printSlow("Since you're new to town, let me give you a little gift!", 60, true);
            }
            */
            switch (player.getBuild())
            {
                case 0:
                    player.announceItem(Registries.getItem("rustySword"));
                    break;
                case 1:
                    player.announceItem(Registries.getItem("stick"));
                    break;
                default:
                    System.out.println("Error with giving item");
            }
            printSlow("\nI've had that in stock for a while now,\nhopefully it can help you as you get your bearings around here. \nANYWAYS!\n", 60, true);
            
            printSlow("Welcome to my shop! " + this.getName().toUpperCase() + "!", 80, true);
            printSlow("\nAnything you could possibly need regarding weaponry you can find here.", 60, true);
            return "";
        }
        return "error";
    }
    
    
    
    public String getName()
    {
        return this.name;
    }
    
    
    public void stock()
    {
        
        List<Item> inv = owner.getInv(5);
        
        if (inv.isEmpty()) 
        {
            printSlow("Inventory is empty.", 90, true);
        } 
        else 
        {
            printSlow("Inventory:", 25, true);
            for (int i = 0; i < 5; i++)
            {
                printSlow(i + 1 + "- " + owner.getItem(i).getName(), 25, false);
                printSlow("(Buy: " + owner.getItem(i).getValue() + "g)", 25, true);
            }
        }
        
        printSlow("Anything catch your eye?\n*Type 1 - 5 to select*\n*Hit enter to exit*", 30, true);
        txt.nextLine();
        String input = txt.nextLine();
        
        if (input.isEmpty()) 
        {
            printSlow("You decide to leave the shop.", 30, true);
            return;
        }

        try {
            int buyChoice = Integer.parseInt(input);

            if (buyChoice >= 1 && buyChoice <= 5) {
                if (player.getGold() >= owner.getItem(buyChoice - 1).getValue()) {
                    char confirm;
                    do {
                        printSlow("Are you sure you want to buy this? (y/n)", 50, true);
                        confirm = txt.next().charAt(0);
                        confirm = Character.toLowerCase(confirm);

                        if (confirm != 'y' && confirm != 'n') {
                            printSlow("That wasn't a valid input!", 35, true);
                        }
                    } while (confirm != 'y' && confirm != 'n');
                } else {
                    printSlow("You do not have the funds for this item!", 35, true);
                }
            } else {
                printSlow("Invalid selection! You leave the shop.", 30, true);
            }
        } catch (NumberFormatException e) {
            printSlow("Invalid input! You leave the shop.", 30, true);
        }
    }
    
    
    
}
