package leecode;

/***
 * https://oj.leetcode.com/problems/remove-element/
 * 
 * @author weiwei
 * 
 */
public class RemoveElement {

    public int removeElement(int[] A, int elem) {
        int idx = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != elem) {
                A[idx] = A[i];
                idx++;
            }
        }

        return idx;
    }

    public static void main(String[] args) {

        RemoveElement c = new RemoveElement();

        int[] A = new int[] { 1, 2, 2, 4, 3, 2, 4 };
        int elem = 2;

        for (int a : A) {
            System.out.print(a + "\t");
        }
        System.out.println();

        int res = c.removeElement(A, elem);

        System.out.println(res);
        for (int a : A) {
            System.out.print(a + "\t");
        }
        System.out.println();
    }
}
