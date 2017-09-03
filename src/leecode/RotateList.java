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
        ListNode node = head;
        for (; node != null; node = node.next)
            len++;

        if (len == 0) return head;

        // ensure k < length
        k %= len;
        if (k == 0) return head;

        // cut the last k nodes from the list
        ListNode oldHead = head, prev = null, cur = head;
        for (int i = 0; i < len - k; i++) {
            prev = cur;
            cur = cur.next;
        }
        prev.next = null;

        ListNode ret = cur;

        // link the list end back to head
        while (cur.next != null)
            cur = cur.next;
        cur.next = oldHead;

        return ret;
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
