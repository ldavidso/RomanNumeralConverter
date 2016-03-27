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
    public void testIntegerOneReturnsI() {
        assertEquals("I", romanNumeralConverter.convertToRomanNumeral(1));
    }

    @Test
    public  void testTestIntegerUpToThreeReturnsCorrectRomanNumeral() {
        assertEquals("II", romanNumeralConverter.convertToRomanNumeral(2));
        assertEquals("III", romanNumeralConverter.convertToRomanNumeral(3));
    }

    @Test
    public void testReturnOfSingleRomanNumeralsVXLCDM() {
        assertEquals("V", romanNumeralConverter.convertToRomanNumeral(5));
        assertEquals("X", romanNumeralConverter.convertToRomanNumeral(10));
        assertEquals("L", romanNumeralConverter.convertToRomanNumeral(50));
        assertEquals("C", romanNumeralConverter.convertToRomanNumeral(100));
        assertEquals("D", romanNumeralConverter.convertToRomanNumeral(500));
        assertEquals("M", romanNumeralConverter.convertToRomanNumeral(1000));
    }
}
