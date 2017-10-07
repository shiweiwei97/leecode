package leecode;

/***
 * https://leetcode.com/problems/reverse-words-in-a-string/description/
 * 
 * @author weiwei
 *
 */
public class ReverseWordsInString {

    public String reverseWords(String s) {

        if (s == null || s.length() == 0) return s;

        char[] arr = s.toCharArray();
        int n = arr.length;

        // reverse the whole string
        reverse(arr, 0, n - 1);

        // clean spaces and reverse words
        int i = 0, j = 0;
        while (j < n) {
            
            // find first non space
            while (j < n && arr[j] == ' ') j++;

            // keep copy non spaces
            int start = i;
            while (j < n && arr[j] != ' ') arr[i++] = arr[j++];
            
            // reverse word
            reverse(arr, start, i - 1);

            // find next non space and only keep one space between words
            while (j < n && arr[j] == ' ') j++;
            if (j < n) arr[i++] = ' ';
        }

        return new String(arr).substring(0, i);
    }

    private void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char t = arr[i];
            arr[i++] = arr[j];
            arr[j--] = t;
        }
    }

    public static void main(String[] args) {
        ReverseWordsInString c = new ReverseWordsInString();
        System.out.println(c.reverseWords("  the sky  is  blue  "));
    }

}
