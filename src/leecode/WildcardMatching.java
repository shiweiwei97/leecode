package leecode;

/***
 * https://leetcode.com/problems/wildcard-matching/description/
 * 
 * @author weiwei
 *
 */
public class WildcardMatching {

    public static boolean isMatch(String s, String p) {

        int ss = 0, pp = 0, starIdx = -1, matchIdx = 0;
        while (ss < s.length()) {
            // same character or ?, advance one step
            if (pp < p.length() && (s.charAt(ss) == p.charAt(pp) || p.charAt(pp) == '?')) {
                ss++;
                pp++;
            }
            // found *, only advance pattern pointer, remember match index
            else if (pp < p.length() && p.charAt(pp) == '*') {
                starIdx = pp;
                matchIdx = ss;
                pp++;
            }
            // go back to last matched *
            else if (starIdx != -1) {
                pp = starIdx + 1;
                matchIdx++;
                ss = matchIdx;
            } else {
                return false;
            }
        }

        // finish the remain * in the pattern
        while (pp < p.length() && p.charAt(pp) == '*')
            pp++;

        return pp == p.length();
    }

    public static void main(String[] args) {

        System.out.println(isMatch("aa", "a")); // false
        System.out.println(isMatch("aa", "aa")); // true
        System.out.println(isMatch("aaa", "aa")); // false
        System.out.println(isMatch("aa", "*")); // true
        System.out.println(isMatch("aa", "a*")); // true
        System.out.println(isMatch("ab", "?*")); // true
        System.out.println(isMatch("aab", "c*a*b")); // false
    }
}
