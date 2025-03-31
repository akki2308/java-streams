package com.bridgelabz.streams;

import java.io.*;

public class UserInfoToFile {
    public static void main(String[] args) {
        String fileName = "user_info.txt"; // File to store user details

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             FileWriter fw = new FileWriter(fileName, true)) { // Append mode enabled

            // Taking user input
            System.out.print("Enter your name: ");
            String name = br.readLine();

            System.out.print("Enter your age: ");
            String age = br.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = br.readLine();

            // Writing to file
            fw.write("Name: " + name + "\n");
            fw.write("Age: " + age + "\n");
            fw.write("Favorite Language: " + language + "\n");
            fw.write("--------------------------\n");

            System.out.println("User information saved successfully in " + fileName);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
