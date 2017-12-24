package leecode;

import java.util.Arrays;
import java.util.Comparator;

/***
 * https://leetcode.com/problems/largest-number/description/
 * 
 * @author weiweish
 *
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {

        int n = nums.length;

        String[] arr = new String[n];
        for (int i = 0; i < n; i++)
            arr[i] = String.valueOf(nums[i]);

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        });

        if (arr[0].startsWith("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (String s : arr)
            sb.append(s);

        return sb.toString();
    }

    public static void main(String[] args) {

        LargestNumber c = new LargestNumber();

        int[] nums = new int[] { 3, 30, 34, 5, 9 };

        System.out.println(c.largestNumber(nums));
    }
}
