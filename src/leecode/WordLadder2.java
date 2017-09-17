package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/***
 * https://leetcode.com/problems/word-ladder-ii/description/
 * 
 * @author weiwei
 *
 */
public class WordLadder2 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> res = new ArrayList<>();

        // impossible case
        if (!wordList.contains(endWord)) return res;

        // initialize beginSet and endSet
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>(), wordDict = new HashSet<>(wordList);
        beginSet.add(beginWord);
        endSet.add(endWord);

        // map of current word -> next word
        Map<String, List<String>> map = new HashMap<>();

        // 2 end BFS
        bfs(wordDict, beginSet, endSet, map, false /* flip */);

        // recursively generate results from map
        List<String> curList = new ArrayList<>(Arrays.asList(beginWord));
        generateResult(beginWord, endWord, map, curList, res);

        return res;
    }

    private void bfs(Set<String> wordDict, Set<String> beginSet, Set<String> endSet, Map<String, List<String>> map,
            boolean flip) {

        // find next level from smaller set
        if (beginSet.size() > endSet.size()) {
            bfs(wordDict, endSet, beginSet, map, !flip);
            return;
        }

        // no solution
        if (beginSet.isEmpty()) return;

        // remove used words from dictionary
        wordDict.removeAll(beginSet);
        wordDict.removeAll(endSet);

        boolean found = false;
        Set<String> newBeginSet = new HashSet<>();

        for (String word : beginSet) {
            for (int i = 0; i < word.length(); i++) {
                char[] chars = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {

                    // change one letter at a time
                    chars[i] = c;
                    String newWord = new String(chars);

                    // found a solution
                    if (endSet.contains(newWord)) {
                        found = true;
                        buildMap(map, word, newWord, flip);
                    }

                    // continue searching
                    if (!found && wordDict.contains(newWord)) {
                        newBeginSet.add(newWord);
                        buildMap(map, word, newWord, flip);
                    }
                }
            }
        }

        if (found) return;

        bfs(wordDict, newBeginSet, endSet, map, flip);
    }

    private void buildMap(Map<String, List<String>> map, String word, String newWord, boolean flip) {
        // make sure map is in correct direction
        String key = flip ? newWord : word;
        String val = flip ? word : newWord;

        List<String> list = map.containsKey(key) ? map.get(key) : new ArrayList<>();
        list.add(val);
        map.put(key, list);
    }

    private void generateResult(String beginWord, String endWord, Map<String, List<String>> map, List<String> curList,
            List<List<String>> res) {

        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(curList));
            return;
        }

        if (!map.containsKey(beginWord)) return;

        for (String word : map.get(beginWord)) {
            curList.add(word);
            generateResult(word, endWord, map, curList, res);
            curList.remove(curList.size() - 1);
        }
    }

    public static void main(String[] args) {
        WordLadder2 c = new WordLadder2();
        String beginWord, endWord;
        List<String> wordList;

        beginWord = "hit";
        endWord = "cog";
        wordList = Arrays.asList(new String[] { "hot", "dot", "dog", "lot", "log", "cog" });
        System.out.println(c.findLadders(beginWord, endWord, wordList));

        beginWord = "hot";
        endWord = "dog";
        wordList = Arrays.asList(new String[] { "hot", "dog" });
        System.out.println(c.findLadders(beginWord, endWord, wordList));

        beginWord = "hit";
        endWord = "cog";
        wordList = Arrays.asList(new String[] { "hot", "dot", "dog", "lot", "log" });
        System.out.println(c.findLadders(beginWord, endWord, wordList));

        beginWord = "qa";
        endWord = "sq";
        wordList = Arrays.asList(new String[] { "si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln",
                "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya",
                "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr",
                "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di",
                "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi",
                "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye" });
        System.out.println(c.findLadders(beginWord, endWord, wordList));
    }
}
