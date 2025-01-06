class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];

        // Left-to-right pass
        int balls = 0; // Number of balls encountered so far
        int operations = 0; // Total operations to move balls to the current box
        for (int i = 0; i < n; i++) {
            answer[i] += operations;
            balls += boxes.charAt(i) - '0';
            operations += balls; // Add the number of balls to move them to the next box
        }

        // Right-to-left pass
        balls = 0; // Reset the ball count
        operations = 0; // Reset operations
        for (int i = n - 1; i >= 0; i--) {
            answer[i] += operations;
            balls += boxes.charAt(i) - '0';
            operations += balls; // Add the number of balls to move them to the next box
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String boxes1 = "110";
        int[] result1 = solution.minOperations(boxes1);
        System.out.println(java.util.Arrays.toString(result1)); // Output: [1, 1, 3]

        // Test case 2
        String boxes2 = "001011";
        int[] result2 = solution.minOperations(boxes2);
        System.out.println(java.util.Arrays.toString(result2)); // Output: [11, 8, 5, 4, 3, 4]
    }
}
