package leecode;

import java.util.ArrayList;
import java.util.List;

/***
 * https://oj.leetcode.com/problems/gray-code/
 * 
 * @author weiwei
 * 
 */
public class GrayCode {

    public List<Integer> grayCode(int n) {

        List<Integer> result = new ArrayList<Integer>();
        result.add(0);

        for (int i = 0; i < n; i++) {
            int high = 1 << i;
            for (int j = result.size() - 1; j >= 0; j--) {
                result.add(high | result.get(j));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        GrayCode c = new GrayCode();
        System.out.println(c.grayCode(1));
    }
}
