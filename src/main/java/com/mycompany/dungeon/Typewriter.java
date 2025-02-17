package com.mycompany.dungeon;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author johnkufta
 */
public class Typewriter {
    public static void printSlow(int nlStart, String text, int nlEnd, int delay)
    {

        for (int i = 0; i < nlStart; i++)
        {
            System.out.println("");
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

        for (int i = 0; i < nlEnd; i++)
        {
            System.out.println("");
        }
        
    }
}
