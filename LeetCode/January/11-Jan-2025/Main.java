import java.util.*;

class Solution {
    public boolean canConstruct(String s, int k) {
        // If k is greater than the length of the string, it's impossible
        if (k > s.length()) {
            return false;
        }

        // Count character frequencies
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        // Count odd frequencies
        int oddCount = 0;
        for (int count : charCount) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        // Check if we can form k palindromes
        return k >= oddCount;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        String s1 = "annabelle";
        int k1 = 2;
        System.out.println(solution.canConstruct(s1, k1)); // Output: true

        // Example 2
        String s2 = "leetcode";
        int k2 = 3;
        System.out.println(solution.canConstruct(s2, k2)); // Output: false

        // Example 3
        String s3 = "true";
        int k3 = 4;
        System.out.println(solution.canConstruct(s3, k3)); // Output: true
    }
}
