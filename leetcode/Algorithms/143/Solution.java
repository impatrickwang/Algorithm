/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        int m = (size-1)/2;
        cur = head;
        for (int i = 0; i < m; i++) cur = cur.next;
        // reverse after cur
        ListNode t = cur.next;
        while (t != null && t.next != null) {
            ListNode n = t.next;
            t.next = n.next;
            n.next = cur.next;
            cur.next = n;
        }
        // insert
        t = head;
        while (t != cur) {
            ListNode n = cur.next;
            cur.next = n.next;
            n.next = t.next;
            t.next = n;
            t = n.next;
        }
    }
}
