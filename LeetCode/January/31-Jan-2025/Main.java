import java.util.*;

class Solution {
    private static final int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        Map<Integer, Integer> islandSize = new HashMap<>();
        int islandId = 2; // Start from 2 to differentiate from 1 and 0
        int maxIsland = 0;

        // Step 1: Use DFS to label each island and store its size
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, islandId);
                    islandSize.put(islandId, size);
                    maxIsland = Math.max(maxIsland, size);
                    islandId++;
                }
            }
        }

        // Step 2: Try flipping each '0' and find the largest possible island
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> uniqueIslands = new HashSet<>();
                    for (int[] dir : directions) {
                        int ni = i + dir[0];
                        int nj = j + dir[1];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] > 1) {
                            uniqueIslands.add(grid[ni][nj]);
                        }
                    }
                    
                    int newSize = 1; // The flipped '0' itself
                    for (int id : uniqueIslands) {
                        newSize += islandSize.get(id);
                    }
                    maxIsland = Math.max(maxIsland, newSize);
                }
            }
        }

        return maxIsland == 0 ? n * n : maxIsland; // If no 0 was flipped, return full grid size
    }

    private int dfs(int[][] grid, int i, int j, int islandId) {
        int n = grid.length;
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = islandId; // Mark this cell as part of the current island
        int size = 1; // Current cell

        // Explore in all 4 directions
        for (int[] dir : directions) {
            size += dfs(grid, i + dir[0], j + dir[1], islandId);
        }
        return size;
    }
}
public class Main{
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] grid1 = {{1, 0}, {0, 1}};
        System.out.println("Output: " + sol.largestIsland(grid1)); // Expected: 3

        int[][] grid2 = {{1, 1}, {1, 0}};
        System.out.println("Output: " + sol.largestIsland(grid2)); // Expected: 4

        int[][] grid3 = {{1, 1}, {1, 1}};
        System.out.println("Output: " + sol.largestIsland(grid3)); // Expected: 4
    }
}
