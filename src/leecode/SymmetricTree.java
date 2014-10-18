package leecode;

import java.util.Stack;

import leecode.common.TreeNode;

/***
 * https://oj.leetcode.com/problems/symmetric-tree/
 * 
 * @author weiwei
 * 
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root.left);
        stack.push(root.right);

        while (!stack.empty()) {
            TreeNode p = stack.pop();
            TreeNode q = stack.pop();

            if (p == null && q == null) {
                continue;
            }
            if (p == null || q == null) {
                return false;
            }

            if (p.val != q.val) {
                return false;
            }

            stack.push(p.left);
            stack.push(q.right);

            stack.push(p.right);
            stack.push(q.left);
        }

        return true;
    }
}
