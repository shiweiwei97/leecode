package leecode;

import java.util.Arrays;

/***
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 * 
 * @author weiwei
 *
 */
public class TwoSum2 {

    public int[] twoSum(int[] numbers, int target) {

        int s = 0, e = numbers.length - 1;

        while (numbers[s] + numbers[e] != target) {
            if (numbers[s] + numbers[e] < target) s++;
            else e--;
        }

        return new int[] { s + 1, e + 1 };
    }

    public static void main(String[] args) {
        TwoSum2 c = new TwoSum2();
        int[] numbers;
        int target;

        numbers = new int[] { 2, 7, 11, 15 };
        target = 9;

        System.out.println(Arrays.toString(c.twoSum(numbers, target)));
    }
}
