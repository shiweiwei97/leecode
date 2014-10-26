package leecode;

import java.util.Arrays;
import java.util.List;

/***
 * https://oj.leetcode.com/problems/generate-parentheses/
 * 
 * @author weiwei
 * 
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        String[][] res = new String[n + 1][n + 1];

        res[0][0] = "";
        for (int i = 1; i <= n; i++) {
            res[i][0] = res[i - 1][0] + "(";
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == i) {
                    String[] left = res[i][j - 1].split(",");
                    String[] cur = new String[left.length];

                    for (int k = 0; k < left.length; k++) {
                        cur[k] = left[k] + ")";
                    }

                    res[i][j] = join(cur, ",");
                } else {
                    String[] left = res[i][j - 1].split(",");
                    String[] up = res[i - 1][j].split(",");
                    String[] cur = new String[left.length + up.length];

                    for (int k = 0; k < left.length; k++) {
                        cur[k] = left[k] + ")";
                    }

                    for (int k = left.length; k < cur.length; k++) {
                        cur[k] = up[k - left.length] + "(";
                    }

                    res[i][j] = join(cur, ",");
                }
            }
        }

        return Arrays.asList(res[n][n].split(","));
    }

    private static String join(String[] s, String glue) {
        int k = s.length;
        if (k == 0) {
            return null;
        }
        StringBuilder out = new StringBuilder();
        out.append(s[0]);
        for (int x = 1; x < k; ++x) {
            out.append(glue).append(s[x]);
        }
        return out.toString();
    }

    public static void main(String[] args) {
        GenerateParentheses c = new GenerateParentheses();
        System.out.println(c.generateParenthesis(4));
    }

}
