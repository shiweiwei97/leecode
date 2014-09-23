package leecode;

/***
 * https://oj.leetcode.com/problems/integer-to-roman/
 * 
 * @author weiwei
 * 
 */
public class Int2Roman {

    private final static int[] rad = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    private final static String[] pattern = new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V",
            "IV", "I" };

    public String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rad.length; i++) {
            int count = num / rad[i];
            num %= rad[i];

            while (count > 0) {
                sb.append(pattern[i]);
                count--;
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {

        Int2Roman c = new Int2Roman();

        System.out.println(c.intToRoman(2800));
    }
}
