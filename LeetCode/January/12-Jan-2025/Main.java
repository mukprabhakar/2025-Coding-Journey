class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        // If the length is odd, it's impossible to form a valid parentheses string
        if (n % 2 != 0)
            return false;

        // Left to Right Pass
        int open = 0, flexible = 0;
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == '(')
                    open++;
                else
                    open--;
            } else {
                flexible++;
            }

            // If open becomes negative, adjust with flexible slots
            if (open + flexible < 0)
                return false;
        }

        // Right to Left Pass
        open = 0;
        flexible = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == ')')
                    open++;
                else
                    open--;
            } else {
                flexible++;
            }

            // If open becomes negative, adjust with flexible slots
            if (open + flexible < 0)
                return false;
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        String s1 = "))()))";
        String locked1 = "010100";
        System.out.println(solution.canBeValid(s1, locked1)); // Output: true

        // Example 2
        String s2 = "()()";
        String locked2 = "0000";
        System.out.println(solution.canBeValid(s2, locked2)); // Output: true

        // Example 3
        String s3 = ")";
        String locked3 = "0";
        System.out.println(solution.canBeValid(s3, locked3)); // Output: false
    }
}
