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
    public int findBottomLeftValue(TreeNode root) {
        List<TreeNode> list = new LinkedList<>();
        list.add(root);
        int res = 0;
        while (!list.isEmpty()) {
            int size = list.size();
            res = list.get(0).val;
            for (int i = 0; i < size; i++) {
                TreeNode tn = list.remove(0);
                if (tn.left != null) list.add(tn.left);
                if (tn.right != null) list.add(tn.right);
            }
        }
        return res;
    }
}
