package leecode;

/***
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/
 * 
 * @author weiwei
 * 
 */
public class RemoveDupSortedArray {

    public int removeDuplicates(int[] A) {

        if (A.length < 2) {
            return A.length;
        }

        int index = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[index]) {
                index++;
                A[index] = A[i];
            }
        }

        return index + 1;
    }
}
