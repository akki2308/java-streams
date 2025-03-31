package com.bridgelabz.streams;

import java.io.*;
        import java.util.*;

public class WordCount {
    public static void main(String[] args) {
        String filePath = "sample.txt"; // Replace with your actual file path
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Read file and count word occurrences
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+"); // Normalize text
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Sort words by frequency (descending order)
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCountMap.entrySet());
        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Display the top 5 most frequent words
        System.out.println("Top 5 Most Frequent Words:");
        int count = 0;
        for (Map.Entry<String, Integer> entry : sortedList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
            count++;
            if (count == 5) break; // Stop after top 5
        }
    }
}
