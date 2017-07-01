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
	// 22:19
    public boolean isSymmetric(TreeNode root) {
		if (root == null) return true;
        solve(root.left, root.right);
    }

    private boolean solve(TreeNode tn1, TreeNode tn2) {
        if (tn1 == null && tn2 == null) return true;
        if (tn1 == null || tn2 == null || tn1.val != tn2.val) return false;
        return solve(tn1.left, tn2.right) && solve(tn1.right, tn2.left);
    }
}
