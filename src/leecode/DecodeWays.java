package leecode;

/***
 * https://leetcode.com/problems/decode-ways/description/
 * 
 * @author weiwei
 *
 */
public class DecodeWays {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;

        int len = s.length();
        char[] ss = s.toCharArray();
        int[] res = new int[len + 1];

        res[0] = 1;
        res[1] = (ss[0] - '0') > 0 ? 1 : 0;
        if (len == 1) return res[1];

        for (int i = 2; i <= len; i++) {
            int d1 = ss[i - 1] - '0', d2 = ss[i - 2] - '0';
            d2 = d2 * 10 + d1;

            int p1 = d1 > 0 ? res[i - 1] : 0;
            int p2 = d2 > 9 && d2 < 27 ? res[i - 2] : 0;

            res[i] = p1 + p2;
        }

        return res[len];
    }

    public static void main(String[] args) {
        DecodeWays c = new DecodeWays();

        System.out.println(c.numDecodings("12"));
        System.out.println(c.numDecodings("10"));
        System.out.println(c.numDecodings("00"));
        System.out.println(c.numDecodings("01"));
    }
}
