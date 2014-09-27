package leecode;

/***
 * https://oj.leetcode.com/problems/n-queens-ii/
 * 
 * @author weiwei
 * 
 */
public class NQueens2 {

    private boolean[] columns;
    private boolean[] principal_diagonals;
    private boolean[] counter_diagonals;
    private int[] columnIndex;
    private int res;

    public int totalNQueens(int n) {

        this.columns = new boolean[n];
        this.principal_diagonals = new boolean[2 * n];
        this.counter_diagonals = new boolean[2 * n];
        this.columnIndex = new int[n];
        this.res = 0;

        this.dfs(0);

        return this.res;
    }

    private void dfs(int row) {
        int N = this.columnIndex.length;

        if (row == N) {
            this.res++;
            return;
        }

        for (int i = 0; i < N; i++) {
            boolean ok = !this.columns[i] && !this.principal_diagonals[row + i] && !this.counter_diagonals[row - i + N];
            if (ok) {
                this.columnIndex[row] = i;
                this.columns[i] = this.principal_diagonals[row + i] = this.counter_diagonals[row - i + N] = true;

                this.dfs(row + 1);

                this.columnIndex[row] = 0;
                this.columns[i] = this.principal_diagonals[row + i] = this.counter_diagonals[row - i + N] = false;
            }
        }
    }

    public static void main(String[] args) {
        NQueens2 c = new NQueens2();

        int res = c.totalNQueens(4);
        System.out.println(res);
    }
}
