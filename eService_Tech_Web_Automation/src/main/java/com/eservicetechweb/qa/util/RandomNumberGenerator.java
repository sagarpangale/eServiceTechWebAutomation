package com.eservicetechweb.qa.util;

import java.util.Random;

public class RandomNumberGenerator {

    public static int getRandomNumber(int max, int min) {

        Random random = new Random();
        int randomInt = random.nextInt(max - min) + min;
//        System.out.println(randomInt);
        return randomInt;

    }

}
