package leecode;

import leecode.common.ListNode;

/***
 * https://oj.leetcode.com/problems/swap-nodes-in-pairs/
 * 
 * @author weiwei
 * 
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = first.next;

            first.next = second.next;
            second.next = first;
            current.next = second;

            current = first;
        }

        return dummy.next;
    }
}
