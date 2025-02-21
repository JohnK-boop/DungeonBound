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
import item.Weapon;
import people.NPC;
import people.Player;

public class BlackSmith extends Location {
    
    private static final Logger logger = LoggerFactory.getLogger(BlackSmith.class);
    private String name;
    private final String description;
    private boolean visited;
    private final NPC owner;
    private Player player;
    private int buyValue;
    List<Item> playerInv;

    private static Scanner txt = new Scanner(System.in);
    
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
            System.out.println();
            System.out.println("Player Gold: " + player.getGold());
            System.out.println("\n");
            System.out.println("Player Inventory: ");
            
            for(Item item : player.getInv())
            {
                System.out.print(item.getName() + ", ");
            }
            System.out.println("\n");

            if ((choice >= 1 && choice <= 4))
            {
                switch (choice) {
                    case 1:
                        stock();
                        break;
                    case 2:
                        sell();
                        break;
                    case 5:
                        Registries.getLocation("village").main(player);
                    default:
                        System.out.println("Error");
                        break;
                }
                
            }
        }
        
        
    }
    
    /**
     * Prints the shop command list
     * @return int Player choice
     */
    private int welcome()
    {
        owner.speak("What can I do for ya?", 40);
        printSlow(0, "1) Check "+ owner.getName() + "'s Stock\n2) Sell items\n3) Check quests\n4) Check the Smithopedia\n5) Leave the shop", 1, 10);
                
        
        int choice = txt.nextInt();
        return choice;
    }
    
    /**
     * Gets a random greeting for NPC to say
     * @return String Greeting
     */
    private String getGreeting()
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
            
            printSlow(0, firstName.toUpperCase(), 0, 40);
            sleep(2);
            
            if(firstName.toLowerCase().equals("jerry"))
            {
                printSlow(1, "Wait...", 0, 80);
                sleep(1);
                printSlow(0, " that's not right.", 0, 45);
                sleep(1);
                printSlow(1, "That's my name.", 0, 45);
                sleepMil(1500);

                if (player.getName().toLowerCase().equals("jerry"))
                {
                    printSlow(2, "THAT'S YOUR NAME TOO!?!?", 0, 25);
                    sleep(1);
                    printSlow(1, "WE NEED TO CELEBRATE THIS MONUMENTAL ACHIEVEMENT!", 0, 40);
                    sleep(1);
                    printSlow(1, "Here, let me get you a little something... ", 0, 40);
                    sleep(1);
                    printSlow(0, "on me", 0, 40);
                    sleep(3);
                }
                else
                {
                    sleep(1);
                    printSlow(2, "I'm sorry you had to be here for that", 0, 40);
                    sleepMil(300);
                    printSlow(0, "...", 0, 300);
                    printSlow(0, " AND ON YOU FIRST TIME HERE NO LESS!", 0, 30);
                    sleep(1);

                    printSlow(1, "Here, let me get you a little something... ", 0, 40);
                    sleep(2);
                    printSlow(0, "Just don't tell anyone about this", 0, 40);
                    sleep(3);
                }



            }
            else if(firstName.toLowerCase().equals(player.getName().toLowerCase()))
            {
                printSlow(1, "I GOT IT??", 1, 40);
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
    private void stock()
    {
        
        List<Item> inv = owner.getInv(0, 5);
        
        //Show NPC Inventory (Shop slots: 0 - 4)
        printSlow(0, "Inventory:", 1, 25);
        for (int i = 0; i < 5; i++)
        {
            if(!(owner.getItem(i) instanceof EmptySlot))
            {
                printSlow(0, i + 1 + "- " + owner.getItem(i).getName(),0, 15);
                printSlow(0, " | (Buy: " + owner.getItem(i).getValue() + "g)", 1, 15);
            }
            else
            {
                printSlow(0, i + 1 + "- Out of Stock",1, 25);
            }
        }

        //Show player their gold
        printSlow(0, "   [Your Gold: " + player.getGold() + "]", 0, 20);
        
        //Asks if they want anything
        printSlow(2, "Anything catch your eye?", 1, 30);

        sleepMil(500);

        printSlow(1, "*Type 1 - 5 to select*\n*Hit enter to exit*\nUser: ", 0, 10);

        txt.nextLine();
        String input = txt.nextLine();
        
        //if the input is empty, skip to the end
        if (input.isEmpty()) 
        {
            printSlow(0, "", 0, 0);
            return;
        }

        //checks to see if input is correct
        try 
        {
            int buyChoice = Integer.parseInt(input) - 1;

            //Checks to see if user input was in valid range of selection
            if (buyChoice >= 0 && buyChoice <= 4) 
            {
                //Checks if Player has enough gold && The Owner has an Item in that slot && Player has a free slot
                if (player.getGold() >= owner.getItem(buyChoice).getValue() && owner.hasItem(buyChoice) && player.hasFreeSlot()) 
                {
                    char confirm;
                    //Check to see if User has a valid confirm command
                    do {
                        printSlow(0, "Are you sure you want to buy this? (y/n)", 1, 20);
                        confirm = txt.next().charAt(0);
                        confirm = Character.toLowerCase(confirm);

                        //tell user their input was invalid
                        if (confirm != 'y' && confirm != 'n') 
                        {
                            printSlow(1, "That wasn't a valid input!", 1, 50);
                        }
                        //Take Players gold
                        //Give them the item to closest free index
                        //Remove the item from the NPC index
                        else
                        {
                            System.out.println("\n-" + owner.getItem(buyChoice).getValue() + "g");
                            player.buyItem(owner.getItem(buyChoice));
                            owner.removeItemIndex(buyChoice);
                            printSlow(1, "Another Happy Custommer!", 0, 50);
                            printSlow(0, "                sucker", 2, 90);

                        }
                    } while (confirm != 'y' && confirm != 'n');

                    //Check Player inventory to see if Item was added (Debug)
                    //System.out.println(player.getInv());
                } 
                else 
                {
                    //Owner has an Empty Slot in choice
                    if (!owner.hasItem(buyChoice))
                    {
                        printSlow(0, "You're too poor to buy his ", 0, 20);
                        sleepMil(500);
                        printSlow(0, owner.getItem(buyChoice).getName(), 0, 100);
                        sleep(1);
                        System.out.println();
                    }
                    //Player doesn't have a free Slot
                    else if(!player.hasFreeSlot())
                    {
                        printSlow(0, "Your inventory is full!", 0, 20);
                    }
                    //Player doesn't enough gold
                    else
                    {
                        printSlow(0, "You do not have the funds for this item!", 2, 20);
                    }
                }
            } 
            //Tells user their integer was not in range of selection
            else 
            {
                printSlow(0, "Invalid selection!", 1, 30);
            }
        } 
        //Tells user if input wasn't an integer
        catch (NumberFormatException e) 
        {
            printSlow(0, "Invalid input!", 1, 30);
        }
    }
    
    /**
     * Method to sell to NPC
     * Buys Weapons for 80% of Value
     * Buys all else for 50% Value
    */
    private void sell()
    {
        if (player.hasItem())
        {
            playerInv = player.getInv();

            int random = (int)(Math.random() * 3);

            switch (random)
            {
                case 0:
                    printSlow(1, "*Cough* You have something... ", 0, 45);
                    sleepMil(200);
                    printSlow(0, "FOR ME?!?!?", 0, 25);
                    sleepMil(600);

                    printSlow(2, "Well let's see what you've got!", 0, 45);
                    sleepMil(400);
                    break;
                case 1:
                    printSlow(1, "FINALLY!", 0, 85);
                    sleepMil(100);
                    printSlow(1, "Something to buy!", 0, 40);
                    break;
                case 2:
                    printSlow(2, "A lot of fine goods here...", 0, 45);
                    break;
                default:
                    System.out.println("Error when getting sell greeting");
                    break;
            }
            

            double buyMultiplier;
            int i = 1;
            for (Item item : playerInv)
            {
                if (!(item instanceof EmptySlot))
                {
                    if (item instanceof Weapon)
                    {
                        buyMultiplier = 0.8;
                    }
                    else
                    {
                        buyMultiplier = 0.5;
                    }
                    printSlow(1, (i) + "- " + item.getName() + " | (Sell: " + (int)(item.getValue() * buyMultiplier) + "g)", 0, 10);
                    i++;
                }
            }

            boolean selectLoop = true;
            String input;

            printSlow(1, "*Type 1 - " + (i - 1) + " to select*\n*Hit enter to exit*\nUser: ", 0, 10);

            txt.nextLine();
            input = txt.nextLine();


            try
            {
                int sellChoice = Integer.parseInt(input) - 1;
                do{
                    if (sellChoice >= 0 && sellChoice < i)
                    {
                        if (playerInv.get(sellChoice) instanceof Weapon)
                        {
                            buyMultiplier = 0.8;
                        }
                        else
                        {
                            buyMultiplier = 0.5;
                        }

                        System.out.println("\n+" + (int)(playerInv.get(sellChoice).getValue() * buyMultiplier) + "g");

                        player.sellItem(sellChoice, (int)(playerInv.get(sellChoice).getValue() * buyMultiplier));

                        selectLoop = false;
                    }
                    else
                    {
                        boolean intInvalid = true;
                        while (intInvalid == true)
                        {
                            printSlow(1, "Your input has to be in between 1 and " + (i - 1), 1, 15);

                            txt.nextLine();
                            input = txt.nextLine();

                            try
                            {
                                sellChoice = Integer.parseInt(input) - 1;
                                intInvalid = false;
                            }
                            catch (NumberFormatException e)
                            {
                                printSlow(0, "Invalid input!", 1, 30);
                            }
                        }
                    }
                }while(selectLoop == true);
            }
            catch(NumberFormatException e)
            {
                printSlow(0, "Invalid input!", 1, 30);
            }

        }
        else
        {
            printSlow(1, "You don't have anything to sell!", 1, 20);
        }
    }
    
}
