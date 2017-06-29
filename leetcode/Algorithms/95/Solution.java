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
	// 23:04
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) return new ArrayList<TreeNode>();
        return solve(1, n);
    }
    
    private List<TreeNode> solve(int s, int e) {
        List<TreeNode> res = new ArrayList<>();
        if (s > e) res.add(null);
        else {
            for (int i = s; i <= e; i++) {
                List<TreeNode> lefts = solve(s, i-1);
                List<TreeNode> rights = solve(i+1, e);
                for (TreeNode left:lefts) for (TreeNode right:rights) {
                    TreeNode tn = new TreeNode(i);
                    tn.left = left;
                    tn.right = right;
                    res.add(tn);
                }
            }
        }
        return res;
    }
}
