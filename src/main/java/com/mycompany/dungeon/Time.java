package com.mycompany.dungeon;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Class that holds the methods used for time delay
 */
public class Time {

    private static final Logger logger = LoggerFactory.getLogger(Time.class);

    /**
     * Sleeps the program for a specifated amount of SECONDS
     * @param seconds How many seconds you want to delay
     */

    public static void sleep(int seconds)
    {
        try 
            {
                TimeUnit.SECONDS.sleep(seconds);
            } 
            catch (InterruptedException ex) 
            {
                logger.error("An error occurred when sleeping", ex);
            }
    }

    /**
     * Sleeps the program for a specifated amount of MILLISECONDS
     * @param MILLISECONDS How many Milliseconds you want to delay
     */

    public static void sleepMil(int MILLISECONDS)
    {
        try 
            {
                TimeUnit.MILLISECONDS.sleep(MILLISECONDS);
            } 
            catch (InterruptedException ex) 
            {
                logger.error("An error occurred when sleeping (2)", ex);
            }
    }
}
