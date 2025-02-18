package com.mycompany.dungeon;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author johnkufta
 */
public class Typewriter {
    /**
     * Default print in this game. Used to print letter by letter based on Delay
     * @param nlStart How many newlines at the start of the String
     * @param text the Text desplayed
     * @param nlEnd How many newlines at the end of the String
     * @param delay Speed which you would like to say the text (In Millisenconds)
     * Fast: 30 - 49
     * Normal: 50 - 70
     * Slow: 70 - 85
     * Very Slow: 85+
     */
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
