package leecode;

/***
 * https://leetcode.com/problems/excel-sheet-column-title/description/
 * 
 * @author weiwei
 *
 */
public class ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        while (n > 0) {
            n--;
            res.insert(0, (char) ('A' + n % 26));
            n /= 26;
        }
        return res.toString();
    }

    public static void main(String[] args) {

        ExcelSheetColumnTitle c = new ExcelSheetColumnTitle();

        System.out.println(c.convertToTitle(1));
        System.out.println(c.convertToTitle(26));
        System.out.println(c.convertToTitle(28));
        System.out.println(c.convertToTitle(200));
    }
}
