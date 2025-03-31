package com.bridgelabz.streams;

import java.io.*;

public class StudentDataStream {
    // File path for storing student data
    private static final String FILE_PATH = "student_data.dat";

    // Method to write student data to a binary file
    public static void writeStudentData(int rollNumber, String name, double gpa) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_PATH))) {
            dos.writeInt(rollNumber);
            dos.writeUTF(name);
            dos.writeDouble(gpa);
            System.out.println("Student data successfully written to file.");
        } catch (IOException e) {
            System.out.println("Error writing student data: " + e.getMessage());
        }
    }

    // Method to read student data from the binary file
    public static void readStudentData() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_PATH))) {
            int rollNumber = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();

            System.out.println("\nRetrieved Student Data:");
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("GPA: " + gpa);
        } catch (IOException e) {
            System.out.println("Error reading student data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Sample student data
        int rollNumber = 101;
        String name = "John Doe";
        double gpa = 3.75;

        // Write student data to file
        writeStudentData(rollNumber, name, gpa);

        // Read student data from file
        readStudentData();
    }
}
