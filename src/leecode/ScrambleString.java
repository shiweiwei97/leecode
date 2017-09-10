package leecode;

import java.util.Arrays;

public class ScrambleString {

    public boolean isScramble(String s1, String s2) {

        // fail fast for impossible cases
        if (s1 == null || s2 == null) return false;
        if (s1.equals(s2)) return true;
        if (!sorted(s1).equals(sorted(s2))) return false;

        int len = s1.length();
        for (int i = 1; i < len; i++) {
            // recursively try possible cases
            if (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i)))
                return true;

            if (isScramble(s1.substring(0, i), s2.substring(len - i))
                    && isScramble(s1.substring(i), s2.substring(0, len - i)))
                return true;
        }

        return false;
    }

    private String sorted(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }

    public static void main(String[] args) {

        ScrambleString c = new ScrambleString();
        System.out.println(c.isScramble("rgtae", "great"));
    }
}
