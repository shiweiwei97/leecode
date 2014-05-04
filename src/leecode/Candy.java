package leecode;

/***
 * http://oj.leetcode.com/problems/candy/
 * 
 * @author weiwei
 * 
 */
public class Candy {

    public int candy(int[] ratings) {
        int n = ratings.length;

        // at least one candy per child
        int ret = n;

        // array of adjustment
        int[] cnt = new int[n];

        // scan from left
        for (int i = 0, inc = 1; i < n; i++) {
            if (i >= 1 && ratings[i] > ratings[i - 1]) {
                cnt[i] = Math.max(inc++, cnt[i]);
            } else {
                inc = 1;
            }
        }

        // scan from right
        for (int i = n - 1, inc = 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                cnt[i] = Math.max(inc++, cnt[i]);
            } else {
                inc = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            ret += cnt[i];
        }

        return ret;
    }

    public static void main(String[] args) {

        Candy c = new Candy();
        int result = c.candy(new int[] { 1, 3, 2, 4, 5 });

        System.out.println(result);
    }
}
