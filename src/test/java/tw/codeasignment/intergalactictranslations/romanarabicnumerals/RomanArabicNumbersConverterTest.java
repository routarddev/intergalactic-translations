package tw.codeasignment.intergalactictranslations.romanarabicnumerals;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RomanArabicNumbersConverterTest {
	
	RomanArabicNumbersConverter ranc = new RomanArabicNumbersConverter();

	@Test(expected=NumberFormatException.class)
	public void testRomanToArabicNull() {
		ranc.romanToArabic(null);
	}
	
	@Test(expected=NumberFormatException.class)
	public void testRomanToArabicVoid() {
		ranc.romanToArabic("");
	}
	
	@Test(expected=NumberFormatException.class)
	public void testRomanToArabicInvalidValue() {
		ranc.romanToArabic("K");
	}
	
	@Test
	public void testBasicsRomanToArabic() {
		assertEquals(1, ranc.romanToArabic("I"));
		assertEquals(5, ranc.romanToArabic("V"));
		assertEquals(10, ranc.romanToArabic("X"));
		assertEquals(50, ranc.romanToArabic("L"));
		assertEquals(100, ranc.romanToArabic("C"));
		assertEquals(500, ranc.romanToArabic("D"));
		assertEquals(1000, ranc.romanToArabic("M"));
	}
	
	@Test
	public void testCombiRomanToArabic() {
		assertEquals(1, ranc.romanToArabic("I"));
		assertEquals(2, ranc.romanToArabic("II"));
		assertEquals(3, ranc.romanToArabic("III"));
		assertEquals(4, ranc.romanToArabic("IV"));
		assertEquals(5, ranc.romanToArabic("V"));
		assertEquals(6, ranc.romanToArabic("VI"));
		assertEquals(7, ranc.romanToArabic("VII"));
		assertEquals(8, ranc.romanToArabic("VIII"));
		assertEquals(9, ranc.romanToArabic("IX"));
		assertEquals(10, ranc.romanToArabic("X"));
		assertEquals(12, ranc.romanToArabic("XII"));
		assertEquals(14, ranc.romanToArabic("XIV"));
		assertEquals(19, ranc.romanToArabic("XIX"));
		assertEquals(20, ranc.romanToArabic("XX"));
		assertEquals(50, ranc.romanToArabic("L"));
		assertEquals(100, ranc.romanToArabic("C"));
		assertEquals(500, ranc.romanToArabic("D"));
		assertEquals(782, ranc.romanToArabic("DCCLXXXII"));
		assertEquals(1000, ranc.romanToArabic("M"));
		assertEquals(1529, ranc.romanToArabic("MDXXIX"));
		assertEquals(3000, ranc.romanToArabic("MMM"));
		assertEquals(3999, ranc.romanToArabic("MMMCMXCIX"));
	}
	
	@Test
	public void testBasicsArabicToRoman() {
		assertEquals("I", ranc.arabicToRoman(1));
		assertEquals("X", ranc.arabicToRoman(10));
		assertEquals("C", ranc.arabicToRoman(100));
	}
	
	@Test
	public void testCombiArabicToRoman() {
		assertEquals("III", ranc.arabicToRoman(3));
		assertEquals("XXVII", ranc.arabicToRoman(27));
		assertEquals("CLIV", ranc.arabicToRoman(154));
		assertEquals("DCCXCVIII", ranc.arabicToRoman(798));
		assertEquals("MMMCMXCIX", ranc.arabicToRoman(3999));
	}
	
	@Test(expected=NumberFormatException.class)
	public void testArabicToRomanOutOfBoundUpper() {
		ranc.arabicToRoman(4000);
	}
	
	@Test(expected=NumberFormatException.class)
	public void testArabicToRomanOutOfBoundLower() {
		ranc.arabicToRoman(-1);
	}
	
	@Test(expected=NumberFormatException.class)
	public void testArabicToRomanZero() {
		ranc.arabicToRoman(0);
	}

}
