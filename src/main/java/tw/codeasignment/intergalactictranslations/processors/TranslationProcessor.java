package tw.codeasignment.intergalactictranslations.processors;

import java.util.HashMap;

import tw.codeasignment.intergalactictranslations.romanarabicnumerals.RomanArabicNumbersConverter;
import tw.codeasignment.intergalactictranslations.utils.Constants;

/**
 * 
 *
 */
public class TranslationProcessor {

	/**
	 * Constructor of TranslationProcessor class
	 */
	public TranslationProcessor() {
	}

	/**
	 * 
	 * @param lineTokens
	 * @param translationNotes
	 */
	public void mapEquivalences(String[] lineTokens, HashMap<String, String> translationNotes) {
		
		if (!lineTokens[0].isEmpty() && !lineTokens[1].isEmpty()) {
			String[] tokenNumber = lineTokens[0].split(" ");
			//Single correspondences
			if (tokenNumber.length == 1) {
				//Used to find the value and equivalence of the first intergalactic number
				if (lineTokens[1].trim().toUpperCase().equals("I"))
					translationNotes.put("I", lineTokens[0].trim());
				translationNotes.put(lineTokens[0].trim(), lineTokens[1].trim());
			//Correspondences that need to be calculated
			} else {
				int arabicValue = intergalacticToArabicConversion(tokenNumber, translationNotes);
				String currencyValue = lineTokens[1].replace(Constants.CURRENCY, "").trim();
				float singleEquivalence = Float.parseFloat(currencyValue) / arabicValue;
				String key = translationNotes.get("I") + " " + tokenNumber[tokenNumber.length-1];
				translationNotes.put(key, Float.toString(singleEquivalence));
			}
		}
	}
	
	/**
	 * 
	 * @param lineToken
	 * @param translationNotes
	 * @param directTranslation
	 * @return
	 */
	public String processTranslation(String lineToken, 
			HashMap<String, String> translationNotes, 
			boolean directTranslation) {
		
		String[] tokensArray = lineToken.split(" ");
		int finalValue = intergalacticToArabicConversion(tokensArray, translationNotes);

		StringBuilder sb = new StringBuilder(lineToken + Constants.QUERY_SEPARATOR);
		if (!directTranslation) {
			String key = translationNotes.get("I") + " " + tokensArray[tokensArray.length - 1];
			if (translationNotes.containsKey(key)) {
				finalValue *= Float.parseFloat(translationNotes.get(key));
				sb.append(Integer.toString(finalValue) + " " + Constants.CURRENCY);
			} else {
				sb = null;
			}
		} else {
			sb.append(Integer.toString(finalValue));
		}
		
		return sb == null ? null : sb.append(Constants.NEW_LINE).toString();
	}
	
	/**
	 * 
	 * @param tokensArray
	 * @param translationNotes
	 * @return
	 */
	private static int intergalacticToArabicConversion(
			String[] tokensArray, 
			HashMap<String, String> translationNotes) {
		
		StringBuilder notesValue = new StringBuilder();
		for(String token: tokensArray) {
			if (translationNotes.containsKey(token))
				notesValue.append(translationNotes.get(token));
		}
		
		RomanArabicNumbersConverter ranc = new RomanArabicNumbersConverter();
		return ranc.romanToArabic(notesValue.toString());
	}

}
