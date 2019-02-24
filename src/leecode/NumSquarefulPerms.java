package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * https://leetcode.com/problems/number-of-squareful-arrays/
 * 
 * @author weiweish
 *
 */
public class NumSquarefulPerms {

    private int count = 0;

    public int numSquarefulPerms(int[] A) {
        count = 0;
        Arrays.sort(A);

        dfs(new ArrayList<>(), A, new boolean[A.length], -1);

        return count;
    }

    private void dfs(List<Integer> temp, int[] A, boolean[] used, int lastNum) {

        if (temp.size() == A.length) {
            count++;
            return;
        }

        for (int i = 0; i < A.length; i++) {
            if (used[i] || (i > 0 && !used[i - 1] && A[i] == A[i - 1])) continue;

            if (lastNum != -1 && !isSquare(A[i], lastNum)) continue;

            used[i] = true;
            temp.add(A[i]);

            dfs(temp, A, used, A[i]);

            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }

    private boolean isSquare(int a, int b) {
        double sr = Math.sqrt(a + b);
        return ((sr - Math.floor(sr)) == 0);
    }

    public static void main(String[] args) {
        NumSquarefulPerms c = new NumSquarefulPerms();

        System.out.println(c.numSquarefulPerms(new int[] { 1, 17, 8 }));
        System.out.println(c.numSquarefulPerms(new int[] { 2, 2, 2 }));
    }
}
