class Solution {
    // Helper function to validate a specific assumption for original[0]
    private boolean isValid(int[] derived, int start) {
        int n = derived.length;
        int[] original = new int[n];
        original[0] = start;

        // Construct original array based on derived
        for (int i = 0; i < n - 1; i++) {
            original[i + 1] = derived[i] ^ original[i];
        }

        // Validate the cyclic property
        return (original[n - 1] ^ original[0]) == derived[n - 1];
    }

    public boolean doesValidArrayExist(int[] derived) {
        // Check for both possible values of original[0]: 0 and 1
        return isValid(derived, 0) || isValid(derived, 1);
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] derived1 = { 1, 1, 0 };
        System.out.println("Output: " + solution.doesValidArrayExist(derived1)); // Expected: true

        // Example 2
        int[] derived2 = { 1, 1 };
        System.out.println("Output: " + solution.doesValidArrayExist(derived2)); // Expected: true

        // Example 3
        int[] derived3 = { 1, 0 };
        System.out.println("Output: " + solution.doesValidArrayExist(derived3)); // Expected: false
    }
}
