package leecode;

/***
 * https://oj.leetcode.com/problems/search-insert-position/
 * 
 * @author weiwei
 * 
 */
public class SearchInsertPosition {

    public int searchInsert(int[] A, int target) {

        if (target < A[0]) {
            return 0;
        }

        if (target > A[A.length - 1]) {
            return A.length;
        }

        int left = 0, right = A.length - 1, mid = 0;
        while (left < right) {
            mid = (left + right) >> 1;
            if (target == A[mid]) {
                return mid;
            } else if (target > A[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;

    }

    public static void main(String[] args) {
        SearchInsertPosition c = new SearchInsertPosition();

        int[] A = new int[] { 1, 3, 5, 6 };
        System.out.println(c.searchInsert(A, 5));
        System.out.println(c.searchInsert(A, 2));
        System.out.println(c.searchInsert(A, 7));
        System.out.println(c.searchInsert(A, 0));
    }

}
