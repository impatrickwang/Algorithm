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
	// 22:52
    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode tn = root;
        while (tn != null) {
            stack.push(tn);
            tn = tn.left;
        }
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            tn = stack.pop();
            res.add(tn.val);
            tn = tn.right;
            while (tn != null) {
                stack.push(tn);
                tn = tn.left;
            }
        }
        return res;
    }
}
