import java.util.PriorityQueue;

class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        if (m < 3 || n < 3) {
            // No space for trapping water
            return 0;
        }

        // Min-heap to store the boundary cells
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

        // Visited array to mark cells that are processed
        boolean[][] visited = new boolean[m][n];

        // Add all boundary cells to the heap
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    pq.offer(new int[] { i, j, heightMap[i][j] });
                    visited[i][j] = true;
                }
            }
        }

        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int waterTrapped = 0;

        // Process the cells in the priority queue
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int x = cell[0], y = cell[1], height = cell[2];

            // Explore neighbors
            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                // If the neighbor is within bounds and not visited
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;

                    // If the neighbor's height is lower, water can be trapped
                    waterTrapped += Math.max(0, height - heightMap[nx][ny]);

                    // Add the neighbor to the heap with the updated boundary height
                    pq.offer(new int[] { nx, ny, Math.max(height, heightMap[nx][ny]) });
                }
            }
        }

        return waterTrapped;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] heightMap1 = {
                { 1, 4, 3, 1, 3, 2 },
                { 3, 2, 1, 3, 2, 4 },
                { 2, 3, 3, 2, 3, 1 }
        };
        System.out.println("Output: " + solution.trapRainWater(heightMap1)); // Expected: 4

        int[][] heightMap2 = {
                { 3, 3, 3, 3, 3 },
                { 3, 2, 2, 2, 3 },
                { 3, 2, 1, 2, 3 },
                { 3, 2, 2, 2, 3 },
                { 3, 3, 3, 3, 3 }
        };
        System.out.println("Output: " + solution.trapRainWater(heightMap2)); // Expected: 10
    }
}
