package leecode;

import java.util.ArrayList;
import java.util.List;

import leecode.common.TreeNode;

/***
 * https://oj.leetcode.com/problems/maximum-depth-of-binary-tree/
 * @author weiwei
 *
 */
public class MaxDepth {
    class Pair {
        TreeNode node;
        int depth;

        public Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        List<Pair> stack = new ArrayList<Pair>();
        stack.add(new Pair(root, 1));

        int maxDepth = 1;
        int curDepth = 1;

        while (stack.size() > 0) {
            Pair cur = stack.remove(stack.size() - 1);
            curDepth = cur.depth;

            if (curDepth > maxDepth) {
                maxDepth = curDepth;
            }

            if (cur.node.left != null) {
                stack.add(new Pair(cur.node.left, curDepth + 1));
            }

            if (cur.node.right != null) {
                stack.add(new Pair(cur.node.right, curDepth + 1));
            }
        }

        return maxDepth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n4.left = n5;
        n5.right = n6;

        MaxDepth c = new MaxDepth();
        int max = c.maxDepth(root);
        System.out.println(max);

        root = new TreeNode(0);
        max = c.maxDepth(root);
        System.out.println(max);
    }
}
