package tw.codeasignment.intergalactictranslations.processors;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import tw.codeasignment.intergalactictranslations.utils.Constants;

/**
 * 
 *
 */
public class FileProcessor {

	/**
	 * Constructor of FileProcessor class
	 */
	public FileProcessor() {
	}
	
	/**
	 * 
	 * @param line
	 * @param translationNotes
	 * @param fileWriter
	 */
	public void processLine(
			String line, 
			HashMap<String, String> translationNotes, 
			FileWriter fileWriter) 
	{
		TranslationProcessor translationProcessor = new TranslationProcessor();
		
		if (line.toLowerCase().contains(Constants.QUERY_SEPARATOR)) {
			
			String[] lineTokens = line.split(Constants.QUERY_SEPARATOR);
			
			//Map equivalences
			if (	!line.toLowerCase().contains(Constants.DIRECT_TRANSLATION) &&
					!line.toLowerCase().contains(Constants.CALCULATED_TRANSLATION) ) {
				
				translationProcessor.mapEquivalences(lineTokens, translationNotes);
					
			//Proceed to translations
			} else {
				String resultLine = translationProcessor.processTranslation(	
										lineTokens[1].trim().replace(Constants.QUESTION_SIGN, ""),
										translationNotes,  
										line.toLowerCase().contains(Constants.DIRECT_TRANSLATION));
				if (resultLine != null)
					writeToOutputFile(fileWriter, resultLine);
				else
					writeToOutputFile(fileWriter, Constants.UNKNOWN_ANSWER);
			}
		} else {
			writeToOutputFile(fileWriter, Constants.UNKNOWN_ANSWER);
		}
 	}
	
	/**
	 * 
	 * @param fileWriter
	 * @param line
	 */
	private void writeToOutputFile(FileWriter fileWriter, String line) {
		try {
			fileWriter.write(line);
		} catch (IOException e) {
			System.out.println("IOException occurred: "+ e.getMessage());
		}
	}

}
