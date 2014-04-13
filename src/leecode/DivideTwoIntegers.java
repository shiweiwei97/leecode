package leecode;

/***
 * http://oj.leetcode.com/problems/divide-two-integers/
 * 
 * @author weiwei
 * 
 */
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        return (int) divideLong(dividend, divisor);
    }

    private long divideLong(long dividend, long divisor) {
        if (divisor == 0) {
            return dividend >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        if (dividend < 0) {
            return -divideLong(-dividend, divisor);
        }

        if (divisor < 0) {
            return -divideLong(dividend, -divisor);
        }

        if (dividend < divisor) {
            return 0;
        }

        if (divisor == 1) {
            return dividend;
        }

        long ret = 0, p = 1, curDivisor = divisor, curDividend = dividend;
        while (curDivisor < dividend) {
            curDivisor <<= 1;
            p <<= 1;
        }

        while (p > 0 && curDividend > 0) {
            if (curDividend >= curDivisor) {
                ret += p;
                curDividend -= curDivisor;
            }

            curDivisor >>= 1;
            p >>= 1;
        }

        return ret;
    }

    public static void main(String[] args) {
        DivideTwoIntegers c = new DivideTwoIntegers();
        int result = c.divide(-2147483648, 1);

        System.out.println(result);
    }

}
