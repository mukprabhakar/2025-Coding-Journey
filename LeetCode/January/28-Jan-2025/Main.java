class Solution {
    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int maxFish = 0;

        // Iterate over all cells in the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If the cell is a water cell and not visited, perform DFS
                if (grid[i][j] > 0 && !visited[i][j]) {
                    maxFish = Math.max(maxFish, dfs(grid, visited, i, j));
                }
            }
        }

        return maxFish;
    }

    private int dfs(int[][] grid, boolean[][] visited, int r, int c) {
        // Check bounds and if the cell is visited or a land cell
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || visited[r][c] || grid[r][c] == 0) {
            return 0;
        }

        // Mark the cell as visited
        visited[r][c] = true;

        // Start with the current cell's fish count
        int totalFish = grid[r][c];

        // Explore adjacent cells
        totalFish += dfs(grid, visited, r + 1, c); // Down
        totalFish += dfs(grid, visited, r - 1, c); // Up
        totalFish += dfs(grid, visited, r, c + 1); // Right
        totalFish += dfs(grid, visited, r, c - 1); // Left

        return totalFish;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] grid1 = {
            {0, 2, 1, 0},
            {4, 0, 0, 3},
            {1, 0, 0, 4},
            {0, 3, 2, 0}
        };
        System.out.println(solution.findMaxFish(grid1)); // Output: 7

        int[][] grid2 = {
            {1, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 1}
        };
        System.out.println(solution.findMaxFish(grid2)); // Output: 1
    }
}
