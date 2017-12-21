/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode ol = head;
        ListNode el = ol.next;
        while (el != null && el.next != null) {
            ListNode nol = el.next;
            ListNode nel = nol.next;
            el.next = nel;
            nol.next = ol.next;
            ol.next = nol;
            el = nel;
            ol = nol;
        }
        return head;
    }
}
