package leecode;

/***
 * http://oj.leetcode.com/problems/longest-common-prefix/
 * 
 * @author weiwei
 * 
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        int ret = 0;
        boolean stop = false;
        while (!stop) {
            char c = 0;
            for (String str : strs) {
                if (str.length() <= ret) {
                    stop = true;
                    break;
                }

                if (c != 0) {
                    if (c != str.charAt(ret)) {
                        stop = true;
                        break;
                    }
                }
                c = str.charAt(ret);
            }
            if (!stop) {
                ret++;
            }
        }

        return strs[0].substring(0, ret);
    }

    public static void main(String[] args) {
        LongestCommonPrefix c = new LongestCommonPrefix();
        String result = c.longestCommonPrefix(new String[] {});
        System.out.println(result);
    }
}
