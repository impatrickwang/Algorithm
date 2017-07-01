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
	// 23:13
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return solve(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    
    private TreeNode solve(int[] pre, int ps, int pe, int[] in, int is, int ie) {
        if (ps > pe) return null;
        TreeNode root = new TreeNode(pre[ps]);
        for (int i = is; i <= ie; i++) {
            if (in[i] == pre[ps]) {
                root.left = solve(pre, ps+1, ps+i-is, in, is, i-1);
                root.right = solve(pre, ps+i-is+1, pe, in, i+1, ie);
                break;
            }
        }  
        return root;
    }
}
