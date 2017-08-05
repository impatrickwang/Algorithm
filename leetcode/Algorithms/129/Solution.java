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
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
		return sum(root, 0);        
    }
    
    private int sum(TreeNode tn, int s) {
        int cur = s*10+tn.val;
        if (tn.left == null && tn.right == null) return cur;
        else if (tn.left == null) return sum(tn.right, cur);
        else if (tn.right == null) return sum(tn.left, cur);
        return sum(tn.left, cur) + sum(tn.right, cur);
    }
}
