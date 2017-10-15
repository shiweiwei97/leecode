package leecode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FractionRecurringDecimal {

    public String fractionToDecimal(int n, int d) {
        return fraction((long) n, (long) d);
    }

    private String fraction(long n, long d) {
        if (d == 0) return "ERROR";
        if (n == 0) return "0";
        if (n < 0 && d > 0) return "-" + fraction(-n, d);
        if (n > 0 && d < 0) return "-" + fraction(n, -d);
        if (n < 0 && d < 0) return fraction(-n, -d);

        // now numerator > 0 && denominator > 0
        if (n % d == 0) return String.valueOf(n / d);

        // now numerator % denominator > 0
        if (n > d) return String.valueOf(n / d) + fraction(n % d, d).substring(1);

        // now numerator < denominator
        long g = gcd(n, d);
        if (g > 1) return fraction(n / g, d / g);

        // now gcd(numerator, denominator) == 1
        Set<Long> set = new HashSet<>();
        List<Long> remainders = new ArrayList<>();
        List<Long> quotients = new ArrayList<>();

        // find the same remainder or remainder == 0
        long r = n;
        while (!set.contains(r) && r > 0) {
            set.add(r);
            remainders.add(r);

            quotients.add(r * 10 / d);
            r = (r * 10) % d;
        }

        // not recurring
        if (r == 0) {
            StringBuilder sb = new StringBuilder("0.");
            for (long q : quotients)
                sb.append(q);
            return sb.toString();
        }

        // recurring, find the repeating pattern
        int idx = remainders.indexOf(r);

        StringBuilder res = new StringBuilder("0.");
        for (int i = 0; i < idx; i++)
            res.append(quotients.get(i));

        res.append("(");
        for (int i = idx; i < quotients.size(); i++)
            res.append(quotients.get(i));
        res.append(")");

        return res.toString();
    }

    private static long gcd(long a, long b) {
        while (b > 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        FractionRecurringDecimal c = new FractionRecurringDecimal();

        System.out.println(c.fractionToDecimal(1, 2));
        System.out.println(c.fractionToDecimal(2, 1));
        System.out.println(c.fractionToDecimal(2, 3));
        System.out.println(c.fractionToDecimal(2, 7));
        System.out.println(c.fractionToDecimal(9, 7));
        System.out.println(c.fractionToDecimal(-9, 7));
        System.out.println(c.fractionToDecimal(9, -7));
        System.out.println(c.fractionToDecimal(-9, -7));
        System.out.println(c.fractionToDecimal(10, 2));
        System.out.println(c.fractionToDecimal(1, 100));
        System.out.println(c.fractionToDecimal(-1, -2147483648));
    }
}
