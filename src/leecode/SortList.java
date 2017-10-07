package leecode;

import leecode.common.ListNode;

/***
 * https://leetcode.com/problems/sort-list/description/
 * 
 * @author weiwei
 *
 */
public class SortList {

    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) return head;

        // find the middle of the list
        ListNode prev = null, p1 = head, p2 = head;
        while (p2 != null && p2.next != null) {
            prev = p1;
            p1 = p1.next;
            p2 = p2.next.next;
        }

        // cut the list
        prev.next = null;

        // sort 2 lists recursively
        ListNode h1 = sortList(head);
        ListNode h2 = sortList(p1);

        // merge sorted list
        return merge(h1, h2);
    }

    private ListNode merge(ListNode h1, ListNode h2) {

        ListNode head = new ListNode(0);
        ListNode p = head;

        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                p.next = h1;
                h1 = h1.next;
            } else {
                p.next = h2;
                h2 = h2.next;
            }
            p = p.next;
        }

        if (h1 != null) p.next = h1;
        if (h2 != null) p.next = h2;

        return head.next;
    }
}
