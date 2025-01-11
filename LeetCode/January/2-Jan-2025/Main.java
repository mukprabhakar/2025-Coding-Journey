import java.util.*;

class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        // Helper method to check if a word starts and ends with a vowel
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int n = words.length;
        int[] prefixSum = new int[n + 1]; // Prefix sum for counting vowel words

        // Build prefix sum array
        for (int i = 0; i < n; i++) {
            String word = words[i];
            char start = word.charAt(0);
            char end = word.charAt(word.length() - 1);

            // Check if both start and end are vowels
            if (vowels.contains(start) && vowels.contains(end)) {
                prefixSum[i + 1] = prefixSum[i] + 1;
            } else {
                prefixSum[i + 1] = prefixSum[i];
            }
        }

        // Answer queries
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int li = queries[i][0];
            int ri = queries[i][1];

            // Use prefix sum to calculate the count in the range [li, ri]
            result[i] = prefixSum[ri + 1] - prefixSum[li];
        }

        return result;
    }
}
public class Main {
    public static void main(String[] args) {
        // Create an instance of the Solution class
        Solution solution = new Solution();

        // Test case 1
        String[] words1 = {"aba", "bcb", "ece", "aa", "e"};
        int[][] queries1 = {{0, 2}, {1, 4}, {1, 1}};
        int[] result1 = solution.vowelStrings(words1, queries1);

        // Print the results for test case 1
        System.out.println("Test Case 1 Results: " + Arrays.toString(result1)); // Expected: [2, 3, 0]

        // Test case 2
        String[] words2 = {"a", "e", "i"};
        int[][] queries2 = {{0, 2}, {0, 1}, {2, 2}};
        int[] result2 = solution.vowelStrings(words2, queries2);

        // Print the results for test case 2
        System.out.println("Test Case 2 Results: " + Arrays.toString(result2)); // Expected: [3, 2, 1]

        // Additional test case
        String[] words3 = {"apple", "banana", "orange", "umbrella", "owl"};
        int[][] queries3 = {{0, 4}, {1, 3}, {2, 2}};
        int[] result3 = solution.vowelStrings(words3, queries3);

        // Print the results for the additional test case
        System.out.println("Test Case 3 Results: " + Arrays.toString(result3)); // Expected: [3, 2, 1]
    }
}
