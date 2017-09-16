package leecode;

import leecode.common.TreeNode;

/***
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 * 
 * @author weiwei
 *
 */
public class BinaryTreeMaxPathSum {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        traverse(root);
        return max;
    }

    private int traverse(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, traverse(root.left));
        int right = Math.max(0, traverse(root.right));
        max = Math.max(max, root.val + left + right);
        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        BinaryTreeMaxPathSum c = new BinaryTreeMaxPathSum();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;

        System.out.println(c.maxPathSum(root));
    }

}
