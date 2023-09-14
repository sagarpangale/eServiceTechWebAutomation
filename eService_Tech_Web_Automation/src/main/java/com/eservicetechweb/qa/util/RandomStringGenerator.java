package com.eservicetechweb.qa.util;

public class RandomStringGenerator {

    public String getRandomString(int n) {

        // choose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz";

        String NumberString = "0123456789";
        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n - 3; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int) (AlphaNumericString.length() * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString.charAt(index));
        }
        System.out.println(sb);
        for (int i = n - 3; i < n; i++) {

            // generate a random number between
            // 0 to NumberString variable length
            int index = (int) (NumberString.length() * Math.random());

            // add Character one by one in end of sb
            sb.append(NumberString.charAt(index));
        }


        return sb.toString();
    }

}
