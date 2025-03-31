package com.bridgelabz.streams;

import java.io.*;

public class UpperToLowerCaseConverter {
    public static void convertFileToLowerCase(String inputFile, String outputFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase()); // Convert to lowercase
                writer.newLine(); // Preserve line breaks
            }
            System.out.println("File successfully converted and written to: " + outputFile);

        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String inputFilePath = "input.txt";  // Replace with actual file path
        String outputFilePath = "output.txt"; // Output file path

        convertFileToLowerCase(inputFilePath, outputFilePath);
    }
}
