# Intergalactic Translations

**Pending to refactor code.**

## Problem to solve:

You decided to give up on earth after the latest financial collapse left 99.99% of the earth's population with 0.01% of the wealth. Luckily, with the scant sum of money that is left in your account, you are able to afford to rent a spaceship, leave earth, and fly all over the galaxy to sell common metals and dirt (which apparently is worth a lot).
Buying and selling over the galaxy requires you to convert numbers and units, and you decided to write a program to help you.
The numbers used for intergalactic transactions follows similar convention to the roman numerals and you have painstakingly collected the appropriate translation between them. (Refer to: Wikipedia http://en.wikipedia.org/wiki/Roman_numerals)

Input to your program consists of lines of text detailing your notes on the conversion between intergalactic units and roman numerals. You are expected to handle invalid queries appropriately.

Test input:
```
  glob is I
  prok is V
  pish is X
  tegj is L
  glob glob Silver is 34 Credits
  glob prok Gold is 57800 Credits
  pish pish Iron is 3910 Credits
  how much is pish tegj glob glob ?
  how many Credits is glob prok Silver ?
  how many Credits is glob prok Gold ?
  how many Credits is glob prok Iron ?
  how much wood could a woodchuck chuck if a woodchuck could chuck wood ?
```
Test Output:
```
  pish tegj glob glob is 42
  glob prok Silver is 68 Credits
  glob prok Gold is 57800 Credits
  glob prok Iron is 782 Credits
  I have no idea what you are talking about
```

## Design:
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
