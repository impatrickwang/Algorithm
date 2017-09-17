/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (head.next != null) {
            ListNode ln = head.next;
            head.next = ln.next;
            ln.next = dummy.next;
            dummy.next = ln;
        }
        return dummy.next;
    }
}
