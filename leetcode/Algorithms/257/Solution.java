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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        List<String> l = binaryTreePaths(root.left);
        List<String> r = binaryTreePaths(root.right);
        for (String str:l) res.add(root.val+"->"+str);
        for (String str:r) res.add(root.val+"->"+str);
        if (res.isEmpty()) res.add(root.val+"");
        return res;
    }
}
