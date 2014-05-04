package leecode;

/***
 * http://oj.leetcode.com/problems/add-two-numbers/
 * 
 * @author weiwei
 * 
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null;
        ListNode cur = null;
        int plusone = 0;

        while (l1 != null || l2 != null) {
            int val = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + plusone;
            plusone = val > 9 ? 1 : 0;

            // add new node
            ListNode node = new ListNode(val % 10);
            if (cur == null) {
                head = node;
            } else {
                cur.next = node;
            }

            cur = node;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (plusone > 0) {
            ListNode node = new ListNode(1);
            cur.next = node;
        }

        return head;
    }

    public static void main(String[] args) {
        AddTwoNumbers c = new AddTwoNumbers();

        ListNode l13 = new ListNode(3);
        ListNode l12 = new ListNode(4);
        l12.next = l13;
        ListNode l11 = new ListNode(2);
        l11.next = l12;

        ListNode l23 = new ListNode(4);
        ListNode l22 = new ListNode(6);
        l22.next = l23;
        ListNode l21 = new ListNode(5);
        l21.next = l22;

        ListNode result = c.addTwoNumbers(l11, l21);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
