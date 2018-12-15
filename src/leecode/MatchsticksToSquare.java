package leecode;

import java.util.Arrays;

/***
 * https://leetcode.com/problems/matchsticks-to-square/description/
 * 
 * @author weiweish
 *
 */
public class MatchsticksToSquare {

    public boolean makesquare(int[] nums) {

        if (nums == null || nums.length < 4) return false;

        int sum = 0;
        for (int n : nums)
            sum += n;
        if (sum % 4 != 0) return false;

        int w = sum >> 2;
        Arrays.sort(nums);
        if (nums[0] > w) return false;

        boolean[] used = new boolean[nums.length];

        return dfs(nums, used, 0, 0, w, w);
    }

    private boolean dfs(int[] nums, boolean[] used, int start, int count, int left, int target) {
        if (start == nums.length || left < 0) return false;

        if (left == 0) {
            count++;

            // no need to check the last side
            if (count == 3) return true;

            return dfs(nums, used, 0, count, target, target);
        }

        for (int i = start; i < nums.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            if (dfs(nums, used, i + 1, count, left - nums[i], target)) return true;
            used[i] = false;
        }

        return false;
    }

    public static void main(String[] args) {

        MatchsticksToSquare c = new MatchsticksToSquare();

        System.out.println(c.makesquare(new int[] { 1, 1, 2, 2, 2 }));
        System.out.println(c.makesquare(new int[] { 3, 3, 3, 3, 4 }));
        System.out.println(c.makesquare(new int[] { 1, 1, 99, 99, 50, 70, 80 }));
    }
}
