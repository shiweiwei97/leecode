package leecode;

/***
 * https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 * 
 * @author weiwei
 *
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea2(int[] heights) {
        int len = heights.length, res = 0, top = -1;
        int[] stack = new int[len + 1];

        for (int i = 0; i <= len; i++) {
            // put a sentinel 0 as last bar
            int height = (i == len) ? 0 : heights[i];

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

        return res;
    }

    public int largestRectangleArea(int[] heights) {

        int len = heights.length;
        if (len == 0) return 0;

        int[] leftReach = new int[len], rightReach = new int[len];
        leftReach[0] = -1;
        rightReach[len - 1] = len;

        // left reach
        for (int i = 1; i < len; i++) {
            int s = i - 1;
            while (s >= 0 && heights[s] >= heights[i])
                s = leftReach[s];
            leftReach[i] = s;
        }

        // right reach
        for (int i = len - 2; i >= 0; i--) {
            int s = i + 1;
            while (s < len && heights[s] >= heights[i])
                s = rightReach[s];
            rightReach[i] = s;
        }

        // loop all rectangles
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++)
            res = Math.max(res, heights[i] * (rightReach[i] - leftReach[i] - 1));

        return res;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram c = new LargestRectangleInHistogram();

        System.out.println(c.largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }));
        System.out.println(c.largestRectangleArea2(new int[] { 2, 1, 5, 6, 2, 3 }));

    }

}
