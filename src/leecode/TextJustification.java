package leecode;

import java.util.ArrayList;
import java.util.List;

/***
 * https://leetcode.com/problems/text-justification/description/
 * 
 * @author weiwei
 *
 */
public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {

        // build lines of words and record the count of missing spaces
        List<List<String>> lines = new ArrayList<>();
        List<String> tempLine = new ArrayList<>();
        List<Integer> spaces = new ArrayList<>();

        int sumLength = 0, lastStop = 0;
        for (int i = 0; i < words.length; i++) {

            // generate one line words list
            if (sumLength + words[i].length() + i - lastStop > maxWidth) {
                // start a new line
                if (tempLine.size() > 0) {
                    lines.add(tempLine);
                    spaces.add(maxWidth - sumLength);
                }
                tempLine = new ArrayList<>();

                lastStop = i;
                sumLength = 0;
                i--;
                continue;
            } else {
                tempLine.add(words[i]);
                sumLength += words[i].length();
            }
        }
        if (tempLine.size() > 0) {
            lines.add(tempLine);
            spaces.add(maxWidth - sumLength);
        }

        System.out.println(lines);
        System.out.println(spaces);

        // fill the spaces
        List<String> res = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            int spaceCnt = spaces.get(i);
            List<String> line = lines.get(i);

            if (i == lines.size() - 1) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < line.size(); j++) {
                    sb.append(line.get(j));
                    if (j != line.size() - 1) sb.append(" ");
                }

                res.add(pad(sb.toString(), maxWidth - sb.length()));
            } else {

                if (line.size() == 1) {
                    res.add(pad(line.get(0), spaceCnt));
                } else {
                    int avg = spaceCnt / (line.size() - 1);
                    int rem = spaceCnt % (line.size() - 1);
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < line.size(); j++) {
                        if (j == line.size() - 1) sb.append(line.get(j));
                        else if (j < rem) {
                            sb.append(pad(line.get(j), avg + 1));
                        } else {
                            sb.append(pad(line.get(j), avg));
                        }
                    }
                    res.add(sb.toString());
                }
            }
        }

        return res;
    }

    private String pad(String s, int cnt) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < cnt; i++)
            sb.append(" ");
        return sb.toString();
    }

    public static void main(String[] args) {

        TextJustification c = new TextJustification();
        String[] words;
        int len;

        words = new String[] { "What", "must", "be", "shall", "be." };
        len = 12;
        System.out.println(c.fullJustify(words, len));
    }

}
