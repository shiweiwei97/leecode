package leecode;

import leecode.common.TreeNode;

/***
 * https://oj.leetcode.com/problems/balanced-binary-tree/
 * 
 * @author weiwei
 * 
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) >= 0;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.left);

        if (leftHeight < 0) {
            return -1;
        }

        int rightHeight = getHeight(node.right);

        if (rightHeight < 0) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

}
