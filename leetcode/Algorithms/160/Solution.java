/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
	// 17:52
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int a = 0;
        int b = 0;
        ListNode la = headA;
        while (la != null) {
            a++;
            la = la.next;
        }
        ListNode lb = headB;
        while (lb != null) {
            b++;
            lb = lb.next;
        }
        la = headA;
        lb = headB;
        if (a > b) for (int i = 0; i < a-b; i++) la = la.next;
        if (b > a) for (int i = 0; i < b-a; i++) lb = lb.next;
        while (la != null) {
            if (la == lb) return la;
            la = la.next;
            lb = lb.next;
        }
        return null;
    }
}
