package com.company;

/**
 * Created by lawrence on 3/27/16.
 */
public class RomanNumeralConverter {

    private static String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static Integer[] romanNumeralValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};


    public String convert(Integer userInput) {
        if (userInput > 3999 || userInput <= 0) {
            return "Please use a number between 1 - 3999";
        }

        StringBuilder outputValue = new StringBuilder();

        while (userInput > 0) {
            for (int i = 0; i < romanNumerals.length; i++) {
                if (userInput - romanNumeralValues[i] >= 0) {
                    outputValue.append(romanNumerals[i]);
                    userInput -= romanNumeralValues[i];
                    break;
                }
            }
        }
        return outputValue.toString();
    }

    public String convert(String userInput) {
        int outputValue = 0;
        for (int i = 0; i < romanNumerals.length; i++) {
            if (userInput.equals(romanNumerals[i])) {
                outputValue += romanNumeralValues[i];
                break;
            }
        }
        return  Integer.toString(outputValue);
    }
}
