package leecode;

/***
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 * 
 * @author weiwei
 *
 */
public class BestTimeBuySellStock3 {

    public int maxProfit(int[] prices) {
        int sell1 = 0, sell2 = 0, buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        for (int price : prices) {
            buy1 = Math.max(buy1, -price);
            sell1 = Math.max(sell1, buy1 + price);
            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, buy2 + price);
        }
        return sell2;
    }

    public static void main(String[] args) {
        BestTimeBuySellStock3 c = new BestTimeBuySellStock3();
        System.out.println(c.maxProfit(new int[] { 1, 2, 3, 4, 5 }));
        System.out.println(c.maxProfit(new int[] { 5, 4, 3, 2, 1 }));
        System.out.println(c.maxProfit(new int[] { 1, 5, 4, 2, 3 }));
    }
}