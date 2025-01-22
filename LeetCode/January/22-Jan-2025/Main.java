import java.util.*;
import java.util.AbstractMap.SimpleEntry;

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        final int m = isWater.length;
        final int n = isWater[0].length;
        int[][] ans = new int[m][n];
        Arrays.stream(ans).forEach(A -> Arrays.fill(A, -1));
        Queue<SimpleEntry<Integer, Integer>> q = new ArrayDeque<>();

        // Add all water cells to the queue and mark them with height 0
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (isWater[i][j] == 1) {
                    q.offer(new SimpleEntry<>(i, j));
                    ans[i][j] = 0;
                }

        // Perform BFS to calculate the highest peak heights
        while (!q.isEmpty()) {
            final int i = q.peek().getKey();
            final int j = q.poll().getValue();
            for (int[] dir : dirs) {
                final int x = i + dir[0];
                final int y = j + dir[1];
                if (x < 0 || x == m || y < 0 || y == n)
                    continue;
                if (ans[x][y] != -1)
                    continue;
                ans[x][y] = ans[i][j] + 1;
                q.offer(new SimpleEntry<>(x, y));
            }
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[][] isWater1 = {
            {0, 1},
            {0, 0}
        };
        System.out.println("Example 1:");
        printMatrix(solution.highestPeak(isWater1));

        // Example 2
        int[][] isWater2 = {
            {0, 0, 1},
            {1, 0, 0},
            {0, 0, 0}
        };
        System.out.println("Example 2:");
        printMatrix(solution.highestPeak(isWater2));

        // Example 3
        int[][] isWater3 = {
            {1, 0, 0, 0},
            {0, 0, 0, 1}
        };
        System.out.println("Example 3:");
        printMatrix(solution.highestPeak(isWater3));
    }

    // Helper method to print a 2D matrix
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
