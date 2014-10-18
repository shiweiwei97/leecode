package leecode;

import leecode.common.TreeNode;

/***
 * https://oj.leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * 
 * @author weiwei
 * 
 */
public class SortedArray2BST {

    public TreeNode sortedArrayToBST(int[] num) {
        return sortedArrayToBST(num, 0, num.length);
    }

    private TreeNode sortedArrayToBST(int[] num, int start, int end) {

        int length = end - start;
        if (length == 0) {
            return null;
        }

        if (length == 1) {
            return new TreeNode(num[start]);
        }

        int mid = start + length / 2;
        TreeNode root = new TreeNode(num[mid]);

        root.left = sortedArrayToBST(num, start, mid);
        root.right = sortedArrayToBST(num, mid + 1, end);

        return root;
    }
}
