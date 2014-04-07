package leecode;

import java.util.Arrays;

/***
 * 
 * @author weiwei
 * 
 *         http://oj.leetcode.com/problems/two-sum/
 * 
 */

public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {

        int[] sorted = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(sorted);

        int head = 0, tail = numbers.length - 1;
        while (head < tail) {
            if (sorted[head] + sorted[tail] == target) {
                break;
            } else if (sorted[head] + sorted[tail] > target) {
                tail--;
            } else if (sorted[head] + sorted[tail] < target) {
                head++;
            }
        }

        if (head >= tail) {
            return null;
        }

        int index1 = findIndex(numbers, sorted[head]);
        int index2 = findLastIndex(numbers, sorted[tail]);

        if (index1 > index2) {
            return new int[] { index2, index1 };
        }

        return new int[] { index1, index2 };
    }

    private int findIndex(int[] numbers, int value) {
        int ret = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (value == numbers[i]) {
                ret = i;
                break;
            }
        }

        return ret + 1;
    }

    private int findLastIndex(int[] numbers, int value) {
        int ret = -1;
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (value == numbers[i]) {
                ret = i;
                break;
            }
        }

        return ret + 1;
    }

    public static void main(String[] args) {
        TwoSum c = new TwoSum();
        int[] result = c.twoSum(new int[] { 2, 7, 11, 15 }, 9);

        System.out.println(Arrays.toString(result));
    }
}
