package leecode;

/***
 * https://leetcode.com/problems/word-search/description/
 * 
 * @author weiwei
 *
 */
public class WordSearch {

    private boolean[][] used;

    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) return true;
        if (board.length == 0) return false;
        if (board[0].length == 0) return false;

        int m = board.length, n = board[0].length;
        used = new boolean[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (word.charAt(0) == board[i][j] && dfs(board, i, j, word, 0, m, n)) return true;

        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int k, int m, int n) {
        if (k >= word.length()) return true;
        if (i >= m || j >= n || i < 0 || j < 0 || used[i][j] || board[i][j] != word.charAt(k)) return false;

        used[i][j] = true;

        if (dfs(board, i + 1, j, word, k + 1, m, n)) return true;
        if (dfs(board, i - 1, j, word, k + 1, m, n)) return true;
        if (dfs(board, i, j + 1, word, k + 1, m, n)) return true;
        if (dfs(board, i, j - 1, word, k + 1, m, n)) return true;

        return used[i][j] = false;
    }

    public static void main(String[] args) {

        WordSearch c = new WordSearch();

        char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        System.out.println(c.exist(board, "ABCCE"));
        System.out.println(c.exist(board, "SEE"));
        System.out.println(c.exist(board, "ABCB"));
    }

}
