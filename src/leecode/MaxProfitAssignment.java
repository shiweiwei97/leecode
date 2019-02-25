package leecode;

import java.util.Arrays;

/***
 * https://leetcode.com/problems/most-profit-assigning-work/
 * 
 * @author weiweish
 *
 */
public class MaxProfitAssignment {

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        Work[] works = new Work[difficulty.length];
        for (int i = 0; i < works.length; i++) {
            works[i] = new Work(difficulty[i], profit[i]);
        }

        Arrays.sort(works);

        for (int i = 1; i < works.length; i++) {
            works[i].d = Math.min(works[i - 1].d, works[i].d);
        }

        int res = 0;
        for (int i = 0; i < worker.length; i++) {
            int cap = worker[i];
            for (int j = 0; j < works.length; j++) {
                if (cap >= works[j].d) {
                    res += works[j].p;
                    break;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        MaxProfitAssignment c = new MaxProfitAssignment();

        int[] difficulty = new int[] { 2, 4, 6, 8, 10 };
        int[] profit = new int[] { 10, 20, 30, 40, 50 };
        int[] worker = new int[] { 4, 5, 6, 7 };
        System.out.println(c.maxProfitAssignment(difficulty, profit, worker));
    }

    class Work implements Comparable<Work> {
        int d;
        int p;

        public Work(int difficulty, int profit) {
            this.d = difficulty;
            this.p = profit;
        }

        @Override
        public int compareTo(Work o) {
            return this.p > o.p ? -1 : (this.p < o.p ? 1 : 0);
        }

        @Override
        public String toString() {
            return "d=" + d + ", p=" + p + "\r\n";
        }
    }
}
