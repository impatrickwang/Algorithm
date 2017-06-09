/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
	// 21:52
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l1 = dummy;
        int size = 0;
        while (l1.next != null) {
            l1 = l1.next;
            size++;
        }
        k %= size;
        if (k == 0) return head;
        ListNode l2 = dummy;
        for (int i = 0; i < size-k; i++) l2 = l2.next;
        dummy.next = l2.next;
        l1.next = head;
        l2.next = null;
        return dummy.next;
    }
}
