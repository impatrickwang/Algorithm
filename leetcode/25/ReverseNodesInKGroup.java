/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode x = dummy;
        while (true) {
            ListNode y = x;
            for (int i = 0; i < k && y != null; i++) y = y.next;
            if (y == null) break;
            y = x.next;
            for (int i = 0; i < k-1; i++) {
                ListNode z = x.next;
                x.next = y.next;
                y.next = x.next.next;
                x.next.next = z;
            }
            x = y;
        }
        return dummy.next;
    }
}
