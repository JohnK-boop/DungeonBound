package locations;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.javafaker.Faker;
import static com.mycompany.dungeon.Time.sleep;
import static com.mycompany.dungeon.Time.sleepMil;
import static com.mycompany.dungeon.Typewriter.printSlow;

import item.EmptySlot;
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
    
    /**
     * Creates the BlackSmith Location
     * @param name Name of BlackSmith
     * @param description Description of BlackSmith
     * @param owner NPC of the BlackSmith
     */
    public BlackSmith(String name, String description, NPC owner)
    {
        super(name, description);
        this.name = name;
        this.description = description;
        this.visited = false;
        this.owner = owner;
    }
    
    /**
     * Main of the BlackSmith Location
     * @param player Player passed into the BlackSmith main method
     */
    public void main(Player player)
    {
        this.player = player;

        int choice = 0;
        
        printSlow(0, getGreeting(), 0, 70);
        
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
    
    /**
     * Prints the shop command list
     * @return int Player choice
     */
    public int welcome()
    {
        owner.speak("What can I do for ya?", 40);
        printSlow(0, "1) Check what's in stock\n2) Sell items\n3) Check quests\n4) Check the Smithopedia\n5) Leave the shop", 1, 10);
                
        
        int choice = txt.nextInt();
        return choice;
    }
    
    /**
     * Gets a random greeting for NPC to say
     * @return String Greeting
     */
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
            printSlow(0, "I dont think I've seen you here before.", 1, 70);
            sleep(2);
            printSlow(1, "LET ME GUESS YOUR NAME!", 1, 30);
            sleep(1);
            printSlow(1, "I'm pretty good with this kind of thing.", 1, 60);
            sleep(2);
            
            printSlow(1, "You look like you're called... ", 0, 70);
            
           sleep(2);
             
            Faker faker = new Faker();
            String firstName = faker.name().firstName();
            
            printSlow(0, firstName.toUpperCase(), 0, 70);
            System.out.println();
            sleep(2);
            
            if(firstName.toLowerCase().equals(player.getName().toLowerCase()))
            {
                printSlow(0, "I GOT IT??", 1, 40);
                sleep(2);
                printSlow(0, "Well that doesn't normally happen...", 1, 50);
                printSlow(0, "In honor of this magnificent achivement, I want to give you a special gift!", 1, 60);
                
            }
            
            else
            {
                printSlow(1, "NO???", 0, 40);
                
                sleep(2);
                
                printSlow(1, "Your name...", 0, 70);

                sleepMil(700);

                printSlow(0, " is " + player.getName() + "?", 1, 70);
                
                sleep(3);
                
                printSlow(0, "Well it's nice to meet you " + player.getName() + "!", 1, 35);
                
                sleep(1);
                
                printSlow(0, "Since you're new to town, let me give you a little gift!", 1, 50);

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

            printSlow(1, "I've had that in stock for a while now,\nhopefully it can help you as you get your bearings around here.", 2, 40);
            
            sleep(1);

            printSlow(0, "ANYWAYS!", 1, 40);

            printSlow(0, "Welcome to my shop! ", 0, 80);

            sleep(1);

            printSlow(0, this.getName().toUpperCase() + "!", 1, 50);

            sleep(1);

            printSlow(1, "Anything you could possibly need regarding weaponry you can find here.", 1, 70);

            printSlow(0, "I'm Jerry! At your service... ", 0, 50);
            sleepMil(500);

            printSlow(0, "for a price of course.", 1, 50);
            return "";
        }
        return "error";
    }
    
    /**
     * Gets the name of the Shop
     * @return String name
     */
    public String getName()
    {
        return this.name;
    }
    
    /**
     * Method to check NPC stock and buy an item
     */
    public void stock()
    {
        
        List<Item> inv = owner.getInv(0, 5);
        
        if (inv.isEmpty()) 
        {
            printSlow(0, "Inventory is empty.", 1, 90);
        } 
        else 
        {
            printSlow(0, "Inventory:", 1, 25);
            for (int i = 0; i < 5; i++)
            {
                if(!(owner.getItem(i) instanceof EmptySlot))
                {
                    printSlow(0, i + 1 + "- " + owner.getItem(i).getName(),0, 15);
                    printSlow(0, "(Buy: " + owner.getItem(i).getValue() + "g)", 1, 15);
                }
                else
                {
                    printSlow(0, i + 1 + "- Out of Stock",1, 25);
                }
            }
        }

        printSlow(0, "   [Your Gold: " + player.getGold() + "]", 0, 25);

        sleepMil(700);
        
        printSlow(2, "Anything catch your eye?", 1, 30);

        sleepMil(500);

        printSlow(1, "*Type 1 - 5 to select*\n*Hit enter to exit*\nUser: ", 0, 10);

        txt.nextLine();
        String input = txt.nextLine();
        
        if (input.isEmpty()) 
        {
            printSlow(0, "", 0, 0);
            return;
        }

        try 
        {
            int buyChoice = Integer.parseInt(input);

            if (buyChoice >= 1 && buyChoice <= 5) 
            {
                if (player.getGold() >= owner.getItem(buyChoice - 1).getValue() && owner.hasItem(buyChoice - 1) && player.hasFreeSlot()) 
                {
                    char confirm;
                    do {
                        printSlow(0, "Are you sure you want to buy this? (y/n)", 1, 20);
                        confirm = txt.next().charAt(0);
                        confirm = Character.toLowerCase(confirm);

                        if (confirm != 'y' && confirm != 'n') 
                        {
                            printSlow(1, "That wasn't a valid input!", 1, 50);
                        }
                        else
                        {
                            player.changeGold(-(owner.getItem(buyChoice - 1).getValue()));
                            player.announceItem(owner.getItem(buyChoice - 1));
                            owner.removeItemIndex(buyChoice - 1);
                        }
                    } while (confirm != 'y' && confirm != 'n');
                } 
                else 
                {
                    if (!owner.hasItem(buyChoice - 1))
                    {
                        printSlow(0, "You're too poor to buy his ", 0, 20);
                        sleepMil(500);
                        printSlow(0, owner.getItem(buyChoice - 1).getName(), 0, 100);
                        sleep(1);
                        System.out.println();
                    }
                    else if(!player.hasFreeSlot())
                    {
                        printSlow(0, "Your inventory is full!", 0, 20);
                    }
                    else
                    {
                        printSlow(0, "You do not have the funds for this item!", 2, 20);
                    }
                }
            } 
            else 
            {
                printSlow(0, "Invalid selection!", 1, 30);
            }
        } 
        catch (NumberFormatException e) 
        {
            printSlow(0, "Invalid input!", 1, 30);
        }
    }
    
    
    
}
