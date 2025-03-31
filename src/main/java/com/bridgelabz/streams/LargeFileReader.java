package com.bridgelabz.streams;

import java.io.*;

public class LargeFileReader {
    public static void main(String[] args) {
        String filePath = "large_log.txt"; // Replace with your large file path

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) { // Read line by line
                if (line.toLowerCase().contains("error")) { // Case-insensitive check
                    System.out.println(line); // Print lines containing "error"
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
