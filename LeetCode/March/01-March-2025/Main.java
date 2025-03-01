import java.util.*;

class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;

        // Step 1: Apply the given operation
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1] && nums[i] != 0) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        // Step 2: Move all non-zero elements to the front
        int[] result = new int[n];
        int index = 0;

        for (int num : nums) {
            if (num != 0) {
                result[index++] = num;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 2, 2, 1, 1, 0};
        System.out.println(Arrays.toString(solution.applyOperations(nums1))); // Output: [1, 4, 2, 0, 0, 0]

        int[] nums2 = {0, 1};
        System.out.println(Arrays.toString(solution.applyOperations(nums2))); // Output: [1, 0]

        int[] nums3 = {2, 2, 0, 4, 4, 8};
        System.out.println(Arrays.toString(solution.applyOperations(nums3))); // Output: [4, 8, 8, 0, 0, 0]
    }
}
