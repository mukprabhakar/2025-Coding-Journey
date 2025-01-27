import java.util.*;

class Solution {
  public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
    // Create a transitive closure matrix
    boolean[][] isPrerequisite = new boolean[numCourses][numCourses];

    // Populate the direct prerequisites
    for (int[] prerequisite : prerequisites) {
      int courseA = prerequisite[0];
      int courseB = prerequisite[1];
      isPrerequisite[courseA][courseB] = true;
    }

    // Apply Floyd-Warshall to compute the transitive closure
    for (int k = 0; k < numCourses; k++) {
      for (int i = 0; i < numCourses; i++) {
        for (int j = 0; j < numCourses; j++) {
          if (isPrerequisite[i][k] && isPrerequisite[k][j]) {
            isPrerequisite[i][j] = true;
          }
        }
      }
    }

    // Answer the queries
    List<Boolean> result = new ArrayList<>();
    for (int[] query : queries) {
      int courseU = query[0];
      int courseV = query[1];
      result.add(isPrerequisite[courseU][courseV]);
    }

    return result;
  }
}
public class Main {
    public static void main(String[] args) {
      Solution solution = new Solution();
  
      int numCourses1 = 2;
      int[][] prerequisites1 = {{1, 0}};
      int[][] queries1 = {{0, 1}, {1, 0}};
      System.out.println(solution.checkIfPrerequisite(numCourses1, prerequisites1, queries1)); // [false, true]
  
      int numCourses2 = 3;
      int[][] prerequisites2 = {{1, 2}, {1, 0}, {2, 0}};
      int[][] queries2 = {{1, 0}, {1, 2}};
      System.out.println(solution.checkIfPrerequisite(numCourses2, prerequisites2, queries2)); // [true, true]
    }
  }
  