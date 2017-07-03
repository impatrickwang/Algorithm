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
	// 12:04
    public boolean isBalanced(TreeNode root) {
        return solve(root) >= 0;
    }

    private int solve(TreeNode root) {
        if (root == null) return 0;
        int l = solve(root.left);
        int r = solve(root.right);
        if (l >= 0 && r >= 0 && Math.abs(l-r) < 2) return Math.max(l, r)+1;
        return -1;
    }
}
