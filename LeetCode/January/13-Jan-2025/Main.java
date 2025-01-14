class Solution {
    public int minimumLength(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right && s.charAt(left) == s.charAt(right)) {
            char boundaryChar = s.charAt(left);

            // Move left pointer inward while characters match boundaryChar
            while (left <= right && s.charAt(left) == boundaryChar) {
                left++;
            }

            // Move right pointer inward while characters match boundaryChar
            while (left <= right && s.charAt(right) == boundaryChar) {
                right--;
            }
        }

        // Remaining string length is right - left + 1
        return right - left + 1;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String s1 = "abaacbcbb";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + solution.minimumLength(s1)); // Expected: 5

        // Test case 2
        String s2 = "aa";
        System.out.println("Input: " + s2);
        System.out.println("Output: " + solution.minimumLength(s2)); // Expected: 2

        // Test case 3
        String s3 = "abc";
        System.out.println("Input: " + s3);
        System.out.println("Output: " + solution.minimumLength(s3)); // Expected: 3

        // Test case 4
        String s4 = "aabbcc";
        System.out.println("Input: " + s4);
        System.out.println("Output: " + solution.minimumLength(s4)); // Expected: 6
    }
}
