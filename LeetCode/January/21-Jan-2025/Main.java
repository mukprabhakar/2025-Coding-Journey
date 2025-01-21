import java.util.Arrays;

class Solution {
    public long gridGame(int[][] grid) {
        final int n = grid[0].length;
        long ans = Long.MAX_VALUE;
        long sumRow0 = Arrays.stream(grid[0]).asLongStream().sum();
        long sumRow1 = 0;

        for (int i = 0; i < n; ++i) {
            sumRow0 -= grid[0][i];
            ans = Math.min(ans, Math.max(sumRow0, sumRow1));
            sumRow1 += grid[1][i];
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[][] grid1 = {
                { 2, 5, 4 },
                { 1, 5, 1 }
        };
        System.out.println("Output for Test Case 1: " + solution.gridGame(grid1)); // Expected: 4

        // Test Case 2
        int[][] grid2 = {
                { 3, 3, 1 },
                { 8, 5, 2 }
        };
        System.out.println("Output for Test Case 2: " + solution.gridGame(grid2)); // Expected: 4

        // Test Case 3
        int[][] grid3 = {
                { 1, 3, 1, 15 },
                { 1, 3, 3, 1 }
        };
        System.out.println("Output for Test Case 3: " + solution.gridGame(grid3)); // Expected: 7

        // Test Case 4
        int[][] grid4 = {
                { 1, 2, 3, 4, 5 },
                { 5, 4, 3, 2, 1 }
        };
        System.out.println("Output for Test Case 4: " + solution.gridGame(grid4)); // Expected: 9

        // Add more test cases as needed
    }
}
