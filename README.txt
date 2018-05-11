IntergalacticTranslationsJavaSM

Design:
- RomanArabicNumbersConverter: class to perform the basic Roman to Arabic and reverse conversion.
- Constants: class containing literals used to manage file processing (read/write/process)
- TranslationProcessor: maps equivalences from the file notes and/or performs a translation to
	send an answer to the FileProcessor. The translation can be direct if there is a direct
	equivalence (i.e.: prok is V) or calculated if there is a combined equilance
	(i.e.: glob glob Silver is 34 Credits)
- FileProcessor: splits each line using a decided separator (" is ") and checks chunk to
	send it to the TranslationProcessor and/or write and answer, if corresponding, to
	the output file (by default: testOutput.txt, inside the files folder) 
- IntergalacticTranslations: main program to run, where we read the input file, open it and read
		 it to check line by line with the FileProcessor.

Assumptions:
- We expect to provide a valid and existing path/name file, if not, we will be using the
	default testInput.txt file from the files folder.
- Taking into account the provided Test Input, we've taken some literals to treat the
	file and understand each note. For example: having "how much" in a line means direct
	translation; having "how many" means translation to be calculated; the line will be
	splitted into two parts to be processed separated by the connector "is".


To build the project we will be using Maven: https://maven.apache.org/
- Project build, inside the root of the project folder, where the pom.xml is: 
		mvn IntergalacticTranslationsJavaSM
		(or mvn clean install --> builds project and executes tests)


- Program execution:
	- Navigate to the source: src/main/java/tw/codeasignment/intergalactictranslations
	- Execute the following command:
			java IntergalacticTranslations <inputFileFullPathAndName> <outputFileNameFullPathAndName>
			