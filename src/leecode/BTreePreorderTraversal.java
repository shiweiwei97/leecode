package leecode;

import java.util.ArrayList;
import java.util.List;

import leecode.common.TreeNode;

/***
 * https://oj.leetcode.com/problems/binary-tree-preorder-traversal/
 * 
 * @author weiwei
 * 
 */
public class BTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        if (root == null) {
            return res;
        }

        List<TreeNode> stack = new ArrayList<TreeNode>();
        stack.add(root);

        while (!stack.isEmpty()) {

            TreeNode cur = stack.remove(stack.size() - 1);
            res.add(cur.val);

            if (cur.right != null) {
                stack.add(cur.right);
            }

            if (cur.left != null) {
                stack.add(cur.left);
            }
        }

        return res;
    }

}
