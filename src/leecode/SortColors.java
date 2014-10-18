package leecode;

/***
 * https://oj.leetcode.com/problems/sort-colors/
 * 
 * @author weiwei
 * 
 */
public class SortColors {

    public void sortColors(int[] A) {

        int red = 0, blue = A.length - 1;

        for (int i = 0; i < blue + 1;) {
            if (A[i] == 0) {
                swap(A, i++, red++);
            } else if (A[i] == 2) {
                swap(A, i, blue--);
            } else {
                i++;
            }
        }
    }

    private void swap(int[] A, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
