package leecode;

import java.util.ArrayList;
import java.util.List;

/***
 * https://oj.leetcode.com/problems/n-queens/
 * 
 * @author weiwei
 * 
 */
public class NQueens {

    private boolean[] columns;
    private boolean[] principal_diagonals;
    private boolean[] counter_diagonals;
    private int[] columnIndex;
    private List<String[]> res;

    public List<String[]> solveNQueens(int n) {

        this.columns = new boolean[n];
        this.principal_diagonals = new boolean[2 * n];
        this.counter_diagonals = new boolean[2 * n];
        this.columnIndex = new int[n];
        this.res = new ArrayList<String[]>();

        this.dfs(0);

        return this.res;
    }

    private void dfs(int row) {
        int N = this.columnIndex.length;

        if (row == N) {
            String[] solution = new String[N];
            for (int i = 0; i < N; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < N; j++) {
                    sb.append(j == this.columnIndex[i] ? 'Q' : '.');
                }
                solution[i] = sb.toString();
            }

            res.add(solution);
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
        NQueens c = new NQueens();

        List<String[]> res = c.solveNQueens(8);
        for (String[] solution : res) {
            System.out.println("Solution:");
            for (String s : solution) {
                System.out.println(s);
            }
        }
    }
}
