package leecode;

/***
 * http://oj.leetcode.com/problems/climbing-stairs/
 * 
 * @author weiwei
 * 
 */
public class ClimeStairs {
    public int climbStairs(int n) {
        int[] r = new int[] { 1, 0, 0, 1 };
        int[] m = new int[] { 1, 1, 1, 0 };
        int p = 1;
        while (p < n) {
            if (((n - 1) & p) > 0) {
                r = multiply(r, m);
            }

            m = multiply(m, m);
            p <<= 1;
        }

        return r[0] + r[1];
    }

    private int[] multiply(int[] A, int[] B) {

        int r0 = A[0] * B[0] + A[1] * B[2];
        int r1 = A[0] * B[1] + A[1] * B[3];
        int r2 = A[2] * B[0] + A[3] * B[2];
        int r3 = A[2] * B[1] + A[3] * B[3];

        return new int[] { r0, r1, r2, r3 };
    }

    public static void main(String[] args) {

        ClimeStairs c = new ClimeStairs();

        for (int i = 0; i < 45; i++) {
            int result = c.climbStairs(i);
            System.out.println(result);
        }
    }

}
