package leecode;

/***
 * http://oj.leetcode.com/problems/add-binary/
 * 
 * @author weiwei
 * 
 */
public class AddBinary {

    public String addBinary(String a, String b) {

        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        int len = Math.max(ca.length, cb.length);
        char[] c = new char[len];
        int addOne = 0;

        for (int i = 0; i < len; i++) {
            int ia = i >= ca.length ? 0 : (ca[ca.length - 1 - i] - '0');
            int ib = i >= cb.length ? 0 : (cb[cb.length - 1 - i] - '0');
            int sum = ia + ib + addOne;
            addOne = sum > 1 ? 1 : 0;
            c[len - 1 - i] = (char) ('0' + (sum % 2));
        }

        String ret = String.valueOf(c);
        if (addOne > 0) {
            ret = "1" + ret;
        }

        return ret;
    }

    public static void main(String[] args) {
        AddBinary c = new AddBinary();

        String result = c.addBinary("11", "1");
        System.out.println(result);
    }
}
