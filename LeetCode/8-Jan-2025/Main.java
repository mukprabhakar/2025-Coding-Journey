class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;

        // Iterate through all pairs of words where i < j
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                // Check if words[i] is both a prefix and a suffix of words[j]
                if (isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }

        return count;
    }

    // Helper function to check if str1 is both a prefix and a suffix of str2
    private boolean isPrefixAndSuffix(String str1, String str2) {
        // Check if str1 is both a prefix and a suffix of str2
        return str2.startsWith(str1) && str2.endsWith(str1);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String[] words1 = { "a", "aba", "ababa", "aa" };
        System.out.println(solution.countPrefixSuffixPairs(words1)); // Output: 4

        // Test case 2
        String[] words2 = { "pa", "papa", "ma", "mama" };
        System.out.println(solution.countPrefixSuffixPairs(words2)); // Output: 2

        // Test case 3
        String[] words3 = { "abab", "ab" };
        System.out.println(solution.countPrefixSuffixPairs(words3)); // Output: 0
    }
}
