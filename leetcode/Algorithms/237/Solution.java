/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        if (node == null) return;
        ListNode cur = node;
        while (cur.next != null) {
            cur.val = cur.next.val;
            if (cur.next.next == null) break;
            cur = cur.next;
        }
        cur.next = null;
    }
}
