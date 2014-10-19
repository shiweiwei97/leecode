package leecode;

/***
 * https://oj.leetcode.com/problems/plus-one/
 * 
 * @author weiwei
 * 
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int pos = findFirstNonNine(digits);

        if (findFirstNonNine(digits) < 0) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }

        digits[pos]++;
        for (int i = digits.length - 1; i > pos; i--) {
            digits[i] = 0;
        }

        return digits;
    }

    private int findFirstNonNine(int[] digits) {
        int i = digits.length - 1;
        for (; i >= 0; i--) {
            if (digits[i] != 9) {
                break;
            }
        }
        return i;
    }
}
