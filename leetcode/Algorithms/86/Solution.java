/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode ln = dummy;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val < x) {
                if (cur != ln) {
                    ListNode tmp = cur.next;
                    cur.next = tmp.next;
                    tmp.next = ln.next;
                    ln.next = tmp;
                } else cur = cur.next;
                ln = ln.next;
            } else cur = cur.next;
        }   
        return dummy.next;
    }
}
