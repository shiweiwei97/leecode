package leecode;

import leecode.common.TreeNode;

/***
 * https://leetcode.com/problems/sum-of-left-leaves/description/
 * 
 * @author weiweish
 *
 */
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;

        // no left node
        if (root.left == null) return sumOfLeftLeaves(root.right);

        // left node is leave node
        if (root.left.left == null && root.left.right == null) return root.left.val + sumOfLeftLeaves(root.right);

        // no left leaves, recursive call sumOfLeftLeaves
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
