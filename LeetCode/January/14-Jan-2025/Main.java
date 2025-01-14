import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] C = new int[n];
        Set<Integer> seenA = new HashSet<>();
        Set<Integer> seenB = new HashSet<>();
        int commonCount = 0;

        for (int i = 0; i < n; i++) {
            // Add current elements of A and B to their respective sets
            if (seenB.contains(A[i])) {
                commonCount++;
            }
            if (seenA.contains(B[i])) {
                commonCount++;
            }
            if (!seenA.contains(A[i])) {
                seenA.add(A[i]);
            }
            if (!seenB.contains(B[i])) {
                seenB.add(B[i]);
            }

            if (A[i] == B[i]) {
                commonCount++;
            }

            // Update prefix common count at index i
            C[i] = commonCount;
        }
        return C;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] A1 = {1, 3, 2, 4};
        int[] B1 = {3, 1, 2, 4};
        int[] result1 = solution.findThePrefixCommonArray(A1, B1);
        System.out.println("Test Case 1 Output:");
        for (int num : result1) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Test Case 2
        int[] A2 = {2, 3, 1};
        int[] B2 = {3, 1, 2};
        int[] result2 = solution.findThePrefixCommonArray(A2, B2);
        System.out.println("Test Case 2 Output:");
        for (int num : result2) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
