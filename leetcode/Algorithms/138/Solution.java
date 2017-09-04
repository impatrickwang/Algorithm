/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode rln = dummy;
        while (cur != null) {
            rln.next = new RandomListNode(cur.val);
            rln = rln.next;
            map.put(cur, rln);
            cur = cur.next;
        }
        cur = head;
        rln = dummy.next;
        while (cur != null) {
            rln.random = map.get(cur.random);
            cur = cur.next;
            rln = rln.next;
        }
        return dummy.next;
    }
}
