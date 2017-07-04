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
	// 12:46
    public void flatten(TreeNode root) {
        solve(root);
    }
    
    private TreeNode solve(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        TreeNode l = solve(root.left);
        TreeNode r = solve(root.right);
        if (l == null) return r;
        if (r == null) {
            root.right = root.left;
            root.left = null;
            return l;
        }
        TreeNode tn = root.right;
        root.right = root.left;
        l.right = tn;
        root.left = null;
        return r;
    }
}
