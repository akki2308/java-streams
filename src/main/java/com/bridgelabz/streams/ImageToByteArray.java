package com.bridgelabz.streams;

import java.io.*;

public class ImageToByteArray {
    // Convert image file to byte array
    public static byte[] convertImageToByteArray(String imagePath) {
        try (FileInputStream fis = new FileInputStream(imagePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096]; // 4KB buffer
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            System.out.println("Error reading image: " + e.getMessage());
            return null;
        }
    }

    // Write byte array back to an image file
    public static void convertByteArrayToImage(byte[] imageBytes, String outputPath) {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            byte[] buffer = new byte[4096]; // 4KB buffer
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("Image successfully written to: " + outputPath);
        } catch (IOException e) {
            System.out.println("Error writing image: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String inputImagePath = "input.jpg";  // Replace with actual image path
        String outputImagePath = "output.jpg"; // Output image file

        // Convert image to byte array
        byte[] imageBytes = convertImageToByteArray(inputImagePath);

        // Verify conversion success
        if (imageBytes != null) {
            System.out.println("Image converted to byte array successfully. Size: " + imageBytes.length + " bytes");

            // Convert byte array back to image
            convertByteArrayToImage(imageBytes, outputImagePath);
        }
    }
}
