package leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/***
 * https://leetcode.com/problems/repeated-dna-sequences/description/
 * 
 * @author weiweish
 *
 */
public class RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {

        // Bit map for A,C,G and T
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        Set<Integer> words = new HashSet<>();
        Set<Integer> dupWords = new HashSet<>();
        List<String> res = new ArrayList<>();

        for (int i = 0; i < s.length() - 9; i++) {

            // encode s(i, i+10) into an integer
            int w = 0;
            for (int j = 0; j < 10; j++) {
                char c = s.charAt(i + j);
                w <<= 2;
                if (map.containsKey(c)) w |= map.get(c);
            }

            // first time in the dupWords set
            if (!words.add(w) && dupWords.add(w)) {
                res.add(s.substring(i, i + 10));
            }
        }

        return res;
    }

    public static void main(String[] args) {

        RepeatedDNASequences c = new RepeatedDNASequences();

        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";

        System.out.println(c.findRepeatedDnaSequences(s));
    }
}
