package com.company;

/**
 * Created by lawrence on 3/27/16.
 */
public class RomanNumeralConverter {
    public String convertToRomanNumeral(Integer userInput) {
        String[] romanNumerals = {"III", "II", "I"};
        Integer[] romanNumeralValues = {3, 2, 1};
        String outputValue = "";

        for (int i = 0; i < romanNumerals.length; i++) {
            if (userInput == romanNumeralValues[i]) {
                outputValue = romanNumerals[i];
            }
        }
        return outputValue;
    }
}
