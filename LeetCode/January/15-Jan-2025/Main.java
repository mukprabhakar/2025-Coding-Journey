import java.util.*;

class Solution {
    public int minimizeXor(int num1, int num2) {
        int targetBits = Integer.bitCount(num2); // Count set bits in num2
        int result = 0;

        // Step 1: Set bits in result where num1 has bits
        for (int i = 31; i >= 0 && targetBits > 0; i--) {
            if ((num1 & (1 << i)) != 0) { // Check if the i-th bit of num1 is set
                result |= (1 << i); // Set the i-th bit in result
                targetBits--;
            }
        }

        // Step 2: If targetBits is not satisfied, set remaining bits from LSB
        for (int i = 0; i <= 31 && targetBits > 0; i++) {
            if ((result & (1 << i)) == 0) { // If the i-th bit of result is not set
                result |= (1 << i); // Set the i-th bit in result
                targetBits--;
            }
        }

        return result;
    }
}

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int num1 = 3, num2 = 5;
        System.out.println("Input: num1 = " + num1 + ", num2 = " + num2);
        System.out.println("Output: " + solution.minimizeXor(num1, num2)); // Expected: 3

        // Test case 2
        num1 = 1;
        num2 = 12;
        System.out.println("Input: num1 = " + num1 + ", num2 = " + num2);
        System.out.println("Output: " + solution.minimizeXor(num1, num2)); // Expected: 3

        // Test case 3
        num1 = 28;
        num2 = 2;
        System.out.println("Input: num1 = " + num1 + ", num2 = " + num2);
        System.out.println("Output: " + solution.minimizeXor(num1, num2)); // Example case
    }
}
