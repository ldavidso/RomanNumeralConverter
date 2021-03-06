package com.company;

/**
 * Created by lawrence on 3/27/16.
 */
public class RomanNumeralConverter {

    private static String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static Integer[] romanNumeralValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private int userInputLength;
    private int currentRomanNumeralLength;

    public String convertToRoman(Integer userInput) {
        if(!validArabic(userInput)) return "Please use a number between 1 - 3999";
        StringBuilder outputValue = new StringBuilder();
        while (userInput > 0) {
            int n = getNextRomanNumeralValueIndex(userInput);
            userInput -= romanNumeralValues[n];
            outputValue.append(romanNumerals[n]);
        }
        return outputValue.toString();
    }

    public String convertToArabic(String userInput) {
        userInput = userInput.toUpperCase();
        if (!validRomanNumeral(userInput)) return "Invalid roman numeral!";
        int outputValue = 0;
        userInputLength = userInput.length();
        while (userInputLength > 0) {
            outputValue += parseNextRomanNumeral(userInput);
            if (outputValue == -1) return "Invalid roman numeral!";
            userInput = userInput.substring(currentRomanNumeralLength, userInputLength);
            userInputLength -= currentRomanNumeralLength;
        }
        return  Integer.toString(outputValue);
    }

    private Boolean validArabic(Integer userInput) {
        if (userInput > 3999 || userInput <= 0) return false;
        return true;
    }

    private boolean validRomanNumeral(String userInput) {
        String[] invalidSequences = {"IIII", "XXXX", "CCCC", "MMMM", "VV", "LL", "DD"};
        if (userInput.isEmpty()) return false;
        if (!userInput.matches("^[IVXLCDM]+$")) return false;
        for (String invalidSequence: invalidSequences) {
            if(userInput.contains(invalidSequence)) return false;
        }
        return true;
    }

    private Integer getNextRomanNumeralValueIndex(Integer userInput) {
        int i;
        for (i = 0; i < romanNumerals.length; i++) {
            if (userInput - romanNumeralValues[i] >= 0) break;
        }
        return i;
    }

    private Integer parseNextRomanNumeral(String userInput) {
        int outputValue = 0;
        for (int i = 0; i < romanNumerals.length; i++) {
            currentRomanNumeralLength = romanNumerals[i].length();
            if (userInputLength > 1 && !validateNextRomanNumeralPart(romanNumerals[i], userInput.substring(1,2))) return -1;
            if (userInputLength >= currentRomanNumeralLength
                    && userInput.substring(0,currentRomanNumeralLength).equals(romanNumerals[i])) {
                outputValue = romanNumeralValues[i];
                break;
            }
        }
        return outputValue;
    }

    private boolean validateNextRomanNumeralPart(String firstRomanNumeral, String precedingRomanNumeral) {
        if (!firstRomanNumeral.matches("[I|X]")) return true;
        String[] validRomanNumerals;
        if (firstRomanNumeral.equals("I")) {
            validRomanNumerals = new String [] {"X", "V", "I"};
        } else {
            validRomanNumerals = new String [] {"C", "L", "X", "V", "I"};
        }
        for (String validRomanNumeral: validRomanNumerals) {
            if(precedingRomanNumeral.equals(validRomanNumeral)) return true;
        }
        return false;
    }
}
