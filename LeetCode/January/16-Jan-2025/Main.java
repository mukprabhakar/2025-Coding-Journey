class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xor1 = 0, xor2 = 0;

        // Calculate XOR of all elements in nums1
        for (int num : nums1) {
            xor1 ^= num;
        }

        // Calculate XOR of all elements in nums2
        for (int num : nums2) {
            xor2 ^= num;
        }

        // Determine the result based on the parity of nums1.length and nums2.length
        int result = 0;
        if (nums2.length % 2 != 0) {
            result ^= xor1; // nums1 elements appear odd times in nums3
        }
        if (nums1.length % 2 != 0) {
            result ^= xor2; // nums2 elements appear odd times in nums3
        }

        return result;
    }
}

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] nums1 = { 2, 1, 3 };
        int[] nums2 = { 10, 2, 5, 0 };
        System.out.println("Output: " + solution.xorAllNums(nums1, nums2)); // Expected: 13

        // Example 2
        nums1 = new int[] { 1, 2 };
        nums2 = new int[] { 3, 4 };
        System.out.println("Output: " + solution.xorAllNums(nums1, nums2)); // Expected: 0
    }
}
