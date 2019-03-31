package leecode;

/***
 * https://leetcode.com/problems/water-and-jug-problem/
 * 
 * @author weiweish
 *
 */
public class WaterJug {

    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0) return true;
        if (z > (x + y)) return false;

        int gcd = gcd(x, y);
        return gcd != 0 && (z % gcd) == 0;
    }

    private int gcd(int x, int y) {
        if (x == 0) return y;
        if (y == 0) return x;
        if (x < y) return gcd(y, x);

        while (y != 0) {
            int t = y;
            y = x % y;
            x = t;
        }

        return x;
    }

    public static void main(String[] args) {
        WaterJug c = new WaterJug();
        System.out.println(c.canMeasureWater(3, 5, 4));
        System.out.println(c.canMeasureWater(2, 6, 5));
    }

}
