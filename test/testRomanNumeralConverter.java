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
}
