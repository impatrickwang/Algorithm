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
    public int rob(TreeNode root) {
        int[] res = tryRob(root);
        return Math.max(res[0], res[1]);
    }

    private int[] tryRob(TreeNode root) {
        if (root == null) return new int[] {0, 0};
        int[] left = tryRob(root.left);
        int[] right = tryRob(root.right);
        return new int[] {root.val+left[1]+right[1], Math.max(left[0], left[1])+Math.max(right[0], right[1])};
    }
}
