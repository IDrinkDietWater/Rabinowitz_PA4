package com.company;

import java.io.File;

public class Application {

    private static final String CURRENT_DIRECTORY = "user.dir";
    private static final String SOURCE_FILE_1 = "problem1.txt";
    private static final String DESTINATION_FILE_1 = "unique_words.txt";
    private static final String SOURCE_FILE_2 = "problem2.txt";
    private static final String DESTINATION_FILE_2 = "unique_word_counts.txt";

    public static void main(String[] args) {
        // Problem One
        DuplicateRemover duplicateRemover = new DuplicateRemover();

        String inputFilePath1 = System.getProperty(CURRENT_DIRECTORY) + File.separator + SOURCE_FILE_1;
        String outputFilePath1 = System.getProperty(CURRENT_DIRECTORY) + File.separator + DESTINATION_FILE_1;

        duplicateRemover.remove(inputFilePath1);
        duplicateRemover.write(outputFilePath1);
    }
}