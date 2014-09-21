package leecode;

import java.util.ArrayList;
import java.util.List;

import leecode.common.TreeLinkNode;

/***
 * https://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * 
 * @author weiwei
 * 
 */
public class PopulateRightPointer {

    class Pair {
        TreeLinkNode cur, sibling;

        public Pair(TreeLinkNode cur, TreeLinkNode sibling) {
            this.cur = cur;
            this.sibling = sibling;
        }
    }

    public void connect(TreeLinkNode root) {

        if (root == null) {
            return;
        }

        List<Pair> stack = new ArrayList<Pair>();
        stack.add(new Pair(root, null));

        while (!stack.isEmpty()) {
            Pair p = stack.remove(stack.size() - 1);
            p.cur.next = p.sibling;
            
            if (p.cur.left == null) {
                continue;
            }

            stack.add(new Pair(p.cur.left, p.cur.right));

            if (p.sibling != null) {
                stack.add(new Pair(p.cur.right, p.sibling.left));
            } else {
                stack.add(new Pair(p.cur.right, null));
            }
        }
    }

}
