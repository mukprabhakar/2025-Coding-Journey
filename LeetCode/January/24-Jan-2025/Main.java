import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] state = new int[n]; // 0 = unvisited, 1 = visiting, 2 = safe
        List<Integer> safeNodes = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            if (dfs(graph, i, state)) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }

    private boolean dfs(int[][] graph, int node, int[] state) {
        if (state[node] != 0) {
            return state[node] == 2; // Return true if it's already marked as safe
        }

        state[node] = 1; // Mark as visiting
        for (int neighbor : graph[node]) {
            if (state[neighbor] == 1 || !dfs(graph, neighbor, state)) {
                return false; // Cycle detected or not safe
            }
        }

        state[node] = 2; // Mark as safe
        return true;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[][] graph1 = {
            {1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}
        };
        System.out.println("Safe nodes for graph1: " + solution.eventualSafeNodes(graph1)); // Output: [2, 4, 5, 6]

        // Example 2
        int[][] graph2 = {
            {1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}
        };
        System.out.println("Safe nodes for graph2: " + solution.eventualSafeNodes(graph2)); // Output: [4]

        // Custom Example
        int[][] graph3 = {
            {1, 2}, {2}, {3}, {}, {0, 1}, {}
        };
        System.out.println("Safe nodes for graph3: " + solution.eventualSafeNodes(graph3)); // Output: [3, 5]
    }
}
