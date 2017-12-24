package leecode;

/***
 * https://leetcode.com/problems/dungeon-game/description/
 * 
 * @author weiweish
 *
 */
public class DungeonGame {

    public int calculateMinimumHP(int[][] dungeon) {

        int m = dungeon.length;
        int n = dungeon[0].length;

        // initialize with Integer.MAX_VALUE
        int[][] res = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            for (int j = 0; j <= n; j++)
                res[i][j] = Integer.MAX_VALUE;

        // for botton right cell
        res[m][n - 1] = res[m - 1][n] = 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // pick an easier path between down and right direction
                int need = Math.min(res[i + 1][j], res[i][j + 1]) - dungeon[i][j];

                // if need < 0, 1 is minimal to be alive
                res[i][j] = need > 0 ? need : 1;
            }
        }

        return res[0][0];
    }

    public static void main(String[] args) {

        DungeonGame c = new DungeonGame();

        int[][] dungeon = new int[][] { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };

        System.out.println(c.calculateMinimumHP(dungeon));
    }

}
