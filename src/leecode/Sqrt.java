package leecode;

/***
 * https://leetcode.com/problems/sqrtx/description/
 * 
 * @author weiwei
 *
 */
public class Sqrt {

    public int mySqrt(int x) {
        long r = x;
        while (r * r > x)
            r = (r + x / r) / 2;
        return (int) r;
    }

    public static void main(String[] args) {
        Sqrt c = new Sqrt();
        System.out.println(c.mySqrt(25));
    }

}
