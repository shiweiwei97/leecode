package leecode;

/***
 * http://oj.leetcode.com/problems/interleaving-string/
 * 
 * @author weiwei
 * 
 */
public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[][] f = new boolean[s1.length() + 1][s2.length() + 1];

        f[0][0] = true;

        for (int i = 1; i <= s1.length(); i++) {
            f[i][0] = f[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }

        for (int i = 1; i <= s2.length(); i++) {
            f[0][i] = f[0][i - 1] && (s2.charAt(i - 1) == s3.charAt(i - 1));
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                f[i][j] = ((s1.charAt(i - 1) == s3.charAt(i + j - 1)) && f[i - 1][j])
                        || ((s2.charAt(j - 1) == s3.charAt(i + j - 1)) && f[i][j - 1]);
            }
        }

        return f[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        InterleavingString c = new InterleavingString();

        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        boolean result = c.isInterleave(s1, s2, s3);
        System.out.println(result);

        s3 = "aadbbbaccc";
        result = c.isInterleave(s1, s2, s3);
        System.out.println(result);
    }
}
