import com.company.RomanNumeralConverter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by lawrence on 3/27/16.
 */
public class testRomanNumeralConverter {
    @Test
    public void testIntegerOneReturnsI() {
        RomanNumeralConverter romanNumeralConverter = new RomanNumeralConverter();
        assertEquals("I", romanNumeralConverter.convertToRomanNumeral(1));
    }

    @Test
    public  void testTestIntegerUpToThreeReturnsCorrectRomanNumeral() {
        RomanNumeralConverter romanNumeralConverter = new RomanNumeralConverter();
        assertEquals("II", romanNumeralConverter.convertToRomanNumeral(2));
        assertEquals("III", romanNumeralConverter.convertToRomanNumeral(3));
    }

    @Test
    public void testReturnOfSingleRomanNumeralsVXLCDM() {
        RomanNumeralConverter romanNumeralConverter = new RomanNumeralConverter();
        assertEquals("V", romanNumeralConverter.convertToRomanNumeral(5));
        assertEquals("X", romanNumeralConverter.convertToRomanNumeral(10));
        assertEquals("L", romanNumeralConverter.convertToRomanNumeral(50));
        assertEquals("C", romanNumeralConverter.convertToRomanNumeral(100));
        assertEquals("D", romanNumeralConverter.convertToRomanNumeral(500));
        assertEquals("M", romanNumeralConverter.convertToRomanNumeral(1000));
    }
}
