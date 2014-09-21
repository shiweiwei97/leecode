package leecode;

/***
 * https://oj.leetcode.com/problems/unique-binary-search-trees/
 * 
 * @author weiwei
 * 
 */
public class UniqueBST {

    public int numTrees(int n) {
        if (n < 2) {
            return 1;
        }

        int[] res = new int[n + 1];
        res[0] = res[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                res[i] += res[j] * res[i - j - 1];
            }
        }

        return res[n];
    }

    public static void main(String[] args) {
        UniqueBST c = new UniqueBST();

        for (int i = 0; i < 10; i++) {
            System.out.println(c.numTrees(i));
        }
    }
}
