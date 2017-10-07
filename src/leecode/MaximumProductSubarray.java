package leecode;

/***
 * https://leetcode.com/problems/maximum-product-subarray/description/
 * 
 * @author weiwei
 *
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int max = nums[0], min = nums[0], res = nums[0];

        for (int i = 1; i < n; i++) {
            int num = nums[i];

            int newMax = Math.max(max * num, Math.max(min * num, num));
            int newMin = Math.min(max * num, Math.min(min * num, num));

            max = newMax;
            min = newMin;

            res = Math.max(res, max);
        }

        return res;
    }

    public static void main(String[] args) {

        MaximumProductSubarray c = new MaximumProductSubarray();
        System.out.println(c.maxProduct(new int[] { 2, 3, -2, 4 }));
    }

}
