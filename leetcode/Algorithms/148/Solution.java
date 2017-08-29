/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) return head;
        int size = 1;
        ListNode cur = head;
        while (cur.next != null) {
            size++;
            cur = cur.next;
        }
        return sortList(head, size);
    }

    private ListNode sortList(ListNode head, int size) {
        if (size == 1) return head;
        int m = size / 2;
        ListNode h = head;
        for (int i = 0; i < m-1; i++) h = h.next;
        ListNode nh = h.next;
        h.next = null;
        ListNode l = sortList(head, m);
        ListNode r = sortList(nh, size-m);
        ListNode dummy = new ListNode(0);
        h = dummy;
        while (l != null && r != null) {
            if (l.val < r.val) {
                h.next = l;
                l = l.next;
            } else {
                h.next = r;
                r = r.next;
            }
            h = h.next;
        }
        if (l != null) h.next = l;
        if (r != null) h.next = r;
        h = dummy.next;
        dummy.next = null;
        return h;
    }
}
