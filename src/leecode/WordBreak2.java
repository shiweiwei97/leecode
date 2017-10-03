package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * https://leetcode.com/problems/word-break-ii/description/
 * 
 * @author weiwei
 *
 */
public class WordBreak2 {

    private Map<String, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        map.put("", Arrays.asList(""));

        return dfs(s, wordDict);
    }

    private List<String> dfs(String s, List<String> wordDict) {
        if (map.containsKey(s)) return map.get(s);

        List<String> res = new ArrayList<>();

        for (String word : wordDict) {
            if (!s.startsWith(word)) continue;

            List<String> subResults = dfs(s.substring(word.length()), wordDict);
            for (String result : subResults)
                res.add(word + (result.isEmpty() ? "" : " ") + result);
        }

        map.put(s, res);
        return res;
    }

    public static void main(String[] args) {
        WordBreak2 c = new WordBreak2();
        String s;
        List<String> dict;

        s = "catsanddog";
        dict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        System.out.println(c.wordBreak(s, dict));
    }
}
