package leecode;

import java.util.HashSet;
import java.util.Set;

/***
 * http://oj.leetcode.com/problems/word-break/
 * 
 * @author weiwei
 * 
 */
public class WordBreak {

    public boolean wordBreak(String s, Set<String> dict) {

        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;

        for (int i = 1; i < f.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (f[j] && dict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];
    }

    public static void main(String[] args) {

        WordBreak c = new WordBreak();
        String s = "leetcode";
        Set<String> dict = new HashSet<String>();
        dict.add("leet");
        dict.add("code");

        boolean result = c.wordBreak(s, dict);
        System.out.println(result);
    }
}
