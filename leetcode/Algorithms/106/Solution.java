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
	// 22:39
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return solve(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);	 
    }

    private TreeNode solve(int[] in, int is, int ie, int[] po, int ps, int pe) {
        if (is > ie) return null;
        TreeNode tn = new TreeNode(po[pe]);
        for (int i = is; i <= ie; i++) {
            if (in[i] == tn.val) {
                tn.left = solve(in, is, i-1, po, ps, ps+i-is-1);
                tn.right = solve(in, i+1, ie, po, ps+i-is, pe-1);
                break;
            }
        }
        return tn;
    }
}
