package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/***
 * https://leetcode.com/problems/surrounded-regions/description/
 * 
 * @author weiwei
 *
 */
public class SurroundedRegions {

    public void solve(char[][] board) {

        int m = board.length;
        if (m == 0) return;

        int n = board[0].length;
        if (n == 0) return;

        List<String> oList = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') oList.add(key(i, 0));
            if (board[i][n - 1] == 'O') oList.add(key(i, n - 1));
        }

        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') oList.add(key(0, i));
            if (board[m - 1][i] == 'O') oList.add(key(m - 1, i));
        }

        while (!oList.isEmpty()) {

            Set<String> set = new HashSet<>();
            set.add(oList.get(0));

            // remember all the point in this round
            Set<String> allSet = new HashSet<>();
            allSet.addAll(set);

            while (!set.isEmpty()) {

                for (String key : set) {
                    String[] arr = key.split(",");
                    int x = Integer.parseInt(arr[0]), y = Integer.parseInt(arr[1]);
                    board[x][y] = 'B';
                }

                Set<String> newSet = new HashSet<>();

                for (String key : set) {
                    String[] arr = key.split(",");
                    int x = Integer.parseInt(arr[0]), y = Integer.parseInt(arr[1]);

                    if (x > 0 && board[x - 1][y] == 'O' && !allSet.contains(key(x - 1, y))) newSet.add(key(x - 1, y));
                    if (y > 0 && board[x][y - 1] == 'O' && !allSet.contains(key(x, y - 1))) newSet.add(key(x, y - 1));
                    if (x < m - 1 && board[x + 1][y] == 'O' && !allSet.contains(key(x + 1, y)))
                        newSet.add(key(x + 1, y));
                    if (y < n - 1 && board[x][y + 1] == 'O' && !allSet.contains(key(x, y + 1)))
                        newSet.add(key(x, y + 1));
                }

                set = newSet;
                allSet.addAll(set);
            }

            oList.removeAll(allSet);
        }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = board[i][j] == 'B' ? 'O' : 'X';
    }

    private String key(int x, int y) {
        StringBuilder sb = new StringBuilder();
        sb.append(x).append(",").append(y);
        return sb.toString();
    }

    public void solve2(char[][] board) {

        int m = board.length;
        if (m == 0) return;

        int n = board[0].length;
        // at least 3x3 square can surround something
        if (m < 3 || n < 3) return;

        // start DFS from boundary
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0, m, n);
            if (board[i][n - 1] == 'O') dfs(board, i, n - 1, m, n);
        }

        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') dfs(board, 0, i, m, n);
            if (board[m - 1][i] == 'O') dfs(board, m - 1, i, m, n);
        }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = board[i][j] == 'B' ? 'O' : 'X';
    }

    private void dfs(char[][] board, int x, int y, int m, int n) {
        if (x < 0 || x >= m || y < 0 || y >= n) return;
        if (board[x][y] == 'O') board[x][y] = 'B';

        // don't touch boundary cells, they will be covered anyways
        if (x > 1 && board[x - 1][y] == 'O') dfs(board, x - 1, y, m, n);
        if (y > 1 && board[x][y - 1] == 'O') dfs(board, x, y - 1, m, n);
        if (x < m - 2 && board[x + 1][y] == 'O') dfs(board, x + 1, y, m, n);
        if (y < n - 2 && board[x][y + 1] == 'O') dfs(board, x, y + 1, m, n);
    }

    public static void main(String[] args) {

        SurroundedRegions c = new SurroundedRegions();
        char[][] board;

        board = new char[][] {

                "XOOOOOOOOOOOOOOOOOOO".toCharArray(),

                "OXOOOOXOOOOOOOOOOOXX".toCharArray(),

                "OOOOOOOOXOOOOOOOOOOX".toCharArray(),

                "OOXOOOOOOOOOOOOOOOXO".toCharArray(),

                "OOOOOXOOOOXOOOOOXOOX".toCharArray(),

                "XOOOXOOOOOXOXOXOXOXO".toCharArray(),

                "OOOOXOOXOOOOOXOOXOOO".toCharArray(),

                "XOOOXXXOXOOOOXXOXOOO".toCharArray(),

                "OOOOOXXXXOOOOXOOXOOO".toCharArray(),

                "XOOOOXOOOOOOXXOOXOOX".toCharArray(),

                "OOOOOOOOOOXOOXOOOXOX".toCharArray(),

                "OOOOXOXOOXXOOOOOXOOO".toCharArray(),

                "XXOOOOOXOOOOOOOOOOOO".toCharArray(),

                "OXOXOOOXOXOOOXOXOXOO".toCharArray(),

                "OOXOOOOOOOXOOOOOXOXO".toCharArray(),

                "XXOOOOOOOOXOXXOOOXOO".toCharArray(),

                "OOXOOOOOOOXOOXOXOXOO".toCharArray(),

                "OOOXOOOOOXXXOOXOOOXO".toCharArray(),

                "OOOOOOOOOOOOOOOOOOOO".toCharArray(),

                "XOOOOXOOOXXOOXOXOXOO".toCharArray()

        };
        c.solve2(board);
        System.out.println(Arrays.deepToString(board));

        board = new char[][] {

                "XXXX".toCharArray(),

                "XOOX".toCharArray(),

                "XXOX".toCharArray(),

                "XOXX".toCharArray()

        };
        c.solve(board);
        System.out.println(Arrays.deepToString(board));

    }

}
