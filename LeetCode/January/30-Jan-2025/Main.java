import java.util.*;

class UnionFind {
    private int[] parent, rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int u) {
        if (parent[u] != u) 
            parent[u] = find(parent[u]);  // Path compression
        return parent[u];
    }

    public void unionByRank(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if (rootU == rootV) return;

        if (rank[rootU] < rank[rootV]) {
            parent[rootU] = rootV;
        } else if (rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;
        } else {
            parent[rootU] = rootV;
            rank[rootV]++;
        }
    }
}

class Solution {
    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        UnionFind uf = new UnionFind(n);
        Map<Integer, Integer> rootToGroupSize = new HashMap<>();

        for (int i = 0; i < n; i++) 
            graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0] - 1, v = edge[1] - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
            uf.unionByRank(u, v);
        }

        for (int i = 0; i < n; i++) {
            int newGroupSize = bfs(graph, i);
            if (newGroupSize == -1) return -1;
            int root = uf.find(i);
            rootToGroupSize.put(root, Math.max(rootToGroupSize.getOrDefault(root, 0), newGroupSize));
        }

        int ans = 0;
        for (int size : rootToGroupSize.values()) 
            ans += size;

        return ans;
    }

    private int bfs(List<List<Integer>> graph, int u) {
        int step = 0;
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> nodeToStep = new HashMap<>();
        queue.offer(u);
        nodeToStep.put(u, 1);

        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                for (int neighbor : graph.get(node)) {
                    if (!nodeToStep.containsKey(neighbor)) {
                        queue.offer(neighbor);
                        nodeToStep.put(neighbor, step + 1);
                    } else if (nodeToStep.get(neighbor) == step) {
                        return -1; // Odd-length cycle detected
                    }
                }
            }
        }
        return step;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n1 = 6;
        int[][] edges1 = {{1,2},{1,4},{1,5},{2,6},{2,3},{4,6}};
        System.out.println("Output: " + solution.magnificentSets(n1, edges1));  // Expected: 4

        int n2 = 3;
        int[][] edges2 = {{1,2},{2,3},{3,1}};
        System.out.println("Output: " + solution.magnificentSets(n2, edges2));  // Expected: -1
    }
}
