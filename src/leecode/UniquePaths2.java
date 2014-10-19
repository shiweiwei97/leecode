package leecode;

/***
 * https://oj.leetcode.com/problems/unique-paths-ii/
 * 
 * @author weiwei
 * 
 */
public class UniquePaths2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] res = new int[m][n];

        res[0][0] = 1;

        for (int i = 1; i < n; i++) {
            res[0][i] = obstacleGrid[0][i] == 0 ? res[0][i - 1] : 0;
        }

        for (int i = 1; i < m; i++) {
            res[i][0] = obstacleGrid[i][0] == 0 ? res[i - 1][0] : 0;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = obstacleGrid[i][j] == 0 ? (res[i - 1][j] + res[i][j - 1]) : 0;
            }
        }

        return res[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths2 c = new UniquePaths2();
        int[][] obstacleGrid = { { 0, 0 }, { 1, 1 }, { 0, 0 } };

        System.out.println(c.uniquePathsWithObstacles(obstacleGrid));
    }
}
