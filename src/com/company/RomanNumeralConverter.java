package com.company;

/**
 * Created by lawrence on 3/27/16.
 */
public class RomanNumeralConverter {

    private static String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static Integer[] romanNumeralValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public String convertToRoman(Integer userInput) {
        if(!validArabic(userInput)) return "Please use a number between 1 - 3999";

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

    private Boolean validArabic(Integer userInput) {
        if (userInput > 3999 || userInput <= 0) {
            return false;
        }
        return true;
    }

    public String convertToArabic(String userInput) {
        String[] validForI = {"X", "V", "I"};
        String[] validForX = {"C", "L", "X", "V", "I"};
        boolean validRomanNumeral;
        String romanNumeral;

        if (!validRomanNumeral(userInput)) return "Invalid roman numeral!";

        int outputValue = 0;
        int userInputLength = userInput.length();

        while (userInputLength > 0) {
            for (int i = 0; i < romanNumerals.length; i++) {
                int currentRomanNumeralLength = romanNumerals[i].length();
                // first checks to see if userInput can substring() based on current length of userInput and current Roman Numeral being tested.
                if (userInputLength >= currentRomanNumeralLength && userInput.substring(0,currentRomanNumeralLength).equals(romanNumerals[i])) {
                    // used to validate subtraction rule.
                    if (userInputLength  > 1) {
                        validRomanNumeral = false;
                        switch (romanNumerals[i]) {
                            case "I":
                                romanNumeral = userInput.substring(1,2);
                                for (String validI: validForI) {
                                    if(romanNumeral.equals(validI)) {
                                        validRomanNumeral = true;
                                        break;
                                    }
                                }
                                break;
                            case "X":
                                romanNumeral = userInput.substring(1,2);
                                for (String validX: validForX) {
                                    if(romanNumeral.equals(validX)) {
                                        validRomanNumeral = true;
                                        break;
                                    }
                                }
                                break;
                            default:
                                validRomanNumeral = true;
                                break;
                        }
                        if (!validRomanNumeral) {
                            return "Invalid roman numeral!";
                        }
                    }
                    outputValue += romanNumeralValues[i];
                    userInput = userInput.substring(currentRomanNumeralLength, userInputLength);
                    userInputLength -= currentRomanNumeralLength;
                    break;
                }
            }
        }
        return  Integer.toString(outputValue);
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
}
