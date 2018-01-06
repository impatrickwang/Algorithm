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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        List<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            int size = list.size();
            int max = list.get(0).val;
            for (int i = 0; i < size; i++) {
                TreeNode tn = list.remove(0);
                max = Math.max(tn.val, max);
                if (tn.left != null) list.add(tn.left);
                if (tn.right != null) list.add(tn.right);
            }
            res.add(max);
        }
        return res;
    }
}
