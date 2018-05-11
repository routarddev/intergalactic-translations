package tw.codeasignment.intergalactictranslations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import tw.codeasignment.intergalactictranslations.processors.FileProcessor;
import tw.codeasignment.intergalactictranslations.utils.Constants;


public class IntergalacticTranslations {

public static void main(String[] args) {
		
		String inputFileFullPath = Constants.INPUT_FILE;
		String outputFileFullPath = Constants.OUTPUT_FILE;
		
		//Read arguments
		if (args.length > 0 && !args[0].isEmpty()) {
			inputFileFullPath = args[0];
			File inputFile = new File(inputFileFullPath);
			if (!inputFile.exists()) {
				inputFileFullPath = Constants.INPUT_FILE;
			}
		}
		
		if (args.length > 1 && !args[1].isEmpty())
			outputFileFullPath = args[1];
		
		try {
			//Map to keep intergalactic values to roman numbers or credits correspondences
			HashMap<String, String> translationNotes = new HashMap<String, String>();
			BufferedReader reader = new BufferedReader(new FileReader(inputFileFullPath));
			FileWriter writer = new FileWriter(outputFileFullPath, false);
		    String line;
		    FileProcessor fileProcessor = new FileProcessor();
		    while ((line = reader.readLine()) != null)
		    {
		    	fileProcessor.processLine(line, translationNotes, writer);
		    }
		    System.out.println("File successfully created at: " + outputFileFullPath);
			reader.close();
			writer.close();
		} catch (IOException e) {
			System.out.println("IOException occurred: "+ e.getMessage());
		}
	}


}
