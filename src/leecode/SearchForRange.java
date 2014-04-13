package leecode;

import java.util.Arrays;

/***
 * http://oj.leetcode.com/problems/search-for-a-range/
 * 
 * @author weiwei
 * 
 */
public class SearchForRange {
    public int[] searchRange(int[] A, int target) {
        int[] ret = new int[] { -1, -1 };

        int start = Arrays.binarySearch(A, target);
        if (start < 0) {
            return ret;
        }

        int prev = Arrays.binarySearch(A, target - 1);
        if (prev < 0) {
            prev = -(prev + 1);
            ret[0] = prev;
        }

        int next = Arrays.binarySearch(A, target + 1);
        if (next < 0) {
            next = -(next + 1);
            ret[1] = next - 1;
        }

        if (ret[0] == -1) {
            int left = prev, right = start;
            while (left < right) {
                if (A[(left + right) / 2] == target) {
                    if (right == (left + right) / 2) {
                        break;
                    }
                    right = (left + right) / 2;
                } else {
                    if (left == (left + right) / 2) {
                        break;
                    }
                    left = (left + right) / 2;
                }
            }
            ret[0] = right;
        }

        if (ret[1] == -1) {
            if (next >= A.length) {
                ret[1] = next;
            } else {
                int left = start, right = next;
                while (left < right) {
                    if (A[(left + right) / 2] == target) {
                        if (left == (left + right) / 2) {
                            break;
                        }
                        left = (left + right) / 2;
                    } else {
                        if (right == (left + right) / 2) {
                            break;
                        }
                        right = (left + right) / 2;
                    }
                }

                ret[1] = left;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        SearchForRange c = new SearchForRange();
        int[] A = new int[] { 5, 7, 7, 8, 8, 8, 8, 10, 12, 12, 13, 15, 15, 15 };
        int target = 15;
        int[] result = c.searchRange(A, target);

        System.out.println(Arrays.toString(result));
    }

}
