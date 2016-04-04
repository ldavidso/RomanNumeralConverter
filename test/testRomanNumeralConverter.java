import com.company.RomanNumeralConverter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by lawrence on 3/27/16.
 */
public class testRomanNumeralConverter {
    private RomanNumeralConverter romanNumeralConverter;
    @Before
    public void setUp() {
        romanNumeralConverter = new RomanNumeralConverter();
    }

    @Test
    public void testReturnOfSingleRomanNumeralsIVXLCDM() {
        assertEquals("I", romanNumeralConverter.convertToRoman(1));
        assertEquals("V", romanNumeralConverter.convertToRoman(5));
        assertEquals("X", romanNumeralConverter.convertToRoman(10));
        assertEquals("L", romanNumeralConverter.convertToRoman(50));
        assertEquals("C", romanNumeralConverter.convertToRoman(100));
        assertEquals("D", romanNumeralConverter.convertToRoman(500));
        assertEquals("M", romanNumeralConverter.convertToRoman(1000));
    }

    @Test
    public void testAdditionRuleForRomanNumeralsIXCM() {
        assertEquals("III", romanNumeralConverter.convertToRoman(3));
        assertEquals("XXX", romanNumeralConverter.convertToRoman(30));
        assertEquals("CCC", romanNumeralConverter.convertToRoman(300));
        assertEquals("MMM", romanNumeralConverter.convertToRoman(3000));
    }

    @Test
    public void testSubtractionRuleForRomanNumeralI() {
        assertEquals("IV", romanNumeralConverter.convertToRoman(4));
        assertEquals("IX", romanNumeralConverter.convertToRoman(9));
    }

    @Test
    public void testSubtractionRuleForRomanNumeralX() {
        assertEquals("XL", romanNumeralConverter.convertToRoman(40));
        assertEquals("XC", romanNumeralConverter.convertToRoman(90));
    }

    @Test
    public void testSubtractionRuleForRomanNumeralC() {
        assertEquals("CD", romanNumeralConverter.convertToRoman(400));
        assertEquals("CM", romanNumeralConverter.convertToRoman(900));
    }

    @Test
    public void testComplexRomanNumeralConversionReturnsCorrectRomanNumerals() {
        assertEquals("MLXVI", romanNumeralConverter.convertToRoman(1066));
        assertEquals("MCMLXXXIX", romanNumeralConverter.convertToRoman(1989));
    }

    @Test
    public void testNumberTooLargeForRomanNumeralConversionReturnsMessage() {
        assertEquals("Please use a number between 1 - 3999", romanNumeralConverter.convertToRoman(4000));
    }

    @Test
    public void testNegativeNumbersAndZeroForRomanNumeralConversionReturnsMessage() {
        assertEquals("Please use a number between 1 - 3999", romanNumeralConverter.convertToRoman(0));
        assertEquals("Please use a number between 1 - 3999", romanNumeralConverter.convertToRoman(-1));
    }

    @Test
    public void testIndividualRomanNumeralsReturnsCorrectNumbers() {
        assertEquals("1", romanNumeralConverter.convertToArabic("I"));
        assertEquals("5", romanNumeralConverter.convertToArabic("V"));
        assertEquals("10", romanNumeralConverter.convertToArabic("X"));
        assertEquals("50", romanNumeralConverter.convertToArabic("L"));
        assertEquals("100", romanNumeralConverter.convertToArabic("C"));
        assertEquals("500", romanNumeralConverter.convertToArabic("D"));
        assertEquals("1000", romanNumeralConverter.convertToArabic("M"));
    }

    @Test
    public void testAdditionRuleForConversionFromRomanNumeralToNumber() {
        assertEquals("3", romanNumeralConverter.convertToArabic("III"));
        assertEquals("30", romanNumeralConverter.convertToArabic("XXX"));
        assertEquals("300", romanNumeralConverter.convertToArabic("CCC"));
        assertEquals("3000", romanNumeralConverter.convertToArabic("MMM"));
    }

    @Test
    public void testSubtractionRuleForConversionFromRomanNumeralToNumber() {
        assertEquals("4", romanNumeralConverter.convertToArabic("IV"));
        assertEquals("9", romanNumeralConverter.convertToArabic("IX"));
        assertEquals("40", romanNumeralConverter.convertToArabic("XL"));
        assertEquals("90", romanNumeralConverter.convertToArabic("XC"));
        assertEquals("400", romanNumeralConverter.convertToArabic("CD"));
        assertEquals("900", romanNumeralConverter.convertToArabic("CM"));
    }

    @Test
    public void testComplexRomanNumeralsConversionReturnsCorrectNumbers() {
        assertEquals("1066", romanNumeralConverter.convertToArabic("MLXVI"));
        assertEquals("1989", romanNumeralConverter.convertToArabic("MCMLXXXIX"));
    }

    @Test
    public void testInvalidRomanNumeralWithOverThreeInARow() {
        assertEquals("Invalid roman numeral!", romanNumeralConverter.convertToArabic("IIII"));
        assertEquals("Invalid roman numeral!", romanNumeralConverter.convertToArabic("XXXX"));
        assertEquals("Invalid roman numeral!", romanNumeralConverter.convertToArabic("CCCC"));
        assertEquals("Invalid roman numeral!", romanNumeralConverter.convertToArabic("MMMM"));
    }

    @Test
    public void testInvalidRomanNumeralsThatShouldNotHaveMoreThanOneInARow() {
        assertEquals("Invalid roman numeral!", romanNumeralConverter.convertToArabic("VV"));
        assertEquals("Invalid roman numeral!", romanNumeralConverter.convertToArabic("LL"));
        assertEquals("Invalid roman numeral!", romanNumeralConverter.convertToArabic("DD"));
    }

    @Test
    public void testInvalidRomanNumeralSubtractionRule() {
        assertEquals("Invalid roman numeral!", romanNumeralConverter.convertToArabic("IL"));
        assertEquals("Invalid roman numeral!", romanNumeralConverter.convertToArabic("IC"));
        assertEquals("Invalid roman numeral!", romanNumeralConverter.convertToArabic("ID"));
        assertEquals("Invalid roman numeral!", romanNumeralConverter.convertToArabic("IM"));
        assertEquals("Invalid roman numeral!", romanNumeralConverter.convertToArabic("XM"));
        assertEquals("Invalid roman numeral!", romanNumeralConverter.convertToArabic("XD"));
    }

    @Test
    public void testInvalidTextInputToConvertFromRomanNumeralToNumber() {
        assertEquals("Invalid roman numeral!", romanNumeralConverter.convertToArabic("ABCDE"));
    }

    @Test
    public void testLowerCaseInput() {
        assertEquals("1989", romanNumeralConverter.convertToArabic("mcmlxxxix"));
    }
}
