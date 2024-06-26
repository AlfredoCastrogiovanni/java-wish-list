package org.learning.charCounter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = null;
        
        LinkedHashMap<Character, Integer> results = new LinkedHashMap<>();

        while (true) {
            System.out.println("Enter a word:");
            word = scanner.nextLine().trim();
            
            if (!word.isEmpty()) {
                break;
            }
            System.out.println("Enter a valid word!");
        }

        for (char c : word.toCharArray()) {
            results.put(c, results.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : results.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }
}
