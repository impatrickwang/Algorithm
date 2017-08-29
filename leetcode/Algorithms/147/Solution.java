/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            ListNode p = dummy;
            while (p.next != cur.next && p.next.val < cur.next.val) {
                p = p.next;
            }
            if (p != cur) {
                ListNode n = cur.next;
                cur.next = n.next;
                n.next = p.next;
                p.next = n;
            } else cur = cur.next;
        }
        return dummy.next;
    }
}
