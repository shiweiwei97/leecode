package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;

/***
 * https://leetcode.com/problems/sudoku-solver/description/
 * 
 * @author weiwei
 *
 */
public class SudokuSolver {

    class Cell implements Comparable<Cell> {
        public int x;
        public int y;
        public int value;
        public int numOfPossible;
        // if mask[v] is 1 then cell value cannot be v
        public BitSet mask;

        public void setValue(int value) {
            this.value = value;
            this.numOfPossible = 1;
            this.mask.set(0, SIZE);
            this.mask.flip(value - 1);
        }

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
            this.value = 0;
            this.numOfPossible = SIZE;
            this.mask = new BitSet(SIZE);
        }

        public Cell(Cell c) {
            this.x = c.x;
            this.y = c.y;
            this.value = c.value;
            this.numOfPossible = c.numOfPossible;
            this.mask = BitSet.valueOf(c.mask.toByteArray());
        }

        @Override
        public int compareTo(Cell o) {
            return Integer.compare(this.numOfPossible, o.numOfPossible);
        }
    }

    private List<List<Cell>> mCells = new ArrayList<List<Cell>>();;

    private List<Cell> mEmptyCells = new ArrayList<Cell>();

    private static final int SIZE = 9;

    public void solveSudoku(char[][] board) {
        // reset and initialize mCells
        mCells.clear();
        mEmptyCells.clear();
        for (int i = 0; i < SIZE; i++) {
            List<Cell> row = new ArrayList<Cell>();
            mCells.add(row);
            for (int j = 0; j < SIZE; j++) {
                row.add(new Cell(i, j));
            }
        }

        // read cell values into mCells and propagate the constraints
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] != '.' && !setCell(i, j, board[i][j] - '0'))
                    // unsolvable sudoku
                    return;
            }
        }

        // check if we are done
        if (!findEmptyCells())
            // unsolvable sudoku
            return;

        // update board with solution
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Cell c = getCell(i, j);
                if (c.value > 0) board[i][j] = (char) ('0' + c.value);
            }
        }
    }

    private boolean findEmptyCells() {
        // collect all empty cells
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Cell c = getCell(i, j);
                if (c.value == 0) mEmptyCells.add(c);
            }
        }

        // sort empty cells by num of possible values
        Collections.sort(mEmptyCells);

        // try find and set values for all empty cells
        return dfs(0);
    }

    // try find and set values of empty cells starting from index >= k
    private boolean dfs(int k) {
        System.err.println("dfs start: k = " + k);
        printBoard(mCells);

        // exit criteria
        if (k >= mEmptyCells.size()) return true;

        Cell c = mEmptyCells.get(k);
        // this is necessary as cell fields from mEmptyCells might be outdated
        c = getCell(c.x, c.y);

        // only one choice, move forward
        if (c.value > 0) return dfs(k + 1);

        // make a snapshot of empty cells
        List<List<Cell>> snapshot = deepCopy(mCells);

        // try every possible values
        BitSet bs = BitSet.valueOf(c.mask.toByteArray());
        for (int val = bs.nextClearBit(0); val >= 0 && val < 9; val = bs.nextClearBit(val + 1)) {
            if (setCell(c.x, c.y, val + 1)) if (dfs(k + 1)) {
                // System.err.println("k = " + (k + 1) + ", result: true");
                // printBoard(mCells);
                return true;
            }

            // restore snapshot if previous try is not successful
            mCells = snapshot;
        }

        // print debug info
        // System.err.println("k = " + k + ", result: false");
        // printBoard(mCells);
        return false;
    }

    @SuppressWarnings("unused")
    private void printBoard(List<List<Cell>> cells) {
        StringBuilder sb = new StringBuilder("- - - - - - - - -");
        sb.append(System.lineSeparator());
        for (List<Cell> row : cells) {
            for (Cell c : row)
                sb.append(c.value).append(" ");
            sb.append(System.lineSeparator());
        }
        sb.append("- - - - - - - - -").append(System.lineSeparator());
        System.err.println(sb);
    }

    private List<List<Cell>> deepCopy(List<List<Cell>> cells) {
        List<List<Cell>> copy = new ArrayList<List<Cell>>();

        for (List<Cell> row : cells) {
            List<Cell> copyRow = new ArrayList<Cell>();

            for (Cell c : row)
                copyRow.add(new Cell(c));
            copy.add(copyRow);
        }

        return copy;
    }

    // set cell(i,j) value to val and propagate changes that it causes
    private boolean setCell(int i, int j, int val) {

        assert (val >= 1 && val <= 9);

        Cell c = getCell(i, j);

        // already set to the same value
        if (c.value == val) return true;

        // mask doesn't allow val
        if (c.mask.get(val - 1)) return false;

        // set cell value
        c.setValue(val);

        // propagate constraints
        for (int k = 0; k < SIZE; k++) {
            // column
            if (k != i && !propagateConstrains(k, j, val)) return false;

            // row
            if (k != j && !propagateConstrains(i, k, val)) return false;

            // 3x3 square
            int kx = (i / 3) * 3 + k / 3;
            int ky = (j / 3) * 3 + k % 3;
            if (kx != i && ky != j && !propagateConstrains(kx, ky, val)) return false;
        }
        return true;
    }

    private boolean propagateConstrains(int i, int j, int val) {

        Cell c = getCell(i, j);

        // already done
        if (c.mask.get(val - 1)) return true;

        // cannot resolve
        if (c.value == val) return false;

        // set new constraint
        c.mask.set(val - 1);

        // reduce num of possible values
        c.numOfPossible--;
        if (c.numOfPossible > 1) return true;

        // only value is possible, set it
        return setCell(i, j, c.mask.nextClearBit(0) + 1);
    }

    private Cell getCell(int i, int j) {
        return mCells.get(i).get(j);
    }

    public static void main(String[] args) {
        SudokuSolver c = new SudokuSolver();

        // String[] input = new String[] { "53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6",
        // ".6....28.", "...419..5", "....8..79" };

        String[] input = new String[] { "..9748...", "7........", ".2.1.9...", "..7...24.", ".64.1.59.", ".98...3..",
                "...8.3.2.", "........6", "...2759.." };

        char[][] board = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            board[i] = input[i].toCharArray();
        }

        System.out.println(Arrays.deepToString(board));

        c.solveSudoku(board);

        System.out.println(Arrays.deepToString(board));
    }

}
