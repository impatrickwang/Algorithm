/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        return sum(root.left, true) + sum(root.right, false);
    }

    private int sum(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        if (root.left == null && root.right == null && isLeft) return root.val;
        return sum(root.left, true) + sum(root.right, false);
    }
}
