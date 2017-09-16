package leecode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/***
 * https://leetcode.com/problems/word-ladder/description/
 * 
 * @author weiwei
 *
 */
public class WordLadder {

    // 2-end BFS
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {

        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>(), wordDict = new HashSet<>(wordList);

        if (!wordDict.contains(endWord)) return 0;

        // start from 2 ends
        beginSet.add(beginWord);
        endSet.add(endWord);
        int distance = 2;

        // BFS
        while (!endSet.isEmpty() && !beginSet.isEmpty()) {

            // all possible visited words at next step
            Set<String> newBeginSet = new HashSet<>();

            for (String word : beginSet) {

                for (int i = 0; i < word.length(); i++) {
                    char[] arr = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {

                        // change one letter at a time
                        arr[i] = c;
                        String newWord = new String(arr);

                        // found endWord
                        if (endSet.contains(newWord)) return distance;

                        // found a valid word, continue
                        if (wordDict.contains(newWord)) {
                            newBeginSet.add(newWord);
                            wordDict.remove(newWord);
                        }
                    }
                }
            }

            if (newBeginSet.size() > endSet.size()) {
                beginSet = endSet;
                endSet = newBeginSet;
            } else {
                beginSet = newBeginSet;
            }

            distance++;
        }

        return 0;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> visited = new HashSet<>();
        Set<String> wordDict = new HashSet<>(wordList);

        // start from beginWord
        visited.add(beginWord);
        int distance = 1;

        // BFS until endWord is found
        while (!visited.contains(endWord) && !visited.isEmpty()) {

            // all possible visited words at next step
            Set<String> newVisited = new HashSet<>();

            for (String word : visited) {

                for (int i = 0; i < word.length(); i++) {
                    char[] arr = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {

                        // change one letter at a time
                        arr[i] = c;
                        String newWord = new String(arr);

                        // found a valid word in dictionary
                        if (wordDict.contains(newWord)) {
                            newVisited.add(newWord);

                            // this word won't be used
                            wordDict.remove(newWord);
                        }
                    }
                }
            }

            visited = newVisited;
            distance = newVisited.isEmpty() ? 0 : distance + 1;
        }

        return distance;
    }

    public static void main(String[] args) {

        WordLadder c = new WordLadder();
        String beginWord, endWord;
        List<String> wordList;

        beginWord = "hot";
        endWord = "dog";
        wordList = Arrays.asList(new String[] { "hot", "dog" });
        System.out.println(c.ladderLength2(beginWord, endWord, wordList));

        beginWord = "hit";
        endWord = "cog";
        wordList = Arrays.asList(new String[] { "hot", "dot", "dog", "lot", "log", "cog" });
        System.out.println(c.ladderLength2(beginWord, endWord, wordList));

        beginWord = "hit";
        endWord = "cog";
        wordList = Arrays.asList(new String[] { "hot", "dot", "dog", "lot", "log" });
        System.out.println(c.ladderLength2(beginWord, endWord, wordList));

        beginWord = "qa";
        endWord = "sq";
        wordList = Arrays.asList(new String[] { "si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln",
                "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya",
                "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr",
                "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di",
                "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi",
                "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye" });
        System.out.println(c.ladderLength2(beginWord, endWord, wordList));

    }
}
