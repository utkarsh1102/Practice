package com.question.practice;

import java.util.Scanner;

public class accenture2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "Hello World";


        String result = convertCase(input);


        System.out.println("Converted String: " + result);
    }
    public static String convertCase(String str) {
        int upperCount = 0;
        int lowerCount = 0;

        // Count uppercase and lowercase letters
        for (char ch : str.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                upperCount++;
            } else if (Character.isLowerCase(ch)) {
                lowerCount++;
            }
        }

        // Convert the string based on the counts
        if (upperCount > lowerCount) {
            return str.toUpperCase();
        } else {
            return str.toLowerCase();
        }
    }
}

