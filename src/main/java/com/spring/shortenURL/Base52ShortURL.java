package com.spring.shortenURL;

import java.util.Random;

public class Base52ShortURL {
    private static final String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int base = characters.length();
    private static final int shortURLLength = 6;

    public static void main(String[] args) {
        String url = "www.naver.com";
        String shortUrl = generateShortURL(url);
        System.out.println("Short URL: " + shortUrl);
    }

    public static String generateShortURL(String longURL) {
        StringBuilder shortURL = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < shortURLLength; i++) {
            int index = random.nextInt(base);
            shortURL.append(characters.charAt(index));
        }

        return shortURL.toString();
    }
}
