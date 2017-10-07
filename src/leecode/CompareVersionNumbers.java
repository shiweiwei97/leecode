package leecode;

/***
 * https://leetcode.com/problems/compare-version-numbers/description/
 * 
 * @author weiwei
 *
 */
public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {

        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int len = Math.max(arr1.length, arr2.length);

        for (int i = 0; i < len; i++) {
            int v1 = i < arr1.length ? Integer.parseInt(arr1[i]) : 0;
            int v2 = i < arr2.length ? Integer.parseInt(arr2[i]) : 0;

            if (v1 != v2) return Integer.compare(v1, v2);
        }

        return 0;
    }

    public static void main(String[] args) {
        CompareVersionNumbers c = new CompareVersionNumbers();
        System.out.println(c.compareVersion("1.0", "1.1"));
        System.out.println(c.compareVersion("1.2", "1.11"));
        System.out.println(c.compareVersion("1.1", "1"));
        System.out.println(c.compareVersion("1.0", "1"));
    }
}
