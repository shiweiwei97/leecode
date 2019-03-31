package leecode;

import java.util.Arrays;

/***
 * https://leetcode.com/problems/sort-array-by-parity-ii/
 * 
 * @author weiweish
 *
 */
public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] A) {

        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == i % 2) continue;

            for (int j = i + 1; j < A.length; j++) {
                if (A[j] % 2 == i % 2) {
                    int temp = A[j];
                    A[j] = A[i];
                    A[i] = temp;
                    break;
                }
            }
        }

        return A;
    }

    /***
     * https://leetcode.com/problems/sort-array-by-parity-ii/discuss/265141/Java-beats-99-(2ms)-quick-sort
     */
    public int[] sortArrayByParityII2(int[] A) {

        if (A == null || (A.length & 1) == 1) return null;

        int left = 0, right = A.length - 1;
        while (true) {
            while (left < A.length && (A[left] & 1) == 0)
                left += 2;
            if (left == A.length) break;

            while (right > -1 && (A[right] & 1) == 1)
                right -= 2;
            if (right == -1) break;

            int temp = A[left];
            A[left] = A[right];
            A[right] = temp;
        }

        return A;
    }

    public static void main(String[] args) {
        SortArrayByParityII c = new SortArrayByParityII();
        System.out.println(Arrays.toString(c.sortArrayByParityII(new int[] { 4, 2, 5, 7 })));
        System.out.println(Arrays.toString(c.sortArrayByParityII2(new int[] { 4, 2, 5, 7 })));
    }
}
