package leecode;

import leecode.common.ListNode;

/***
 * 
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 * 
 * @author weiwei
 *
 */
public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        return mergeListsByRange(lists, 0, lists.length - 1);
    }

    private ListNode mergeListsByRange(ListNode[] lists, int start, int end) {
        if (start == end)
            return lists[start];

        if (start < end) {
            int mid = (start + end) / 2;
            ListNode left = mergeListsByRange(lists, start, mid);
            ListNode right = mergeListsByRange(lists, mid + 1, end);
            return mergeTwoLists(left, right);
        } else {
            return null;
        }
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode cur = head;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                cur.next = l2;
                break;
            }

            if (l2 == null) {
                cur.next = l1;
                break;
            }

            if (l1.val > l2.val) {
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }

            cur = cur.next;

        }

        return head.next;
    }

}
