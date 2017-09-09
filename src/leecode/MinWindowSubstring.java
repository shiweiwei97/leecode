package leecode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/***
 * https://leetcode.com/problems/minimum-window-substring/description/
 * 
 * @author weiwei
 *
 */
public class MinWindowSubstring {

    public String minWindow(String s, String t) {
        char[] ss = s.toCharArray(), tt = t.toCharArray();

        Map<Character, AtomicInteger> map = new HashMap<>();
        for (char c : tt)
            addMap(map, c, 1);

        int count = tt.length, begin = 0, end = 0, min = Integer.MAX_VALUE, head = 0;
        while (end < ss.length) {
            // move right pointer to right, decrease count if found char in t
            if (addMap(map, ss[end++], -1) >= 0) count--;

            while (count == 0) {
                // found a valid min window
                if (end - begin < min) min = end - (head = begin);

                // move left pointer to right until it is invalid
                if (addMap(map, ss[begin++], 1) > 0) count++;
            }
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(head, head + min);
    }

    private int addMap(Map<Character, AtomicInteger> map, char c, int toAdd) {
        if (!map.containsKey(c)) {
            AtomicInteger newVal = new AtomicInteger(toAdd);
            map.put(c, newVal);
            return toAdd;
        }
        return map.get(c).addAndGet(toAdd);
    }

    public static void main(String[] args) {

        MinWindowSubstring c = new MinWindowSubstring();
        System.out.println(c.minWindow("ADOBECODEBANC", "ABC"));
    }

}
