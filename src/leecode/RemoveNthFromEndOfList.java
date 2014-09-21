package leecode;

import leecode.common.ListNode;

/***
 * http://oj.leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 
 * @author weiwei
 * 
 */
public class RemoveNthFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ret = new ListNode(0);
        ret.next = head;
        ListNode p = ret;
        ListNode q = ret;

        for (int i = 0; i < n; i++) {
            if (p != null) {
                p = p.next;
            } else {
                return null;
            }
        }

        while (p.next != null) {
            p = p.next;
            q = q.next;
        }

        // remove q.next
        q.next = q.next.next;

        return ret.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        RemoveNthFromEndOfList c = new RemoveNthFromEndOfList();
        ListNode result = c.removeNthFromEnd(n1, 2);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}
