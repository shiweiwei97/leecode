package leecode;

/***
 * https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * 
 * @author weiwei
 * 
 */
public class FindMinRotatedSortedArray {

    public int findMin(int[] num) {

        int left = 0, right = num.length - 1;

        while (num[left] > num[right]) {
            int mid = (left + right) >> 1;
            if (num[mid] >= num[left]) {
                left = mid + 1;
            } else if (num[mid] < num[right]) {
                right = mid;
            }
        }

        return num[left];
    }
}
