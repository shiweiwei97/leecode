package leecode;

import java.util.HashSet;
import java.util.Set;

/***
 * https://leetcode.com/problems/contains-duplicate/
 * 
 * @author weiweish
 *
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate c = new ContainsDuplicate();
        System.out.println(c.containsDuplicate(new int[] { 1, 2, 3, 1 }));
        System.out.println(c.containsDuplicate(new int[] { 1, 2, 3, 4 }));
        System.out.println(c.containsDuplicate(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }));
    }

}
