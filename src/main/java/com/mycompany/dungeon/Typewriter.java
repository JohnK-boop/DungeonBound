package com.mycompany.dungeon;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author johnkufta
 */
public class Typewriter {
    public static void printSlow(String text, int delay, boolean nl)
    {
        if (nl == true)
        {
            System.out.println("");
        }
        else
        {
            System.out.print("");
        }
        
        for (char letter : text.toCharArray())
        {
            System.out.print(letter);
            try
            {
                TimeUnit.MILLISECONDS.sleep(delay);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        
    }
}
