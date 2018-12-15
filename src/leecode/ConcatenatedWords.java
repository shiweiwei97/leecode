package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/***
 * https://leetcode.com/problems/concatenated-words/description/
 * 
 * @author weiweish
 *
 */
public class ConcatenatedWords {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String w1, String w2) {
                return w1.length() < w2.length() ? 1 : (w1.length() > w2.length() ? -1 : 0);
            }
        });

        Set<String> dict = new HashSet<>();
        for (String w : words)
            dict.add(w);

        List<String> results = new ArrayList<>();

        for (String w : words) {
            dict.remove(w);
            if (w.length() == 0) continue;

            if (wordBreak(w, dict)) results.add(w);
        }

        return results;
    }

    private boolean wordBreak(String s, Set<String> dict) {

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
        ConcatenatedWords c = new ConcatenatedWords();

        System.out.println(c.findAllConcatenatedWordsInADict(new String[] { "cat", "cats", "catsdogcats", "dog",
                "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat" }));

    }
}
