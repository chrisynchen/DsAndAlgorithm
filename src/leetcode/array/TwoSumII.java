package leetcode.array;

/**
 * 167. Two Sum II - Input array is sorted (Easy)
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 * <p>
 * Note:
 * <p>
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Example:
 * <p>
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
public class TwoSumII {
    public static void main(String[] args) {
        int[] result = twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int r : result) {
            System.out.print(r);
        }
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] resultArray = new int[2];

        int startIndex = 0;
        int endIndex = numbers.length - 1;
        while (numbers[startIndex] + numbers[endIndex] != target) {
            if (target - numbers[endIndex] > numbers[startIndex]) {
                startIndex++;
            } else {
                endIndex--;
            }
        }

        resultArray[0] = startIndex + 1;
        resultArray[1] = endIndex + 1;

        return resultArray;
    }
}
