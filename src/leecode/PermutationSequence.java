package leecode;

import java.util.ArrayList;
import java.util.List;

/***
 * http://oj.leetcode.com/problems/permutation-sequence/
 * 
 * @author weiwei
 * 
 */
public class PermutationSequence {

    private static int[] factorial = new int[10];

    static {
        factorial[0] = 1;
        for (int i = 1; i < 10; i++) {
            factorial[i] = i * factorial[i - 1];
        }
    }

    public String getPermutation(int n, int k) {
        char[] c = new char[n];

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }

        for (int i = 0; i < n; i++) {
            int rank = (k - 1) / factorial[n - i - 1];
            c[i] = (char) ('0' + list.get(rank));
            list.remove(rank);
            k -= rank * factorial[n - i - 1];
        }

        return String.valueOf(c);
    }

    public static void main(String[] args) {
        PermutationSequence c = new PermutationSequence();

        int n = 5;
        for (int i = 0; i < factorial[n]; i++) {
            String result = c.getPermutation(n, i + 1);
            System.out.println(result);
        }
    }
}
