package org.example;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Random;

public class RandomUtils {

    private static final SecureRandom SECURE = new SecureRandom();
    private static final Random THREAD = new Random();

    private static final String DIGITS       = "0123456789";
    private static final String UPPER        = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER        = UPPER.toLowerCase(Locale.ROOT);
    private static final String ALPHA        = UPPER + LOWER;
    private static final String ALPHANUMERIC = ALPHA + DIGITS;

    private static final String[] NAMES = {
        "Kurtika", "Vishal", "Anita", "Pavan", "Joseph", "Aisha", "Rohan","Sumit","Kalpesh"
    };

    public static String randomDigits(int length) {
        return buildRandom(length, DIGITS, SECURE);
    }

    public static String randomAlpha(int length) {
        return buildRandom(length, ALPHA, SECURE);
    }

    public static String randomAlphanumeric(int length) {
        return buildRandom(length, ALPHANUMERIC, SECURE);
    }

    public static String randomName() {
        return NAMES[THREAD.nextInt(NAMES.length)];
    }

    private static String buildRandom(int length, String chars, Random rand) {
        if (length < 1) throw new IllegalArgumentException("Length must be positive");
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return sb.toString();
    }

//    public static void main(String[] args) {
//        System.out.println("Digits(8): "       + randomDigits(8));
//        System.out.println("Letters(8): "      + randomAlpha(8));
//        System.out.println("Alphanum(12): "    + randomAlphanumeric(12));
//        System.out.println("Random name: "     + randomName());
//    }
    
}
