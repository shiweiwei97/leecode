package leecode;

import java.util.ArrayList;
import java.util.List;

/***
 * https://oj.leetcode.com/problems/same-tree/
 * 
 * @author weiwei
 * 
 */
public class SameTrue {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        List<TreeNode> pStack = new ArrayList<TreeNode>();
        List<TreeNode> qStack = new ArrayList<TreeNode>();

        pStack.add(p);
        qStack.add(q);

        TreeNode pCur;
        TreeNode qCur;

        while (pStack.size() > 0 && qStack.size() > 0) {
            pCur = pStack.remove(pStack.size() - 1);
            qCur = qStack.remove(qStack.size() - 1);

            if (pCur != null && qCur == null) {
                return false;
            }

            if (pCur == null && qCur != null) {
                return false;
            }

            if (pCur != null && qCur != null && pCur.val != qCur.val) {
                return false;
            }

            if (pCur != null) {
                pStack.add(pCur.left);
            }

            if (pCur != null) {
                pStack.add(pCur.right);
            }

            if (qCur != null) {
                qStack.add(qCur.left);
            }

            if (qCur != null) {
                qStack.add(qCur.right);
            }
        }

        return true;

    }

    public static void main(String[] args) {

        TreeNode p = new TreeNode(0);
        TreeNode p1 = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        TreeNode p4 = new TreeNode(4);
        TreeNode p5 = new TreeNode(5);
        TreeNode p6 = new TreeNode(6);

        p.left = p1;
        p.right = p2;
        p1.left = p3;
        p1.right = p4;
        p4.left = p5;
        p5.right = p6;

        TreeNode q = new TreeNode(0);
        TreeNode q1 = new TreeNode(1);
        TreeNode q2 = new TreeNode(2);
        TreeNode q3 = new TreeNode(3);
        TreeNode q4 = new TreeNode(4);
        TreeNode q5 = new TreeNode(5);
        TreeNode q6 = new TreeNode(6);

        q.left = q1;
        q.right = q2;
        q1.left = q3;
        q1.right = q4;
        q4.left = q5;
        q5.right = q6;

        SameTrue c = new SameTrue();
        boolean same = c.isSameTree(p, q);

        System.out.println(same);
    }
}
