class Solution {
    public int maxScore(String s) {
        // Variable to store the total count of ones in the string
        int totalCountOfOnes = 0;

        // Loop to count the total number of ones in the string
        for (char character : s.toCharArray()) {
            if (character == '1') {
                totalCountOfOnes++; // Increment count for '1'
            }
        }

        // Variables to keep track of zeros and ones in left and right substrings
        int currentCountOfZeros = 0;
        int currentCountOfOnes = 0;
        int maximumScore = 0;

        // Traverse the string up to the second last character
        for (int i = 0; i < s.length() - 1; i++) {
            // Check if the current character is zero or one
            if (s.charAt(i) == '0') {
                currentCountOfZeros++; // Increment zero count for left substring
            } else {
                currentCountOfOnes++; // Increment one count for right substring
            }

            // Calculate current score as zeros in left + ones in right
            int currentScore = currentCountOfZeros + (totalCountOfOnes - currentCountOfOnes);

            // Update maximum score if the current score is greater
            maximumScore = Math.max(maximumScore, currentScore);
        }

        // Return the maximum score found
        return maximumScore;
    }

    public static void main(String[] args) {
        // Create an instance of the Solution class
        Solution solution = new Solution();

        // Test cases
        String test1 = "011101"; // Expected output: 5
        String test2 = "00111"; // Expected output: 5
        String test3 = "1111"; // Expected output: 3
        String test4 = "0000"; // Expected output: 3

        // Printing the results of maxScore for the test cases
        System.out.println("Test case 1: " + solution.maxScore(test1)); // Output: 5
        System.out.println("Test case 2: " + solution.maxScore(test2)); // Output: 5
        System.out.println("Test case 3: " + solution.maxScore(test3)); // Output: 3
        System.out.println("Test case 4: " + solution.maxScore(test4)); // Output: 3
    }
}
