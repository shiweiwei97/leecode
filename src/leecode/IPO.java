package leecode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/***
 * https://leetcode.com/problems/ipo/
 * 
 * @author weiweish
 *
 */
public class IPO {

    class Project {
        int profit;
        int capital;
        boolean used;

        public Project(int profit, int capital, boolean used) {
            this.profit = profit;
            this.capital = capital;
            this.used = used;
        }

        @Override
        public String toString() {
            return "profit=" + profit + ", capital=" + capital + ", used=" + used + System.lineSeparator();
        }
    }

    /***
     * https://leetcode.com/problems/ipo/discuss/255679/Java-Short-Solution-!!!
     * 
     * @param k
     * @param W
     * @param Profits
     * @param Capital
     * @return
     */
    public int findMaximizedCapital2(int k, int W, int[] Profits, int[] Capital) {

        PriorityQueue<int[]> pqCap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < Profits.length; i++)
            pqCap.offer(new int[] { Capital[i], Profits[i] });

        PriorityQueue<Integer> pqPro = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int i = 0; i < k; i++) {
            while (!pqCap.isEmpty() && pqCap.peek()[0] <= W) {
                pqPro.offer(pqCap.poll()[1]);
            }

            if (pqPro.isEmpty()) break;
            W += pqPro.poll();
        }

        return W;
    }

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {

        Project[] projects = new Project[Profits.length];
        for (int i = 0; i < projects.length; i++) {
            projects[i] = new Project(Profits[i], Capital[i], false);
        }

        Arrays.sort(projects, new Comparator<Project>() {
            @Override
            public int compare(Project o1, Project o2) {
                return o1.profit > o2.profit ? -1 : (o1.profit < o2.profit ? 1 : 0);
            }
        });

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < projects.length; j++) {
                Project p = projects[j];
                if (p.used || p.capital > W) continue;

                W += p.profit;
                p.used = true;

                break;
            }
        }

        return W;
    }

    public static void main(String[] args) {
        IPO c = new IPO();

        System.out.println(c.findMaximizedCapital(2, 0, new int[] { 1, 2, 3 }, new int[] { 0, 1, 1 }));

        System.out.println(c.findMaximizedCapital2(2, 0, new int[] { 1, 2, 3 }, new int[] { 0, 1, 1 }));
    }
}
