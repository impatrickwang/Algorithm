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
    // 22:36
    static int res;
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        res = root.val;
        solve(root);
        return res;
    }

    private int solve(TreeNode root) {
        if (root == null) return 0;
        int l = solve(root.left);
        int r = solve(root.right);
        int max = Math.max(root.val, Math.max(root.val+l, root.val+r));
        res = Math.max(res, Math.max(max, root.val+l+r));
        return max;
    }
}
