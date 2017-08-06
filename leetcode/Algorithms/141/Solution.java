/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode l = head;
        ListNode n = head;
        while (n.next != null && n.next.next != null) {
            l = l.next;
            n = n.next.next;
            if (l == n) return true;
        }
        return false;
    }
}
