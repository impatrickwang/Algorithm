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
	// 22:56
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> list = new LinkedList<>();
        if (root != null) list.add(root);
        int size = list.size();
        while (size != 0) {
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tn = list.remove(0);
                l.add(tn.val);
                if (tn.left != null) list.add(tn.left);
                if (tn.right != null) list.add(tn.right);
            }
            res.add(0, l);
            size = list.size();
        }
        return res;
    }
}
