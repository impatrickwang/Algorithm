/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l1 = dummy;
        for (int i = 0; i < m-1; i++) l1 = l1.next;
        ListNode l2 = l1.next;
        ListNode tmp = null;
        for (int i = 0; i < n-m; i++) {
            tmp = l2.next;
            l2.next = tmp.next;
            tmp.next = l1.next;
            l1.next = tmp;
        }
        return dummy.next;
    }
}
