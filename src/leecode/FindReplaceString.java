package leecode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/***
 * https://leetcode.com/problems/find-and-replace-in-string/
 * @author weiweish
 *
 */
public class FindReplaceString {

    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {

        Map<Integer, String> sourceMap = new HashMap<>();
        Map<Integer, String> targetMap = new HashMap<>();
        for (int i = 0; i < indexes.length; i++) {
            sourceMap.put(indexes[i], sources[i]);
            targetMap.put(indexes[i], targets[i]);
        }

        Arrays.sort(indexes);

        StringBuilder sb = new StringBuilder();
        int lastIndex = 0;

        for (int i = 0; i < indexes.length; i++) {
            int index = indexes[i];
            String source = sourceMap.get(index);
            String target = targetMap.get(index);

            // last matched
            sb.append(S.substring(lastIndex, indexes[i]));

            if (S.substring(index, index + source.length()).equals(source)) {
                sb.append(target);
            } else {
                sb.append(S.substring(index, index + source.length()));
            }

            // update last matched position
            lastIndex = index + source.length();
        }

        if (lastIndex < S.length()) {
            sb.append(S.substring(lastIndex, S.length()));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        FindReplaceString c = new FindReplaceString();
        System.out.println(c.findReplaceString("abcd", new int[] { 0, 2 }, new String[] { "a", "cd" },
                new String[] { "eee", "ffff" }));
        System.out.println(c.findReplaceString("abcd", new int[] { 0, 2 }, new String[] { "ab", "ec" },
                new String[] { "eee", "ffff" }));
    }

}
