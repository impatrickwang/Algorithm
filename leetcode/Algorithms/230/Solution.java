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
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode tn = root;
        while (tn != null) {
            stack.push(tn);
            tn = tn.left;
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            tn = stack.pop();
            res = tn.val;
            tn = tn.right;
            while (tn != null) {
                stack.push(tn);
                tn = tn.left;
            }
        }
        return res;
    }
}
