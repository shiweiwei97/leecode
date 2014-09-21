package leecode;

import leecode.common.ListNode;

/***
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/
 * 
 * @author weiwei
 * 
 */
public class RemoveDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            ListNode next = cur;
            while (next.next != null && next.next.val == cur.val) {
                next = next.next;
            }

            cur.next = next.next;
            cur = cur.next;
        }

        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicates c = new RemoveDuplicates();

        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        head.next = n1;

        c.deleteDuplicates(head);
    }
}
