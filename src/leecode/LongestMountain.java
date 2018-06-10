package leecode;

public class LongestMountain {

    public int longestMountain(int[] A) {

        int max = 0, start = 0;

        while (start < A.length - 2) {
            int end = start;

            // move right if it keeps increasing
            while (end < A.length - 1 && A[end + 1] > A[end])
                end++;

            // break if it reaches the end of array
            if (end == A.length - 1) break;

            // restart if there is a flat or decrease
            if (A[end + 1] == A[end] || end == start) {
                start = end + 1;
                continue;
            }

            // move right if it keeps decreasing
            while (end < A.length - 1 && A[end + 1] < A[end])
                end++;
            max = Math.max(max, end - start + 1);

            // restart
            start = end;
        }

        return max;
    }

    public static void main(String[] args) {
        LongestMountain c = new LongestMountain();
        System.out.println(c.longestMountain(new int[] { 2, 1, 4, 7, 3, 2, 5 }));
        System.out.println(c.longestMountain(new int[] { 2, 2, 2 }));
    }

}
