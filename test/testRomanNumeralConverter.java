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
        assertEquals("I", romanNumeralConverter.convertToRomanNumeral(1));
        assertEquals("V", romanNumeralConverter.convertToRomanNumeral(5));
        assertEquals("X", romanNumeralConverter.convertToRomanNumeral(10));
        assertEquals("L", romanNumeralConverter.convertToRomanNumeral(50));
        assertEquals("C", romanNumeralConverter.convertToRomanNumeral(100));
        assertEquals("D", romanNumeralConverter.convertToRomanNumeral(500));
        assertEquals("M", romanNumeralConverter.convertToRomanNumeral(1000));
    }

    @Test
    public void testAdditionRuleForRomanNumeralsIXCM() {
        assertEquals("III", romanNumeralConverter.convertToRomanNumeral(3));
        assertEquals("XXX", romanNumeralConverter.convertToRomanNumeral(30));
        assertEquals("CCC", romanNumeralConverter.convertToRomanNumeral(300));
        assertEquals("MMM", romanNumeralConverter.convertToRomanNumeral(3000));
    }

    @Test
    public void testSubtractionRuleForRomanNumeralI() {
        assertEquals("IV", romanNumeralConverter.convertToRomanNumeral(4));
        assertEquals("IX", romanNumeralConverter.convertToRomanNumeral(9));
    }

    @Test
    public void testSubtractionRuleForRomanNumeralX() {
        assertEquals("XL", romanNumeralConverter.convertToRomanNumeral(40));
        assertEquals("XC", romanNumeralConverter.convertToRomanNumeral(90));
    }

    @Test
    public void testSubtractionRuleForRomanNumeralC() {
        assertEquals("CD", romanNumeralConverter.convertToRomanNumeral(400));
        assertEquals("CM", romanNumeralConverter.convertToRomanNumeral(900));
    }

    @Test
    public void testComplexRomanNumeralConversionReturnsCorrectRomanNumerals() {
        assertEquals("MLXVI", romanNumeralConverter.convertToRomanNumeral(1066));
        assertEquals("MCMLXXXIX", romanNumeralConverter.convertToRomanNumeral(1989));
    }

    @Test
    public void testNumberTooLargeForRomanNumeralConversionReturnsMessage() {
        assertEquals("Please use a number between 1 - 3999", romanNumeralConverter.convertToRomanNumeral(4000));
    }
}
