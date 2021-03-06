package leetcode.array;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 *
 * Time complexity O(n)
 * Space complexity O(m) m depends on digits length
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {

        if(digits == null || digits.length == 0) return digits;

        for(int i = digits.length - 1; i>= 0; i--) {
            if(i > 0) {
                if(digits[i] < 9) {
                    digits[i] += 1;
                    return digits;
                } else {
                    digits[i] = 0;
                }
            } else {
                if(digits[i] < 9) {
                    digits[i] += 1;
                    return digits;
                } else {
                    int[] result = new int[digits.length + 1];
                    result[0] = 1;
                    result[1] = 0;
                    for(int j= 2; j< result.length - 1; j++) {
                        result[j] = digits[j - 1];
                    }

                    return result;
                }
            }
        }

        return digits;
    }
}
