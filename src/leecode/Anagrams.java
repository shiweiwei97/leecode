package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/***
 * http://oj.leetcode.com/problems/anagrams/
 * 
 * @author weiwei
 * 
 */
public class Anagrams {
    public ArrayList<String> anagrams(String[] strs) {

        ArrayList<String> result = new ArrayList<String>();

        Map<String, Integer> map = new HashMap<String, Integer>();

        for (String str : strs) {
            String arranged = arrange(str);
            if (map.containsKey(arranged)) {
                map.put(arranged, map.get(arranged).intValue() + 1);
            } else {
                map.put(arranged, 1);
            }
        }

        for (String str : strs) {
            String arranged = arrange(str);
            int count = map.get(arranged).intValue();

            if (count > 1) {
                result.add(str);
            }
        }

        return result;
    }

    private String arrange(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars, 0, chars.length);
    }

    public static void main(String[] args) {
        Anagrams c = new Anagrams();
        ArrayList<String> result = c.anagrams(new String[] { "abc", "cba", "def", "fed", "ddd", "dd" });

        System.out.println(result);
    }

}
