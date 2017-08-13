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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int size = 1;
        while (size > 0) {
            for (int i = 0; i < size; i++) {
                TreeNode tn = q.remove();
                if (tn.left != null) q.add(tn.left);
                if (tn.right != null) q.add(tn.right);
                if (i == size-1) res.add(tn.val);
            }
            size = q.size();
        }
        return res;
    }
}
