package leecode;

import java.util.Arrays;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {

        int[] res = new int[temperatures.length], map = new int[101];

        for (int i = temperatures.length - 1; i >= 0; i--) {
            map[temperatures[i]] = i;

            int min = 30001;// upper bound
            for (int j = temperatures[i] + 1; j <= 100; j++) {
                if (map[j] != 0) min = Math.min(min, map[j]);
            }

            res[i] = min == 30001 ? 0 : min - i;
        }

        return res;
    }

    public static void main(String[] args) {
        DailyTemperatures c = new DailyTemperatures();

        int[] ts = new int[] { 73, 74, 75, 71, 69, 72, 76, 73 };
        System.out.println(Arrays.toString(c.dailyTemperatures(ts)));

        ts = new int[] { 1, 1, 2, 3, 1, 1 };
        System.out.println(Arrays.toString(c.dailyTemperatures(ts)));
    }

}
