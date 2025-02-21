package com.mycompany.dungeon;

import java.util.Scanner;

import static com.mycompany.dungeon.Typewriter.printSlow;

public class ParseInput {
    
    public static int getInt(int startInput, int endInput, String error)
    {
        int value = 0;
        boolean repeat = true;
        do
        {
            printSlow(0, "User: ", 0, 15);
            Scanner txt = new Scanner(System.in);
            String input = txt.nextLine();
            try
            {
                value = Integer.parseInt(input);
                if (value >= startInput && value <= endInput)
                {
                    repeat = false;
                }
                else
                {
                    printSlow(1, "Your input has to be from " + startInput + " to " + endInput + "!", 1, 15);
                }
            }
            catch (NumberFormatException e)
            {
                printSlow(1, "Invalid input!", 1, 15);
            }
        } while (repeat);
        return value;
    }
}
