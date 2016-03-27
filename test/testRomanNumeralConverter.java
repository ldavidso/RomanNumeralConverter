import com.company.RomanNumeralConverter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        assertEquals("I", romanNumeralConverter.convert(1));
        assertEquals("V", romanNumeralConverter.convert(5));
        assertEquals("X", romanNumeralConverter.convert(10));
        assertEquals("L", romanNumeralConverter.convert(50));
        assertEquals("C", romanNumeralConverter.convert(100));
        assertEquals("D", romanNumeralConverter.convert(500));
        assertEquals("M", romanNumeralConverter.convert(1000));
    }

    @Test
    public void testAdditionRuleForRomanNumeralsIXCM() {
        assertEquals("III", romanNumeralConverter.convert(3));
        assertEquals("XXX", romanNumeralConverter.convert(30));
        assertEquals("CCC", romanNumeralConverter.convert(300));
        assertEquals("MMM", romanNumeralConverter.convert(3000));
    }

    @Test
    public void testSubtractionRuleForRomanNumeralI() {
        assertEquals("IV", romanNumeralConverter.convert(4));
        assertEquals("IX", romanNumeralConverter.convert(9));
    }

    @Test
    public void testSubtractionRuleForRomanNumeralX() {
        assertEquals("XL", romanNumeralConverter.convert(40));
        assertEquals("XC", romanNumeralConverter.convert(90));
    }

    @Test
    public void testSubtractionRuleForRomanNumeralC() {
        assertEquals("CD", romanNumeralConverter.convert(400));
        assertEquals("CM", romanNumeralConverter.convert(900));
    }

    @Test
    public void testComplexRomanNumeralConversionReturnsCorrectRomanNumerals() {
        assertEquals("MLXVI", romanNumeralConverter.convert(1066));
        assertEquals("MCMLXXXIX", romanNumeralConverter.convert(1989));
    }

    @Test
    public void testNumberTooLargeForRomanNumeralConversionReturnsMessage() {
        assertEquals("Please use a number between 1 - 3999", romanNumeralConverter.convert(4000));
    }

    @Test
    public void testNegativeNumbersAndZeroForRomanNumeralConversionReturnsMessage() {
        assertEquals("Please use a number between 1 - 3999", romanNumeralConverter.convert(0));
        assertEquals("Please use a number between 1 - 3999", romanNumeralConverter.convert(-1));
    }

    @Test
    public void testRomanNumeralIReturnsCorrectNumber() {
        assertEquals("1", romanNumeralConverter.convert("I"));
    }

    @Test
    public void testIndividualRomanNumeralsReturnsCorrectNumbers() {
        assertEquals("5", romanNumeralConverter.convert("V"));
        assertEquals("10", romanNumeralConverter.convert("X"));
        assertEquals("50", romanNumeralConverter.convert("L"));
        assertEquals("100", romanNumeralConverter.convert("C"));
        assertEquals("500", romanNumeralConverter.convert("D"));
        assertEquals("1000", romanNumeralConverter.convert("M"));
    }

    @Test
    public void testAdditionRuleForConversionFromRomanNumeralToNumber() {
        assertEquals("3", romanNumeralConverter.convert("III"));
        assertEquals("30", romanNumeralConverter.convert("XXX"));
        assertEquals("300", romanNumeralConverter.convert("CCC"));
        assertEquals("3000", romanNumeralConverter.convert("MMM"));
    }
}
