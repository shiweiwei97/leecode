package leecode;

/***
 * https://leetcode.com/problems/coin-change/
 * 
 * @author weiweish
 *
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        dp[0] = 0;
        for (int i = 1; i <= amount; i++)
            dp[i] = Integer.MAX_VALUE;

        for (int coin : coins) {
            // try 
            for (int i = 1; i <= amount; i++) {
                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange c = new CoinChange();
        System.out.println(c.coinChange(new int[] { 1, 2, 5 }, 11));
        System.out.println(c.coinChange(new int[] { 186, 419, 83, 408 }, 6249));
    }
}
