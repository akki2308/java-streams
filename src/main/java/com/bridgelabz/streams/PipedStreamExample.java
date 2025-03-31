package com.bridgelabz.streams;

import java.io.*;

class WriterThread extends Thread {
    private PipedOutputStream pos;

    public WriterThread(PipedOutputStream pos) {
        this.pos = pos;
    }

    @Override
    public void run() {
        try {
            String message = "Hello from Writer Thread!";
            pos.write(message.getBytes()); // Write data to the stream
            pos.close(); // Close stream after writing
        } catch (IOException e) {
            System.out.println("WriterThread Error: " + e.getMessage());
        }
    }
}

class ReaderThread extends Thread {
    private PipedInputStream pis;

    public ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }

    @Override
    public void run() {
        try {
            int data;
            System.out.print("Reader Thread Received: ");
            while ((data = pis.read()) != -1) {
                System.out.print((char) data);
            }
            pis.close(); // Close stream after reading
        } catch (IOException e) {
            System.out.println("ReaderThread Error: " + e.getMessage());
        }
    }
}

public class PipedStreamExample {
    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos); // Connect both streams

            WriterThread writer = new WriterThread(pos);
            ReaderThread reader = new ReaderThread(pis);

            writer.start();
            reader.start();

        } catch (IOException e) {
            System.out.println("Error in main: " + e.getMessage());
        }
    }
}
