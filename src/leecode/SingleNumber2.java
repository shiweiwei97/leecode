package leecode;

/***
 * https://oj.leetcode.com/problems/single-number-ii/
 * 
 * @author weiwei
 * 
 */
public class SingleNumber2 {

    public int singleNumber(int[] A) {
        int[] count = new int[32];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < count.length; j++) {
                count[j] += (A[i] >> j) & 1;
                count[j] %= 3;
            }
        }

        int res = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                res += 1 << i;
            }

        }

        return res;
    }

    public static void main(String[] args) {

        SingleNumber2 c = new SingleNumber2();

        int[] A = new int[] { 1, 2, 3, 2, 3, 2, 3, 1, 1, 20, 20, 20 };
        System.out.println(c.singleNumber(A));
    }

}
