/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode n1 = head;
        for (int i = 0; i < n-1 && n1.next != null; i++) n1 = n1.next;
        ListNode n2 = dummy;
        while (n1.next != null) {
            n1 = n1.next;
            n2 = n2.next;
        }
        n1 = n2.next;
        n2.next = n1.next;
        n1.next = null;
        return dummy.next;
    }
}
