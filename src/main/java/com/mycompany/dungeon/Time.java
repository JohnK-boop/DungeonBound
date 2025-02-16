package com.mycompany.dungeon;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Time {

    private static final Logger logger = LoggerFactory.getLogger(Time.class);

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
