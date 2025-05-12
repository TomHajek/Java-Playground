package dev.playground.training.interview;

import java.util.*;

public class Test {

    /**
     * Verify if given string is a palindrome.
     */
    private boolean isPalindrome(String str) {
        for (int i = 0; i < str.length(); i++) {
             if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                 return false;
             }
        }
        return true;
    }

    /**
     * You are given number to count from 0 to the number.
     * If the number can be divided by 3, print "Fizz".
     * If the number can be divided by 5, print "Buzz".
     * If the number can be divided by 3 and 5, print "Fizz Buzz".
     */
    private List<String> fizzBuzz(int count) {
        List<String> list = new ArrayList<>();

        for (int i = 1; i <= count; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("Fizz Buzz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else {
                list.add(String.valueOf(i));
            }
        }

        return list;
    }

    /**
     * You are given a list of integers, and you need to implement a function that returns
     * the second-largest number in the list.
     * Validate that list has at least two elements.
     * <ul>
     * <li>You may assume that the input list contains only integers.</li>
     * <li>You may not use any built-in sorting functions.</li>
     * <li>You should aim for an efficient algorithm that runs in O(n) time complexity.</li>
     * </ul>
     */
    private int secondLargest(List<Integer> integers) {
        if (integers.size() < 2) {
            throw new IllegalArgumentException("Invalid input");
        }

        int max = 0;
        int sec = 0;

        for (int i = 0; i < integers.size(); i++) {
            if (max <= integers.get(i)) {
                sec = max;
                max = integers.get(i);
            } else if (max > integers.get(i) && sec <= integers.get(i))  {
                sec = integers.get(i);
            }
        }

        return sec;
    }

    /**
     * There are N empty glasses with a capacity of 1,2,...,N liters (there is exactly one glass
     * of each unique capacity). You want to pour exactly K liters of water into glasses. Each
     * glass may be either full or empty (a glass cannot be partially filled). What is the minimum
     * number of glasses that you need to contain K liters of water?
     */
    private int glasses(int N, int K) {
        int count = 0;

        // Iterate from the largest capacity glass to the smallest
        for (int i = N; i > 0; i--) {
            if (i <= K) {
                K -= i;
                count++;
            }
            // If exactly K liters are achieved, return the count
            if (K == 0) return count;
        }

        // If we can't make exactly K liters, return -1
        return -1;
    }

    /**
     * Find the smallest integer in a given array.
     */
    private int smallest(int[] A) {
        HashSet<Integer> set = new HashSet<Integer>();

        // Add all positive numbers to the set
        for (int num : A) {
            if (num > 0) {
                set.add(num);
            }
        }

        // Find the smallest missing positive integer
        int smallestMissing = 1;
        while (set.contains(smallestMissing)) {
            smallestMissing++;
        }

        return smallestMissing;
    }

    /**
     * Remove duplicate characters from given string
     */
    public static String removeDuplicateChars(String s) {
        Set<Character> seen = new HashSet<>();
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (!seen.contains(c)) {
                seen.add(c);
                result.append(c);
            }
        }
        return result.toString();
    }

    /**
     * Given a string s, sort it in decreasing order based on the frequency of the characters.
     * The frequency of a character is the number of times it appears in the string. Return the
     * sorted string.
     */
    public String frequencySort(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();

        // Count character frequencies
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Max heap sorted by frequency
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));
        maxHeap.addAll(freqMap.keySet());

        // Build the result string
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char c = maxHeap.poll();
            result.append(String.valueOf(c).repeat(freqMap.get(c)));
        }

        return result.toString();
    }




}
