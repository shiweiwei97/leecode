package leecode;

import java.util.ArrayList;
import java.util.List;

import leecode.common.TreeNode;

/***
 * https://oj.leetcode.com/problems/binary-tree-inorder-traversal/
 * 
 * @author weiwei
 * 
 */
public class BTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        List<TreeNode> stack = new ArrayList<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                root = stack.remove(stack.size() - 1);
                res.add(root.val);
                root = root.right;
            }
        }

        return res;
    }

}
