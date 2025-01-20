import java.util.HashMap;

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length, n = mat[0].length;

        // Map to store the position of each number in the matrix
        HashMap<Integer, int[]> positionMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                positionMap.put(mat[i][j], new int[] { i, j });
            }
        }

        // Arrays to keep track of painted cells in each row and column
        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        // Iterate through the elements in arr
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int[] pos = positionMap.get(num);
            int row = pos[0], col = pos[1];

            // Increment the painted cell count for the row and column
            rowCount[row]++;
            colCount[col]++;

            // Check if the row or column is fully painted
            if (rowCount[row] == n || colCount[col] == m) {
                return i;
            }
        }

        // Return -1 if no row or column is fully painted (should not happen given
        // constraints)
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] arr1 = { 1, 3, 4, 2 };
        int[][] mat1 = { { 1, 4 }, { 2, 3 } };
        System.out.println("Output: " + solution.firstCompleteIndex(arr1, mat1)); // Expected: 2

        // Example 2
        int[] arr2 = { 2, 8, 7, 4, 1, 3, 5, 6, 9 };
        int[][] mat2 = { { 3, 2, 5 }, { 1, 4, 6 }, { 8, 7, 9 } };
        System.out.println("Output: " + solution.firstCompleteIndex(arr2, mat2)); // Expected: 3
    }
}
