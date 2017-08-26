package leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/
 * 
 * @author weiwei
 *
 */
public class SubstringWithConcatenationAllWords {

	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<Integer>();

		if (words.length < 1)
			return result;

		int len = words[0].length() * words.length;
		if (s.length() < len)
			return result;

		// pre-compute map of word => count
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String word : words) {
			if (map.containsKey(word)) {
				map.put(word, map.get(word) + 1);
			} else {
				map.put(word, 1);
			}
		}

		for (int i = 0; i <= s.length() - len; i++) {
			Map<String, Integer> copyMap = new HashMap<String, Integer>(map);
			if (match(s.substring(i, i + len), words, copyMap)) {
				result.add(i);
			}
		}

		return result;
	}

	private boolean match(String s, String[] words, Map<String, Integer> map) {

		int step = words[0].length();
		int len = step * words.length;
		if (s.length() != len)
			return false;

		for (int i = 0; i < s.length(); i += step) {
			String word = s.substring(i, i + step);

			if (map.containsKey(word)) {
				// reduce count or remove entry if a word is found
				int newVal = map.get(word) - 1;
				if (newVal > 0) {
					map.put(word, newVal);
				} else {
					map.remove(word);
				}
			} else {
				// not a match
				break;
			}
		}

		// map is empty if every word is used
		return map.isEmpty();
	}

	public static void main(String[] args) {

		SubstringWithConcatenationAllWords c = new SubstringWithConcatenationAllWords();

		String s;
		String[] words;

		s = "wordgoodgoodgoodbestword";
		words = new String[] { "word", "good", "best", "good" };
		System.out.println(c.findSubstring(s, words));

		s = "barfoothefoobarman";
		words = new String[] { "foo", "bar" };
		System.out.println(c.findSubstring(s, words));
	}
}
