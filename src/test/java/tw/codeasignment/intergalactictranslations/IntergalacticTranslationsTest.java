package tw.codeasignment.intergalactictranslations;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

import tw.codeasignment.intergalactictranslations.utils.Constants;

public class IntergalacticTranslationsTest {

	@Test
	public void testResultFileAndExpectedFileAreEquals() {
		String[] arguments = { Constants.INPUT_FILE, Constants.OUTPUT_FILE };
	    IntergalacticTranslations.main(arguments);	
	    
	    List<String> expectedFileLines = null;
		try {
			expectedFileLines = Files.readAllLines(Paths.get("files/expectedTestOutput.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	    List<String> resultFileLines = null;
	    
		try {
			resultFileLines = Files.readAllLines(Paths.get(Constants.OUTPUT_FILE));
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals(expectedFileLines, resultFileLines);
	}

}
