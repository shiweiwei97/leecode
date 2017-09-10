package leecode;

/***
 * https://leetcode.com/problems/maximal-rectangle/description/
 * 
 * @author weiwei
 *
 */
public class MaxRectangle {

    public int maximalRectangle(char[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int m = matrix.length, len = matrix[0].length, res = 0;
        int[] heights = new int[len];

        // based on the largest rectangle in histogram, check row by row
        // if hit a zero, set height to 0, otherwise keep increasing height
        for (int r = 0; r < m; r++) {
            int top = -1;
            int[] stack = new int[len + 1];

            for (int i = 0; i <= len; i++) {
                int height;

                // populate heights array
                if (i < len) {
                    if (matrix[r][i] == '0') heights[i] = 0;
                    else heights[i]++;
                    height = heights[i];
                } else {
                    height = 0;
                }

                // pop stack while stack top > heights[i]
                while (top != -1 && height < heights[stack[top]]) {
                    // height and width
                    int hh = heights[stack[top--]];
                    int width = (top == -1) ? i : i - 1 - stack[top];
                    res = Math.max(res, hh * width);
                }

                // now stack top <= heights[i]
                stack[++top] = i;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        MaxRectangle c = new MaxRectangle();

        char[][] matrix = new char[][] {

                "10100".toCharArray(),

                "10111".toCharArray(),

                "11111".toCharArray(),

                "10010".toCharArray()

        };

        System.out.println(c.maximalRectangle(matrix));
    }
}
