package locations;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.javafaker.Faker;
import static com.mycompany.dungeon.Time.sleep;
import static com.mycompany.dungeon.Time.sleepMil;
import static com.mycompany.dungeon.Typewriter.printSlow;

import item.Item;
import item.Registries;
import people.NPC;
import people.Player;


public class BlackSmith extends Location {
    
    private static final Logger logger = LoggerFactory.getLogger(BlackSmith.class);
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
        
        printSlow(getGreeting(), 70, false);
        
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
        owner.speak("What can I do for ya?", 40);
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
            System.out.println("Unknown" + ":");
            printSlow("I dont think I've seen you here before.\n", 70, true);
            sleep(2);
            printSlow("LET ME GUESS YOUR NAME!\n", 30, true);
            sleep(1);
            printSlow("I'm pretty good with this kind of thing.\n", 70, true);
            sleep(2);
            
            printSlow("You look like you're called... ", 70, false);
            
           sleep(2);
             
            Faker faker = new Faker();
            String firstName = faker.name().firstName();
            
            printSlow(firstName.toUpperCase(), 70, true);
            System.out.println();
            sleep(2);
            
            if(firstName.toLowerCase().equals(player.getName().toLowerCase()))
            {
                printSlow("I GOT IT??", 40, true);
                sleep(2);
                printSlow("Well that doesn't normally happen...", 50, true);
                printSlow("In honor of this magnificent achivement, I want to give you a special gift!", 60, true);
                
            }
            
            else
            {
                printSlow("NO???", 40, true);
                
                sleep(2);
                
                printSlow("Your name..." , 70, false);

                sleepMil(700);

                printSlow("is " + player.getName() + "?", 70, true);
                
                sleep(3);
                
                printSlow("Well it's nice to meet you " + player.getName() + "!", 35, true);
                
                sleep(1);
                
                printSlow("Since you're new to town, let me give you a little gift!", 50, true);

                sleep(2);
            }
            
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

            sleep(2);

            printSlow("\nI've had that in stock for a while now,\nhopefully it can help you as you get your bearings around here.\n", 50, true);
            
            sleep(1);

            printSlow("ANYWAYS!", 40, true);

            printSlow("Welcome to my shop! ", 80, true);

            sleep(1);

            printSlow(this.getName().toUpperCase() + "!", 50, true);

            sleep(1);

            printSlow("\nAnything you could possibly need regarding weaponry you can find here.", 70, true);

            printSlow("I'm Jerry! At your service... ", 60, false);
            sleepMil(500);

            printSlow("for a price of course.", 60, true);
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
                printSlow("(Buy: " + owner.getItem(i).getValue() + "g)\n", 25, false);
            }
        }

        sleep(1);
        
        printSlow("\nAnything catch your eye?", 30, true);

        sleepMil(500);

        printSlow("\n*Type 1 - 5 to select*\n*Hit enter to exit*", 30, true);

        txt.nextLine();
        String input = txt.nextLine();
        
        if (input.isEmpty()) 
        {
            printSlow("", 70, true);
            return;
        }

        try 
        {
            int buyChoice = Integer.parseInt(input);

            if (buyChoice >= 1 && buyChoice <= 5) 
            {
                if (player.getGold() >= owner.getItem(buyChoice - 1).getValue()) 
                {
                    char confirm;
                    do {
                        printSlow("Are you sure you want to buy this? (y/n)", 50, true);
                        confirm = txt.next().charAt(0);
                        confirm = Character.toLowerCase(confirm);

                        if (confirm != 'y' && confirm != 'n') 
                        {
                            printSlow("That wasn't a valid input!", 50, true);
                        }
                        else
                        {
                            
                        }
                    } while (confirm != 'y' && confirm != 'n');
                } 
                else 
                {
                    printSlow("You do not have the funds for this item!\n", 20, true);
                }
            } 
            else 
            {
                printSlow("Invalid selection!", 30, true);
            }
        } 
        catch (NumberFormatException e) 
        {
            printSlow("Invalid input!", 30, true);
        }
    }
    
    
    
}
