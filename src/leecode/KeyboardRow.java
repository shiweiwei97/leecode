package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * https://leetcode.com/problems/keyboard-row/
 * 
 * @author weiweish
 *
 */
public class KeyboardRow {

    public String[] findWords(String[] words) {
        List<String> res = new ArrayList<>();

        for (String word : words) {
            if (isOneRow(word)) {
                res.add(word);
            }
        }

        return res.toArray(new String[] {});
    }

    private boolean isOneRow(String word) {
        word = word.toLowerCase();
        String[] rows = new String[] { "qwertyuiop", "asdfghkjkl", "zxcvbnm" };

        char c = word.charAt(0);
        String row = null;
        for (int i = 0; i < 3; i++) {
            if (rows[i].indexOf(c) >= 0) {
                row = rows[i];
                break;
            }
        }

        for (int i = 0; i < word.length(); i++) {
            if (row.indexOf(word.charAt(i)) < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        KeyboardRow c = new KeyboardRow();

        System.out.println(Arrays.toString(c.findWords(new String[] { "Hello", "Alaska", "Dad", "Peace" })));
    }

}
