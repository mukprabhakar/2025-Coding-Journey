class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] shiftArray = new int[n + 1]; // Using n+1 for easier range computation

        // Apply the difference array technique for shifts
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];

            // Increment or decrement based on the direction
            shiftArray[start] += (direction == 1) ? 1 : -1;
            shiftArray[end + 1] += (direction == 1) ? -1 : 1;
        }

        // Compute the prefix sum for the shift array
        int cumulativeShift = 0;
        char[] result = s.toCharArray();

        for (int i = 0; i < n; i++) {
            cumulativeShift += shiftArray[i]; // Update cumulative shift
            int shift = cumulativeShift % 26; // Normalize shift to the range [0, 25]
            if (shift < 0)
                shift += 26; // Handle negative shifts

            // Apply the shift to the character
            result[i] = (char) ((result[i] - 'a' + shift) % 26 + 'a');
        }

        return new String(result);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String s1 = "abc";
        int[][] shifts1 = { { 0, 1, 0 }, { 1, 2, 1 }, { 0, 2, 1 } };
        System.out.println(solution.shiftingLetters(s1, shifts1)); // Output: "ace"

        // Test case 2
        String s2 = "dztz";
        int[][] shifts2 = { { 0, 0, 0 }, { 1, 1, 1 } };
        System.out.println(solution.shiftingLetters(s2, shifts2)); // Output: "catz"
    }
}
