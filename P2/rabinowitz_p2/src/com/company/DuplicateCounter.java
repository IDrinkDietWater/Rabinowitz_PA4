package com.company;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCounter {
    Map<String, Integer> wordCounter;

    public DuplicateCounter() {
        this.wordCounter = new HashMap<String, Integer>();
    }

    public void count(String dataFile) {
        if (dataFile.isBlank()) {
            return;
        }

        try {
            File inputFile = new File(dataFile);
            InputStream inputFileStream = new FileInputStream(inputFile);
            Scanner inputFileScanner = new Scanner(inputFileStream);

            while (inputFileScanner.hasNextLine()) {
                String currentLine = inputFileScanner.nextLine();
                // Regular expression to split on all special characters
                String[] words = currentLine.split("[\\s@&.,?$!+-]+");

                for (String word: words) {
                    String trimmedWord = word.trim();
                    if(wordCounter.containsKey(trimmedWord)){
                        Integer value = wordCounter.get(trimmedWord);
                        value += 1;
                        wordCounter.replace(trimmedWord, value);
                    }
                    else {
                        wordCounter.put(trimmedWord, 1);
                    }
                }
            }

            inputFileStream.close();
            inputFileScanner.close();
        } catch (Exception ex) {

        }

    }

    public void write(String outputFile) {
        if (outputFile.isBlank()) {
            return;
        }

        try {
            File outputDataFile = new File(outputFile);
            OutputStream outputStream = new FileOutputStream(outputDataFile, false);
            outputStream.write(("").getBytes());

            for (Object word: this.wordCounter.keySet()) {
                outputStream.write(((String) word).getBytes());
                outputStream.write(("\t\t\t").getBytes());
                Integer numberOfAppearances = wordCounter.getOrDefault(word, 0);
                outputStream.write(String.valueOf(numberOfAppearances).getBytes());
                outputStream.write((System.lineSeparator()).getBytes());
            }
            outputStream.close();
        } catch (Exception ex) {

        }

    }
}
