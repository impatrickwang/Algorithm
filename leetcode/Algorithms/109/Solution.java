/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	// 11:44
    public TreeNode sortedListToBST(ListNode head) {
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return solve(head, size);  
    }

    private TreeNode solve(ListNode start, int size) {
        if (size < 1) return null;
        int m = size / 2;
        ListNode cur = start;
        for (int i = 0; i < m; i++) cur = cur.next;
        TreeNode root = new TreeNode(cur.val);
        root.left = solve(start, m);
        root.right = solve(cur.next, size-m-1);
        return root;
    }
}
