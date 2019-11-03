package com.company;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DuplicateRemover {

    private Set<String> uniqueWords;

    public DuplicateRemover() {
        this.uniqueWords = new HashSet<>();
    }

    public void remove(String dataFile) {
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
                    this.uniqueWords.add(trimmedWord);
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

            for (Object word: this.uniqueWords.toArray()) {
                outputStream.write(((String) word).getBytes());
                outputStream.write((System.lineSeparator()).getBytes());
            }
            outputStream.close();
        } catch (Exception ex) {

        }

    }
}
