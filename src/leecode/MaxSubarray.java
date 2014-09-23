package leecode;

/***
 * https://oj.leetcode.com/problems/maximum-subarray/
 * 
 * @author weiwei
 * 
 */
public class MaxSubarray {

    public int maxSubArray(int[] A) {
        int max = A[0], f = A[0];
        for (int i = 1; i < A.length; i++) {
            f = f > 0 ? f + A[i] : A[i];
            max = Math.max(max, f);
        }

        return max;
    }

    public static void main(String[] args) {
        MaxSubarray c = new MaxSubarray();

        int[] A = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(c.maxSubArray(A));
    }
}
