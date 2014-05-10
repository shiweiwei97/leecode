package leecode;

/***
 * http://oj.leetcode.com/problems/implement-strstr/
 * 
 * @author weiwei
 * 
 */
public class StrStr {
    public String strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return null;
        }

        if (needle.length() == 0) {
            return haystack;
        }

        if (needle.length() == haystack.length()) {
            return needle.equals(haystack) ? haystack : null;
        }

        for (int i = 0; i < haystack.length() - needle.length(); i++) {
            boolean diff = false;
            for (int j = 0; j < needle.length(); j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    diff = true;
                    break;
                }
            }

            if (!diff) {
                return haystack.substring(i);
            }
        }

        return null;
    }

    public static void main(String[] args) {

        String haystack = "a";
        String needle = "a";
        StrStr c = new StrStr();

        String result = c.strStr(haystack, needle);
        System.out.println(result);
    }
}
