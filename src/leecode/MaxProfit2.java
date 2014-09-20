package leecode;

/***
 * https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 
 * @author weiwei
 * 
 */
public class MaxProfit2 {

    public int maxProfit(int[] prices) {

        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            res += prices[i] > prices[i - 1] ? prices[i] - prices[i - 1] : 0;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = new int[] { 2, 1, 3, 4, 5, 2, 6 };

        MaxProfit2 c = new MaxProfit2();
        System.out.println(c.maxProfit(prices));
    }
}
