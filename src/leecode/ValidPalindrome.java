package leecode;

/***
 * https://leetcode.com/problems/valid-palindrome/description/
 * 
 * @author weiwei
 *
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {

        if (s == null || s.length() == 0) return true;

        StringBuilder sb = new StringBuilder();
        for (char c : s.toLowerCase().toCharArray())
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) sb.append(c);
        String str = sb.toString();
        if (str.length() == 0) return true;

        char[] arr = str.toCharArray();
        int i = 0, j = arr.length - 1;
        boolean res = true;
        while (i < j && res)
            if (arr[i++] != arr[j--]) res = false;

        return res;
    }

    public static void main(String[] args) {
        ValidPalindrome c = new ValidPalindrome();
        System.out.println(c.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(c.isPalindrome("race a car"));
    }

}
