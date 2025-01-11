class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;

        // Iterate through each word in the array
        for (String word : words) {
            // Check if the current word starts with the given prefix
            if (word.startsWith(pref)) {
                count++;
            }
        }

        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String[] words1 = { "pay", "attention", "practice", "attend" };
        String pref1 = "at";
        System.out.println(solution.prefixCount(words1, pref1)); // Output: 2

        // Test case 2
        String[] words2 = { "leetcode", "win", "loops", "success" };
        String pref2 = "code";
        System.out.println(solution.prefixCount(words2, pref2)); // Output: 0
    }
}

