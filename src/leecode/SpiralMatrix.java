package leecode;

import java.util.ArrayList;
import java.util.List;

/***
 * https://leetcode.com/problems/spiral-matrix/description/
 * 
 * @author weiwei
 *
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<Integer>();
        int m = matrix.length;
        if (m == 0) return res;

        int n = matrix[0].length;
        if (n == 0) return res;

        int dx = 1, dy = 0, wx = n, wy = m - 1, x = -1, y = 0;

        while ((dx != 0 && wx > 0) || (dy != 0 && wy > 0)) {
            // move horizontally
            if (dx != 0) {
                for (int i = 0; i < wx; i++) {
                    x += dx;
                    res.add(matrix[y][x]);
                }

                // change direction
                dy = dx;
                dx = 0;
                wx--;
            }
            // move vertically
            else {
                for (int i = 0; i < wy; i++) {
                    y += dy;
                    res.add(matrix[y][x]);
                }

                // change direction
                dx = -dy;
                dy = 0;
                wy--;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        SpiralMatrix c = new SpiralMatrix();
        int[][] m = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(c.spiralOrder(m));
    }

}
