import java.util.HashSet;
import java.util.Set;

class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        Set<String> uniquePalindromes = new HashSet<>();

        // Iterate for each character from 'a' to 'z' as the possible outer character
        for (char c = 'a'; c <= 'z'; c++) {
            int left = -1;
            int right = -1;

            // Find the first and last occurrence of the character 'c'
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == c) {
                    if (left == -1) {
                        left = i;
                    }
                    right = i;
                }
            }

            // If the character appears at least twice
            if (left != -1 && right != -1 && left < right) {
                // Collect all unique characters between the first and last occurrence of 'c'
                Set<Character> middleCharacters = new HashSet<>();
                for (int i = left + 1; i < right; i++) {
                    middleCharacters.add(s.charAt(i));
                }

                // Add each valid palindrome to the set
                for (char middle : middleCharacters) {
                    uniquePalindromes.add("" + c + middle + c);
                }
            }
        }

        return uniquePalindromes.size();
    }
}

public class Main {
    // Main method to test the functionality
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        String s1 = "aabca";
        System.out.println("Test Case 1: " + solution.countPalindromicSubsequence(s1)); // Output: 3

        String s2 = "adc";
        System.out.println("Test Case 2: " + solution.countPalindromicSubsequence(s2)); // Output: 0

        String s3 = "bbcbaba";
        System.out.println("Test Case 3: " + solution.countPalindromicSubsequence(s3)); // Output: 4

        String s4 = "aaaa";
        System.out.println("Test Case 4: " + solution.countPalindromicSubsequence(s4)); // Output: 1

        String s5 = "abc";
        System.out.println("Test Case 5: " + solution.countPalindromicSubsequence(s5)); // Output: 0

        String s6 = "abba";
        System.out.println("Test Case 6: " + solution.countPalindromicSubsequence(s6)); // Output: 1
    }
}
