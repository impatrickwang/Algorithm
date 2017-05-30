/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l1 = dummy;
        ListNode l2 = head;
        while (l2 != null && l2.next != null) {
            l1.next = l2.next;
            l2.next = l1.next.next;
            l1.next.next = l2;
            l1 = l2;
            l2 = l2.next;
        }
        return dummy.next;
    }
}
