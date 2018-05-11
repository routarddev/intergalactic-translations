package tw.codeasignment.intergalactictranslations.romanarabicnumerals;

/**
 * 
 *
 */
public class RomanArabicNumbersConverter {

	/*
	 * For each i, the number arabicNumbersArray[i] is represented by the 
	 * corresponding string, romanLettersArray[i].
	 */
	private static int[] arabicNumbersArray = { 1000, 900, 500, 400, 100, 90, 50, 40, 
			10, 9, 5, 4, 1 };

	private static String[] romanLettersArray = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", 
			"X", "IX", "V", "IV", "I" };

	/**
	 * Constructor of the RomanArabicNumberConverter class
	 */
	public RomanArabicNumbersConverter() {
	}

	/**
	 * 
	 * @param arabicNumber
	 * @return
	 */
	public String arabicToRoman(int arabicNumber) {
		if (arabicNumber < 1)
			throw new NumberFormatException("Value of RomanArabicNumbersTranslator must be positive.");
		if (arabicNumber > 3999)
			throw new NumberFormatException("Value of RomanArabicNumbersTranslator must be 3999 or less.");

		String romanNumber = "";
		/*
		 * partToBeConverted represents the part of arabicNumber that still has
		 * to be converted to Roman numeral representation.
		 */
		int partToBeConverted = arabicNumber;
		for (int i = 0; i < arabicNumbersArray.length; i++) {
			while (partToBeConverted >= arabicNumbersArray[i]) {
				romanNumber += romanLettersArray[i];
				partToBeConverted -= arabicNumbersArray[i];
			}
		}
		return romanNumber;
	}

	/**
	 * Creates the Roman number with the given representation. For example,
	 * RomanArabicNumbersTranslator("xvii") is 17. If the parameter is not a
	 * legal Roman numeral, a NumberFormatException is thrown. Both upper and
	 * lower case romanLettersArray are allowed.
	 * 
	 * @param String
	 *            representing the roman number
	 */
	public int romanToArabic(String romanNumber) {
		if (romanNumber == null || romanNumber.isEmpty())
			throw new NumberFormatException("An empty or null string does not define a romanNumber numeral.");

		//Convert to upper case romanNumberLettersArray
		romanNumber = romanNumber.toUpperCase();
		int stringPosition = 0;
		
		// Arabic numeral equivalent of the part of the string that has been converted so far
		int arabicNumber = 0;

		while (stringPosition < romanNumber.length()) {
			
			// Letter at current position in string
			char letter = romanNumber.charAt(stringPosition);
			
			// Numerical equivalent of letter
			int number = letterToNumber(letter); 

			if (number < 0)
				throw new NumberFormatException("Illegal character \"" + letter + "\" in romanNumber numeral.");

			stringPosition++;

			if (stringPosition == romanNumber.length()) {
				// There is no letter in the string following the one we have
				// just processed.
				// So just add the number corresponding to the single letter to
				// arabic.
				arabicNumber += number;
			} else {
				// Look at the next letter in the string. If it has a larger
				// romanNumber numeral
				// equivalent than number, then the two romanNumberLettersArray
				// are counted together as
				// a romanNumber numeral with value (nextNumber - number).
				int nextNumber = letterToNumber(romanNumber.charAt(stringPosition));
				if (nextNumber > number) {
					// Combine the two romanNumberLettersArray to get one value,
					// and move on to next position in string.
					arabicNumber += (nextNumber - number);
					stringPosition++;
				} else {
					// Don't combine the romanNumberLettersArray. Just add the
					// value of the one letter onto the number.
					arabicNumber += number;
				}
			}
		}

		if (arabicNumber > 3999)
			throw new NumberFormatException("Roman numeral must have value 3999 or less.");

		return arabicNumber;
	}

	/*
	 * Find the integer value of letter considered as a Roman numeral. Return -1
	 * if letter is not a legal Roman numeral. The letter must be upper case.
	 */
	private int letterToNumber(char letter) {
		switch (letter) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return -1;
		}
	}

}
