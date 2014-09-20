package leecode;

/***
 * https://oj.leetcode.com/problems/reverse-integer/
 * 
 * @author weiwei
 * 
 */
public class Reverse {

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }

        return res;
    }

    public static void main(String[] args) {

        Reverse c = new Reverse();
        System.out.println(c.reverse(321));
        System.out.println(c.reverse(-321));
        System.out.println(c.reverse(100));
    }
}
