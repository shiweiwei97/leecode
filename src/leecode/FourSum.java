package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * 
 * https://leetcode.com/problems/4sum/description/
 * 
 * @author weiwei
 *
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length - 3; i++) {
            // skip too large
            if (sumByRange(nums, i, 4) > target)
                continue;

            // skip too small
            if (nums[i] + sumByRange(nums, nums.length - 3, 3) < target)
                continue;

            // skip duplicate
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                // skip too large
                if (nums[i] + sumByRange(nums, j, 3) > target)
                    continue;

                // skip too small
                if (nums[i] + nums[j] + sumByRange(nums, nums.length - 2, 2) < target)
                    continue;

                // skip duplicate
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                // start 2Sum search
                int lo = j + 1, hi = nums.length - 1, sum = target - nums[i] - nums[j];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        // found a match
                        result.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));

                        // skip on duplicate nums[lo] and nums[hi]
                        while (lo < hi && nums[lo] == nums[lo + 1])
                            lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1])
                            hi--;
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] < sum) {
                        // increase nums[lo]
                        lo++;
                    } else {
                        // decrease nums[hi]
                        hi--;
                    }
                }
            }
        }

        return result;
    }

    private int sumByRange(int[] nums, int start, int len) {
        int sum = 0;
        for (int i = start; i < start + len && i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        FourSum c = new FourSum();
        int[] nums;
        int target;

        nums = new int[] { 1, 0, -1, 0, -2, 2 };
        target = 0;
        System.out.println(c.fourSum(nums, target));
    }
}
