package sims.gameEngine;

import java.util.Random;

public class Utility {

    private static final Random random = new Random();

    // Below is a random number generator that takes in a minimum and a maximum
    public static int randomNumberBetween(int min, int max){
        return random.nextInt(max - min + 1) + min;
    }

}
