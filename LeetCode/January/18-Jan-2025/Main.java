import java.util.*;

class Solution {
    private static final int[][] DIRECTIONS = {
            { 0, 1 }, // Right
            { 0, -1 }, // Left
            { 1, 0 }, // Down
            { -1, 0 } // Up
    };

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Priority Queue for 0-1 BFS
        Deque<int[]> deque = new ArrayDeque<>();
        int[][] cost = new int[m][n];
        for (int[] row : cost)
            Arrays.fill(row, Integer.MAX_VALUE);

        // Start from (0, 0)
        deque.offerFirst(new int[] { 0, 0 });
        cost[0][0] = 0;

        while (!deque.isEmpty()) {
            int[] curr = deque.pollFirst();
            int x = curr[0], y = curr[1];

            // Check all 4 possible directions
            for (int d = 0; d < 4; d++) {
                int nx = x + DIRECTIONS[d][0];
                int ny = y + DIRECTIONS[d][1];

                // Ensure the new position is within bounds
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    // Determine the cost: 0 if following the current arrow, 1 otherwise
                    int newCost = cost[x][y] + (grid[x][y] == d + 1 ? 0 : 1);

                    if (newCost < cost[nx][ny]) {
                        cost[nx][ny] = newCost;
                        // Add to the deque based on cost
                        if (grid[x][y] == d + 1) {
                            deque.offerFirst(new int[] { nx, ny });
                        } else {
                            deque.offerLast(new int[] { nx, ny });
                        }
                    }
                }
            }
        }

        return cost[m - 1][n - 1];
    }
}

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] grid1 = {
                { 1, 1, 1, 1 },
                { 2, 2, 2, 2 },
                { 1, 1, 1, 1 },
                { 2, 2, 2, 2 }
        };
        System.out.println("Output: " + solution.minCost(grid1)); // Expected: 3

        int[][] grid2 = {
                { 1, 1, 3 },
                { 3, 2, 2 },
                { 1, 1, 4 }
        };
        System.out.println("Output: " + solution.minCost(grid2)); // Expected: 0

        int[][] grid3 = {
                { 1, 2 },
                { 4, 3 }
        };
        System.out.println("Output: " + solution.minCost(grid3)); // Expected: 1
    }
}
