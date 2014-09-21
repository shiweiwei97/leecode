package leecode;

import java.util.HashMap;
import java.util.Map;

/***
 * https://oj.leetcode.com/problems/roman-to-integer/
 * 
 * @author weiwei
 * 
 */
public class Roman2Integer {

    private static Map<Character, Integer> map = new HashMap<Character, Integer>();

    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        int res = 0;
        s = s.toUpperCase();
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                if (arr[i] == 'I' && arr[i + 1] == 'X') {
                    res += 9;
                    i++;
                } else if (arr[i] == 'I' && arr[i + 1] == 'V') {
                    res += 4;
                    i++;
                } else if (arr[i] == 'X' && arr[i + 1] == 'L') {
                    res += 40;
                    i++;
                } else if (arr[i] == 'X' && arr[i + 1] == 'C') {
                    res += 90;
                    i++;
                } else if (arr[i] == 'C' && arr[i + 1] == 'D') {
                    res += 400;
                    i++;
                } else if (arr[i] == 'C' && arr[i + 1] == 'M') {
                    res += 900;
                    i++;
                } else {
                    res += map.get(arr[i]);
                }
            } else {
                res += map.get(arr[i]);
            }
        }

        return res;
    }

    public static void main(String[] args) {

        Roman2Integer c = new Roman2Integer();
        System.out.println(c.romanToInt("XCIX"));
        System.out.println(c.romanToInt("CXCIX"));
        System.out.println(c.romanToInt("CM"));
        System.out.println(c.romanToInt("MDCCCLXXX"));
    }
}
