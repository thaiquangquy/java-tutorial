package org.example.adnovum;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        String input = "Hello world";

        System.out.println("Input: " + input);
        System.out.println("Reverse: " + reverseString(input));
    }

    private static String reverseString(String input) {
        if (Objects.equals(input, "")) {
            return "";
        }

        char[] charBuf = input.toCharArray();
        int length = input.length();
        for(int i = 0; i <= length / 2; i++) {
            if (i != length - i - 1) {
                char charStart = charBuf[i];
                charBuf[i] = charBuf[length - i - 1];
                charBuf[length - i - 1] = charStart;
            }
        }

        return new String(charBuf);
    }
}
