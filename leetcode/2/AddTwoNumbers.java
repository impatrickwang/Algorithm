/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int c = 0;
        while (c > 0 || l1 != null || l2 != null) {
            c += l1 == null ? 0 : l1.val;
            c += l2 == null ? 0 : l2.val;
            cur.next = new ListNode(c % 10);
            c /= 10;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
