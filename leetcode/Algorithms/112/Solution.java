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
	// 12:26
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return root.left == null ? (root.right == null ? root.val == sum : hasPathSum(root.right, sum-root.val)) : (root.right == null ? hasPathSum(root.left, sum-root.val) : hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val));
    }
}
