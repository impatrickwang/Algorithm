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
	// 22:37
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<TreeNode> list = new LinkedList<>();
        list.add(root);
        int size = 1;
        while (!list.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tn = list.remove(0);
                l.add(tn.val);
                if (tn.left != null) list.add(tn.left);
                if (tn.right != null) list.add(tn.right);
            }
            res.add(l);
            size = list.size();
        }
        return res;
    }
}
