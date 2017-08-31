package leecode;

import java.math.BigInteger;

/***
 * https://leetcode.com/problems/multiply-strings/description/
 * 
 * @author weiwei
 *
 */
public class MultiplyStrings {

    public String multiply2(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] res = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            int di = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int dj = num2.charAt(j) - '0';
                int p1 = i + j, p2 = p1 + 1, mul = di * dj + res[p2];

                res[p1] += mul / 10;
                res[p2] = mul % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int v : res)
            if (!(sb.length() == 0 && v == 0)) sb.append(v);
        if (sb.length() == 0) sb.append(0);

        return sb.toString();
    }

    public String multiply(String num1, String num2) {
        int max = num1.length() + num2.length();
        int[] ans = new int[max];

        for (int i = 0; i < num2.length(); i++) {

            int di = num2.charAt(num2.length() - i - 1) - '0';

            for (int j = 0; j < num1.length(); j++) {
                int dj = num1.charAt(num1.length() - j - 1) - '0';

                int m = di * dj;
                int m1 = m % 10, m2 = m / 10;

                // add to ans array
                add(ans, m1, i + j);
                add(ans, m2, i + j + 1);
            }
        }

        return getString(ans);
    }

    private String getString(int[] ans) {
        int start = 0;
        while (start < ans.length && ans[start] == 0) {
            start++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = start; i < ans.length; i++) {
            sb.append(ans[i]);
        }
        if (sb.length() == 0) sb.append("0");
        return sb.toString();
    }

    private void add(int[] ans, int m, int offset) {

        int start = ans.length - offset - 1, sum;
        while (m > 0) {
            sum = m + ans[start];
            ans[start] = sum % 10;

            if (sum < 10) break;

            m = sum / 10;
            start--;
        }
    }

    public static void main(String[] args) {
        MultiplyStrings c = new MultiplyStrings();
        System.out.println(c.multiply("1234567890", "9876543210"));
        System.out.println(c.multiply2("1234567890", "9876543210"));

        BigInteger a = new BigInteger("1234567890");
        BigInteger b = new BigInteger("9876543210");
        System.out.println(a.multiply(b));
    }

}
