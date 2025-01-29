import java.util.*;
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n + 1); // Using 1-based indexing

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // If u and v are already connected, this edge forms a cycle
            if (!uf.union(u, v)) {
                return edge;
            }
        }

        return new int[0]; // This won't be reached in a valid input
    }
}

// Union-Find (Disjoint Set) class
class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];

        // Initialize each node to be its own parent
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1; // Initialize ranks to 1
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }

    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return false; // Cycle detected
        }

        // Union by rank
        if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[][] edges1 = { { 1, 2 }, { 1, 3 }, { 2, 3 } };
        System.out.println("Output: " + Arrays.toString(solution.findRedundantConnection(edges1))); // Expected: [2,3]

        // Example 2
        int[][] edges2 = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 4 }, { 1, 5 } };
        System.out.println("Output: " + Arrays.toString(solution.findRedundantConnection(edges2))); // Expected: [1,4]
    }
}