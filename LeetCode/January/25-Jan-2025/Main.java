import java.util.*;

class Solution {
  public int[] lexicographicallySmallestArray(int[] nums, int limit) {
    int[] ans = new int[nums.length];
    List<List<Pair>> numAndIndexesGroups = new ArrayList<>();

    // Create pairs of (value, index) and sort them
    Pair[] numAndIndexes = getNumAndIndexes(nums);

    for (Pair numAndIndex : numAndIndexes) {
      if (numAndIndexesGroups.isEmpty() ||
          numAndIndex.value -
                  numAndIndexesGroups.get(numAndIndexesGroups.size() - 1)
                      .get(numAndIndexesGroups.get(numAndIndexesGroups.size() - 1).size() - 1)
                      .value >
              limit) {
        // Start a new group
        numAndIndexesGroups.add(new ArrayList<>(List.of(numAndIndex)));
      } else {
        // Append to the existing group
        numAndIndexesGroups.get(numAndIndexesGroups.size() - 1).add(numAndIndex);
      }
    }

    // Sort each group by indices and place sorted values into result array
    for (List<Pair> numAndIndexesGroup : numAndIndexesGroups) {
      List<Integer> sortedNums = new ArrayList<>();
      List<Integer> sortedIndices = new ArrayList<>();
      for (Pair pair : numAndIndexesGroup) {
        sortedNums.add(pair.value);
        sortedIndices.add(pair.index);
      }
      sortedIndices.sort(null);
      Collections.sort(sortedNums);
      for (int i = 0; i < sortedNums.size(); ++i) {
        ans[sortedIndices.get(i)] = sortedNums.get(i);
      }
    }

    return ans;
  }

  private Pair[] getNumAndIndexes(int[] nums) {
    Pair[] numAndIndexes = new Pair[nums.length];
    for (int i = 0; i < nums.length; ++i) {
      numAndIndexes[i] = new Pair(nums[i], i);
    }
    Arrays.sort(numAndIndexes, Comparator.comparingInt(a -> a.value));
    return numAndIndexes;
  }

  // Helper Pair class to store value and index
  static class Pair {
    int value;
    int index;

    Pair(int value, int index) {
      this.value = value;
      this.index = index;
    }
  }
}
public class Main {
    public static void main(String[] args) {
      Solution solution = new Solution();
  
      int[] nums1 = {1, 5, 3, 9, 8};
      int limit1 = 2;
      System.out.println(Arrays.toString(solution.lexicographicallySmallestArray(nums1, limit1)));
      // Output: [1, 3, 5, 8, 9]
  
      int[] nums2 = {1, 7, 6, 18, 2, 1};
      int limit2 = 3;
      System.out.println(Arrays.toString(solution.lexicographicallySmallestArray(nums2, limit2)));
      // Output: [1, 6, 7, 18, 1, 2]
  
      int[] nums3 = {1, 7, 28, 19, 10};
      int limit3 = 3;
      System.out.println(Arrays.toString(solution.lexicographicallySmallestArray(nums3, limit3)));
      // Output: [1, 7, 28, 19, 10]
    }
  }
  