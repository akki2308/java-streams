package com.bridgelabz.streams;

import java.io.*;

public class BufferedFileCopy {
    private static final int BUFFER_SIZE = 4096; // 4 KB

    // Copy file using Buffered Streams
    public static void copyWithBufferedStreams(File source, File destination) throws IOException {
        long startTime = System.nanoTime(); // Start time
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        }
        long endTime = System.nanoTime(); // End time
        System.out.println("Buffered Streams Copy Time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    // Copy file using Unbuffered Streams
    public static void copyWithUnbufferedStreams(File source, File destination) throws IOException {
        long startTime = System.nanoTime(); // Start time
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
        }
        long endTime = System.nanoTime(); // End time
        System.out.println("Unbuffered Streams Copy Time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    public static void main(String[] args) {
        File sourceFile = new File("source_large_file.txt");  // Replace with actual source file
        File destinationBuffered = new File("copied_buffered.txt");
        File destinationUnbuffered = new File("copied_unbuffered.txt");

        try {
            // Copy using Buffered Streams
            copyWithBufferedStreams(sourceFile, destinationBuffered);

            // Copy using Unbuffered Streams
            copyWithUnbufferedStreams(sourceFile, destinationUnbuffered);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
