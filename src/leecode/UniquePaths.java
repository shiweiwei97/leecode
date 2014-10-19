package leecode;

/***
 * https://oj.leetcode.com/problems/unique-paths/
 * 
 * @author weiwei
 * 
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {

        if (m <= 1 || n <= 1) {
            return 1;
        }

        int[] res = new int[n];
        res[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[j] = res[j - 1] + res[j];
            }
        }

        return res[n - 1];
    }
}
