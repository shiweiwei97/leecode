package leecode;

/***
 * https://leetcode.com/problems/nth-magical-number/
 * 
 * @author weiweish
 *
 */
public class NthMagicalNumber {

    int m = 1000000007;

    public int nthMagicalNumber(int N, int A, int B) {

        if (B < A) {
            return nthMagicalNumber(N, B, A);
        }

        long start = 0L, end = Long.MAX_VALUE;
        while (start < end) {
            long mid = start + ((end - start) >> 1);
            if (check(A, B, mid) < N) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return (int) (start % m);
    }

    private long check(int A, int B, long mid) {
        long count = 0;
        int lcm = lcm(A, B);

        count += (mid / A);
        if (lcm != B) {
            count += (mid / B);
            count -= (mid / lcm);
        }
        return count;
    }

    private int lcm(int p, int q) {
        return p * q / gcd(p, q);
    }

    private static int gcd(int m, int n) {
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }
        while (m % n != 0) {
            int temp = m % n;
            m = n;
            n = temp;
        }
        return n;
    }

    public static void main(String[] args) {
        NthMagicalNumber c = new NthMagicalNumber();

        System.out.println(c.nthMagicalNumber(1000000000, 40000, 40000));
        System.out.println(c.nthMagicalNumber(3, 8, 9));
        System.out.println(c.nthMagicalNumber(1, 2, 3));
        System.out.println(c.nthMagicalNumber(4, 2, 3));
        System.out.println(c.nthMagicalNumber(5, 2, 4));
        System.out.println(c.nthMagicalNumber(3, 6, 4));
    }

}
