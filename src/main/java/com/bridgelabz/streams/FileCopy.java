package com.bridgelabz.streams;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        // Source and destination file paths
        String sourceFile = "source.txt";   // Change this to your source file path
        String destinationFile = "destination.txt"; // Change this to your destination file path

        try (
                FileInputStream fis = new FileInputStream(sourceFile);
                FileOutputStream fos = new FileOutputStream(destinationFile)
        ) {
            int data;
            while ((data = fis.read()) != -1) { // Read data byte by byte
                fos.write(data); // Write data to destination file
            }
            System.out.println("File copied successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("Error: Source file not found.");
        } catch (IOException e) {
            System.out.println("Error: An IO exception occurred.");
        }
    }
}
