package leecode;

import java.util.Stack;

import leecode.common.ListNode;

/***
 * https://leetcode.com/problems/reorder-list/description/
 * 
 * @author weiwei
 *
 */
public class ReorderList {

    public void reorderList(ListNode head) {

        if (head == null || head.next == null) return;

        Stack<ListNode> stack = new Stack<>();
        for (ListNode node = head; node != null; node = node.next)
            stack.push(node);

        ListNode node = head;
        while (node != stack.peek() && node.next != stack.peek()) {
            ListNode top = stack.pop();

            ListNode next = node.next;
            node.next = top;
            top.next = next;

            node = next;
        }

        stack.peek().next = null;
    }

    public void reorderList2(ListNode head) {

        if (head == null || head.next == null) return;

        ListNode p1 = head;
        ListNode p2 = head;

        // find mid of the list
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        // reverse last half
        ListNode mid = p1;
        ListNode pre = p1.next;
        while (pre.next != null) {
            ListNode cur = pre.next;
            pre.next = cur.next;
            cur.next = mid.next;
            mid.next = cur;
        }

        // insert last half into first half one by one
        p1 = head;
        p2 = mid.next;
        while (p1 != mid) {
            mid.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;

            p1 = p2.next;
            p2 = mid.next;
        }
    }

    public static void main(String[] args) {

        ReorderList c = new ReorderList();

        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        c.reorderList2(head);
        printList(head);
    }

    private static void printList(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val);
            if (node.next != null) sb.append("->");
            node = node.next;
        }
        System.out.println(sb);
    }

}
