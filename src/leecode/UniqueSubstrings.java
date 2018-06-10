package leecode;

import java.util.HashSet;
import java.util.Set;

/***
 * https://leetcode.com/problems/unique-substrings-in-wraparound-string/description/
 * 
 * @author weiweish
 *
 */
public class UniqueSubstrings {

    public int findSubstringInWraproundString(String p) {

        Set<String> strings = new HashSet<>();
        char[] arr = p.toCharArray();

        for (int start = 0, i = 0; i < arr.length; i++) {
            if (i + 1 >= arr.length || arr[i + 1] != nextChar(arr[i])) {
                strings.add(p.substring(start, i + 1));
                start = i + 1;
            }
        }

        int sum = 0;
        for (String s : strings)
            sum += combinations(s.length() + 1);

        return sum;
    }

    private int combinations(int n) {
        return (n * (n - 1)) >> 1;
    }

    private char nextChar(char c) {
        if (c < 'z') return (char) (c + 1);
        return 'a';
    }

    public static void main(String[] args) {

        UniqueSubstrings c = new UniqueSubstrings();
        System.out.println(c.findSubstringInWraproundString("a"));
        System.out.println(c.findSubstringInWraproundString("cac"));
        System.out.println(c.findSubstringInWraproundString("zab"));
        System.out.println(c.findSubstringInWraproundString("zaba"));
    }

}
