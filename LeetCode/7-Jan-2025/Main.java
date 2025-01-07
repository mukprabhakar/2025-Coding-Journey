import java.util.*;

class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();

        // Iterate through each word
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                // Check if words[i] is a substring of words[j]
                if (i != j && words[j].contains(words[i])) {
                    result.add(words[i]);
                    break; // Avoid duplicate entries
                }
            }
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String[] words1 = { "mass", "as", "hero", "superhero" };
        System.out.println(solution.stringMatching(words1)); // Output: ["as", "hero"]

        // Test case 2
        String[] words2 = { "leetcode", "et", "code" };
        System.out.println(solution.stringMatching(words2)); // Output: ["et", "code"]

        // Test case 3
        String[] words3 = { "blue", "green", "bu" };
        System.out.println(solution.stringMatching(words3)); // Output: []
    }
}
