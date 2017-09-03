package leecode;

/***
 * https://leetcode.com/problems/sqrtx/description/
 * 
 * @author weiwei
 *
 */
public class Sqrt {

    public int mySqrt(int x) {
        long r = ((long) x + 1) >> 1;
        while (r * r > x)
            r = (r + x / r) >> 1;
        return (int) r;
    }

    public static void main(String[] args) {
        Sqrt c = new Sqrt();

        System.out.println(c.mySqrt(0));
        System.out.println(c.mySqrt(1));
        System.out.println(c.mySqrt(5));
        System.out.println(c.mySqrt(24));
        System.out.println(c.mySqrt(26));
        System.out.println(c.mySqrt(Integer.MAX_VALUE));
    }

}
