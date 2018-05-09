package leecode;

/***
 * https://leetcode.com/problems/delete-and-earn/description/
 * 
 * @author weiweish
 *
 */
public class DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        // find max num
        int max = Integer.MIN_VALUE;
        for (int n : nums)
            max = Math.max(max, n);

        // count occurrences of each number
        int[] cntMap = new int[max + 1];
        for (int n : nums)
            cntMap[n]++;

        // dp[i]: solution of max number up to i
        int[] dp = new int[max + 1];
        dp[1] = cntMap[1];

        // dp[i] could be:
        // 1. dp[i-1], if i is not deleted
        // 2. dp[i-2] + count(i) * i, if i is deleted
        for (int i = 2; i <= max; i++)
            dp[i] = Math.max(dp[i - 2] + cntMap[i] * i, dp[i - 1]);

        return dp[max];
    }

    public static void main(String[] args) {

        DeleteAndEarn c = new DeleteAndEarn();

        int[] nums = new int[] { 3, 4, 2 };
        System.out.println(c.deleteAndEarn(nums));

        nums = new int[] { 2, 2, 3, 3, 3, 4 };
        System.out.println(c.deleteAndEarn(nums));

        nums = new int[] {};
        System.out.println(c.deleteAndEarn(nums));
    }
}
