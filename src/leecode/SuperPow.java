package leecode;

/***
 * https://leetcode.com/problems/super-pow/
 * 
 * @author weiweish
 *
 */
public class SuperPow {

    int m = 1337;

    public int superPow(int a, int[] b) {

        int res = 1;

        for (int i = 0; i < b.length; i++) {
            res = pow(res, 10) * pow(a, b[i]) % m;
        }

        return res;
    }

    private int pow(int a, int b) {
        a %= m;
        if (b == 0 || a == 1) return 1;
        if (b == 1) return a % m;

        return pow(a, b >> 1) * pow(a, b - (b >> 1)) % m;
    }

    public static void main(String[] args) {
        SuperPow c = new SuperPow();
        System.out.println(c.superPow(2, new int[] { 3 }));
        System.out.println(c.superPow(2, new int[] { 1, 0 }));
    }
}
