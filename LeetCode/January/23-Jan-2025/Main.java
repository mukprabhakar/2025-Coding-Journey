class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] rowCount = new int[m]; // Count of servers in each row
        int[] colCount = new int[n]; // Count of servers in each column
        int totalServers = 0;

        // First pass: Count servers in each row and column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                    totalServers++;
                }
            }
        }

        // Second pass: Count isolated servers and subtract them
        int isolatedServers = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && rowCount[i] == 1 && colCount[j] == 1) {
                    isolatedServers++;
                }
            }
        }

        return totalServers - isolatedServers;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] grid1 = {{1, 0}, {0, 1}};
        System.out.println(solution.countServers(grid1)); // Output: 0

        int[][] grid2 = {{1, 0}, {1, 1}};
        System.out.println(solution.countServers(grid2)); // Output: 3

        int[][] grid3 = {
            {1, 1, 0, 0},
            {0, 0, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 1}
        };
        System.out.println(solution.countServers(grid3)); // Output: 4
    }
}
