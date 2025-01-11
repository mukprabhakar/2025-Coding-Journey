import java.util.*;

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxFreq = new int[26];

        // Calculate maximum frequency of each character across all words in words2
        for (String word : words2) {
            int[] freq = countFrequency(word);
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
            }
        }

        // Check each word in words1 against the maxFreq
        List<String> result = new ArrayList<>();
        for (String word : words1) {
            int[] freq = countFrequency(word);
            if (isUniversal(freq, maxFreq)) {
                result.add(word);
            }
        }

        return result;
    }

    // Helper function to count character frequency
    private int[] countFrequency(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }

    // Helper function to check if a word satisfies the universal condition
    private boolean isUniversal(int[] wordFreq, int[] maxFreq) {
        for (int i = 0; i < 26; i++) {
            if (wordFreq[i] < maxFreq[i]) {
                return false;
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        String[] words1_1 = { "amazon", "apple", "facebook", "google", "leetcode" };
        String[] words2_1 = { "e", "o" };
        System.out.println(solution.wordSubsets(words1_1, words2_1)); // Output: ["facebook", "google", "leetcode"]

        // Example 2
        String[] words1_2 = { "amazon", "apple", "facebook", "google", "leetcode" };
        String[] words2_2 = { "l", "e" };
        System.out.println(solution.wordSubsets(words1_2, words2_2)); // Output: ["apple", "google", "leetcode"]
    }
}
