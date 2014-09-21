package leecode;

import leecode.common.ListNode;

/***
 * https://oj.leetcode.com/problems/linked-list-cycle/
 * 
 * @author weiwei
 * 
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        ListNode p = new ListNode(0);
        p.next = head;

        ListNode q = new ListNode(0);
        q.next = head;

        while (p != null && q != null && p != q) {
            p = p.next;
            q = q.next;
            if (q != null) {
                q = q.next;
            }

            if (p == q && p != null && q != null) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
