package leecode;

/***
 * https://leetcode.com/problems/friend-circles/
 * 
 * @author weiweish
 *
 */
public class FriendCircles {

    private int count = 0;

    public int findCircleNum(int[][] M) {

        count = 0;
        int n = M.length;
        boolean[] used = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!used[i]) count++;
            dfs(i, M, used);
        }

        return count;
    }

    private void dfs(int i, int[][] M, boolean[] used) {
        used[i] = true;

        for (int j = 0; j < M.length; j++) {
            if (M[i][j] > 0 && !used[j]) dfs(j, M, used);
        }
    }

    public static void main(String[] args) {
        FriendCircles c = new FriendCircles();

        System.out.println(c.findCircleNum(new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } }));
        System.out.println(c.findCircleNum(new int[][] { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } }));
    }
}
