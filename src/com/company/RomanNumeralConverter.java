package com.company;

/**
 * Created by lawrence on 3/27/16.
 */
public class RomanNumeralConverter {
    public String convertToRomanNumeral(Integer userInput) {
        String[] romanNumerals = {"M", "D", "C", "L", "X", "IX", "V", "IV", "I"};
        Integer[] romanNumeralValues = {1000, 500, 100, 50, 10, 9, 5, 4, 1};
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
}
