package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// TODO: TLE
public class SurroundedRegions {

    public void solve(char[][] board) {

        int m = board.length;
        if (m == 0) return;

        int n = board[0].length;
        if (n == 0) return;

        List<String> oList = new ArrayList<>();

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (board[i][j] == 'O') oList.add(key(i, j));

        while (!oList.isEmpty()) {

            List<String> list = new ArrayList<>();
            list.add(oList.get(0));
            boolean isOpen = false;

            // remember all the point in this round
            Set<String> allSet = new HashSet<>();
            allSet.addAll(list);

            while (!list.isEmpty()) {

                List<String> newList = new ArrayList<>();

                for (String key : list) {
                    String[] arr = key.split(",");
                    int x = Integer.parseInt(arr[0]), y = Integer.parseInt(arr[1]);
                    if (x == 0 || y == 0 || x == m - 1 || y == n - 1) isOpen = true;

                    if (x > 0 && board[x - 1][y] == 'O' && !allSet.contains(key(x - 1, y))) newList.add(key(x - 1, y));
                    if (y > 0 && board[x][y - 1] == 'O' && !allSet.contains(key(x, y - 1))) newList.add(key(x, y - 1));
                    if (x < m - 1 && board[x + 1][y] == 'O' && !allSet.contains(key(x + 1, y))) newList.add(key(x + 1, y));
                    if (y < n - 1 && board[x][y + 1] == 'O' && !allSet.contains(key(x, y + 1))) newList.add(key(x, y + 1));
                }

                list = newList;
                allSet.addAll(list);
            }

            if (!isOpen) {
                for (String key : allSet) {
                    String[] arr = key.split(",");
                    int x = Integer.parseInt(arr[0]), y = Integer.parseInt(arr[1]);
                    board[x][y] = 'X';
                }
            }

            oList.removeAll(allSet);
        }
    }

    private String key(int x, int y) {
        StringBuilder sb = new StringBuilder();
        sb.append(x).append(",").append(y);
        return sb.toString();
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
        c.solve(board);
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
