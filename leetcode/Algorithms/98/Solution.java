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
	// 11:57
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return solve(root)[0] == 1;
    }

    private int[] solve(TreeNode root) {
        if (root.left == null && root.right == null) return new int[] {1, root.val, root.val};
        else if (root.left == null) {
            int[] right = solve(root.right);
            if (right[0] == 1 && root.val < right[1]) return new int[] {1, root.val, right[2]};
        } else if (root.right == null) {
            int[] left = solve(root.left);
            if (left[0] == 1 && root.val > left[2]) return new int[] {1, left[1], root.val};
        } else {
            int[] left = solve(root.left);
            int[] right = solve(root.right);
            if (left[0] == 1 && right[0] == 1 && root.val > left[2] && root.val < right[1]) return new int[] {1, left[1], right[2]};
        }
        return new int[]{0};
    }
}
