/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l1 = dummy;
        ListNode l2 = l1.next;
        while (l2 != null) {
            boolean d = false;
            while (l2.next != null && l2.next.val == l2.val) {
                ListNode ln = l2.next;
                l2.next = ln.next;
                ln.next = null;
                d = true;
            }
            if (d) {
                l1.next = l2.next;
                l2.next = null;
            } else l1 = l2;
            l2 = l1.next;
        }
        return dummy.next;
    }
}
