class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;

        // Step 1: Calculate the total sum of the array
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Step 2: Initialize variables to calculate prefix sum and count valid splits
        long prefixSum = 0;
        int validSplitsCount = 0;

        // Step 3: Iterate through the array to check valid splits
        for (int i = 0; i < n - 1; i++) {
            prefixSum += nums[i]; // Update the prefix sum
            long suffixSum = totalSum - prefixSum; // Calculate the suffix sum dynamically

            // Check if the current split is valid
            if (prefixSum >= suffixSum) {
                validSplitsCount++;
            }
        }

        return validSplitsCount;
    }
}

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] nums1 = { 10, 4, -8, 7 };
        System.out.println("Valid Splits (Test Case 1): " + solution.waysToSplitArray(nums1)); // Output: 2

        // Test case 2
        int[] nums2 = { 2, 3, 1, 0 };
        System.out.println("Valid Splits (Test Case 2): " + solution.waysToSplitArray(nums2)); // Output: 2

        // Test case 3
        int[] nums3 = { 1, 2, 3, 4, 5 };
        System.out.println("Valid Splits (Test Case 3): " + solution.waysToSplitArray(nums3)); // Output: 0

        // Test case 4
        int[] nums4 = { 1, 1, 1, 1, 1 };
        System.out.println("Valid Splits (Test Case 4): " + solution.waysToSplitArray(nums4)); // Output: 4
    }
}
