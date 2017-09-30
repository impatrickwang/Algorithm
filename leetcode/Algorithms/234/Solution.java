/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        if (size < 2) return true;
        ListNode mid = head;
        for (int i = 0; i < (size%2==0?(size/2-1):size/2); i++) {
            mid = mid.next;
        }
        ListNode tail = mid.next;
        while (tail.next != null) {
            ListNode ln = tail.next;
            tail.next = ln.next;
            ln.next = mid.next;
            mid.next = ln;
        }
        tail = mid.next;
        while (tail != null) {
            if (head.val != tail.val) return false;
            head = head.next;
            tail = tail.next;
        }
        return true;
    }
}
