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
	// 22:48
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
	    if (root == null) return res;
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        int size = 1;
        boolean dir = true;
        while (!list.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tn = list.remove(0);
                if (dir) l.add(tn.val);
                else l.add(0, tn.val);
                if (tn.left != null) list.add(tn.left);
                if (tn.right != null) list.add(tn.right);
            }
            res.add(l);
            size = list.size();
            dir = !dir;
        }
        return res;                
    }
}
