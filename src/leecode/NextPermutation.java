package leecode;

import java.util.Arrays;

/***
 * http://oj.leetcode.com/problems/next-permutation/
 * 
 * @author weiwei
 * 
 */
public class NextPermutation {

    public void nextPermutation(int[] num) {

        // partition number: from right to left, first number violates increase trend
        int partitionIdx = -1;
        for (int i = num.length - 1; i > 0; i--) {
            if (num[i] > num[i - 1]) {
                partitionIdx = i - 1;
                break;
            }
        }

        // no partition: last permutation
        if (partitionIdx == -1) {
            reverse(num, 0, num.length);
            return;
        }

        // change number: from right to left, first number larger than partition number
        int changeIdx = -1;
        for (int i = num.length - 1; i >= 0; i--) {
            if (num[i] > num[partitionIdx]) {
                changeIdx = i;
                break;
            }
        }

        // swap partition and change number
        swap(num, partitionIdx, changeIdx);

        // reverse all digits to the right of partition
        reverse(num, partitionIdx + 1, num.length);
    }

    private void swap(int[] num, int idx1, int idx2) {
        int tmp = num[idx1];
        num[idx1] = num[idx2];
        num[idx2] = tmp;
    }

    private void reverse(int[] num, int start, int end) {
        // start inclusive, end exclusive
        for (int i = start; i < (start + end) / 2; i++) {
            swap(num, i, start + end - i - 1);
        }
    }

    public static void main(String[] args) {

        NextPermutation c = new NextPermutation();
        int[] num = null;

        num = new int[] { 1, 2, 3 };
        c.nextPermutation(num);
        System.out.println(Arrays.toString(num));

        num = new int[] { 3, 2, 1 };
        c.nextPermutation(num);
        System.out.println(Arrays.toString(num));

        num = new int[] { 1, 1, 5 };
        c.nextPermutation(num);
        System.out.println(Arrays.toString(num));

        num = new int[] { 6, 8, 7, 4, 3, 2 };
        c.nextPermutation(num);
        System.out.println(Arrays.toString(num));
    }
}
