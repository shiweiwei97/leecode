package leecode;

import java.util.HashSet;
import java.util.Set;

/***
 * http://oj.leetcode.com/problems/longest-consecutive-sequence/
 * 
 * @author weiwei
 * 
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] num) {

        int ret = 1;

        Set<Integer> set = new HashSet<Integer>();
        for (int n : num) {
            set.add(n);
        }

        for (int n : num) {
            if (!set.contains(n)) {
                continue;
            }

            int count = 1;
            for (int i = 1; set.contains(n + i); i++) {
                set.remove(n + i);
                count++;
            }
            for (int i = -1; set.contains(n + i); i--) {
                set.remove(n + i);
                count++;
            }
            ret = Math.max(count, ret);
        }

        return ret;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence c = new LongestConsecutiveSequence();
        int result = c.longestConsecutive(new int[] { 100, 4, 200, 1, 2, 5, 6, 99, 101, 102 });

        System.out.println(result);
    }

}
