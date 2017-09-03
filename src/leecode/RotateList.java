package leecode;

import leecode.common.ListNode;

/***
 * https://leetcode.com/problems/rotate-list/description/
 * 
 * @author weiwei
 *
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {

        // get list length
        int len = 0;
        ListNode oldHead = head, prev = null, cur = head;
        while (cur != null) {
            prev = cur;
            cur = cur.next;
            len++;
        }

        // ensure k < length
        if (len == 0 || (k %= len) == 0) return head;

        // record last node
        ListNode last = prev;

        // cut the last k nodes from the list
        prev = null;
        cur = head;
        for (int i = 0; i < len - k; i++) {
            prev = cur;
            cur = cur.next;
        }
        prev.next = null;

        // link the list end back to head
        last.next = oldHead;

        return cur;
    }

    public static void main(String[] args) {

        RotateList c = new RotateList();

        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode newHead = c.rotateRight(head, 2);

        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
