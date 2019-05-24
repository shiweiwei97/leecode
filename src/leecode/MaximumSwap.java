package leecode;

/***
 * https://leetcode.com/problems/maximum-swap/
 * 
 * @author weiweish
 *
 */
public class MaximumSwap {

    private int maximumSwap(int num) {

        int max = num;

        for (char c = '9'; c >= '0'; c--) {
            String s = String.valueOf(num);
            char[] arr = s.toCharArray();
            int idx = s.lastIndexOf(c);

            if (idx < 0) continue;

            int target = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < c) {
                    target = i;
                    break;
                }
            }

            if (idx > target) {
                char temp = arr[idx];
                arr[idx] = arr[target];
                arr[target] = temp;

                max = Math.max(max, Integer.valueOf(new String(arr)));
            }

        }

        return max;
    }

    public static void main(String[] args) {
        MaximumSwap c = new MaximumSwap();
        System.out.println(c.maximumSwap(83265863));
        System.out.println(c.maximumSwap(87654321));
        System.out.println(c.maximumSwap(888326707));
    }
}
