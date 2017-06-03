/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length < 1) return null;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (n1, n2) -> {
            if (n1.val < n2.val) return -1;
            else if (n1.val > n2.val) return 1;
            return 0;
        });
        for (int i = 0; i < lists.length; i++) if (lists[i] != null) pq.add(lists[i]);
        while (!pq.isEmpty()) {
            cur.next = pq.poll();
            cur = cur.next;
            if (cur.next != null) pq.add(cur.next);
        }
        return dummy.next;
    }
}
