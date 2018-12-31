package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * https://leetcode.com/problems/numbers-with-same-consecutive-differences/
 * 
 * @author weiwei
 * 
 */
public class NumsSameConsecDiff {
    public int[] numsSameConsecDiff(int N, int K) {
        if (N == 0) return new int[0];

        List<Integer> res = new ArrayList<>();
        if (N == 1) res.add(0);

        // res: result list, 0: current number
        dfs(res, 0, N, K);

        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    private void dfs(List<Integer> res, int num, int n, int k) {
        // find a valid number
        if (n == 0) {
            res.add(num);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            // always pick a non-zero digit if current number is zero
            if (i == 0 && num == 0) continue;
            else if (num == 0 && i > 0) dfs(res, i, n - 1, k);
            // pick next possible digit
            else if (Math.abs(num % 10 - i) == k) dfs(res, num * 10 + i, n - 1, k);
        }
    }

    public static void main(String[] args) {
        NumsSameConsecDiff c = new NumsSameConsecDiff();
        System.out.println(Arrays.toString(c.numsSameConsecDiff(0, 1)));
        System.out.println(Arrays.toString(c.numsSameConsecDiff(1, 5)));
        System.out.println(Arrays.toString(c.numsSameConsecDiff(1, 9)));
        System.out.println(Arrays.toString(c.numsSameConsecDiff(3, 7)));
        System.out.println(Arrays.toString(c.numsSameConsecDiff(2, 1)));
        System.out.println(Arrays.toString(c.numsSameConsecDiff(4, 1)));
    }
}