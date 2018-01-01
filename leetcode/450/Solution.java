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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode[] tns = search(root, key);
        if (tns[1] != null) {
            boolean left = true;
            if (tns[0] != null && tns[1].val > tns[0].val) left = false;
            if (tns[1].right == null) {
                tns[1] = tns[1].left;
            } else {
                TreeNode p = tns[1].right;
                while (p.left != null && p.left.left != null) {
                    p = p.left;
                }
                if (p.left == null) {
                    p.left = tns[1].left;
                    tns[1] = p;
                } else {
                    TreeNode tn = p.left;
                    p.left = tn.right;
                    tn.left = tns[1].left;
                    tn.right = tns[1].right;
                    tns[1] = tn;
                }
            }
            if (tns[0] == null) root = tns[1];
            else if (left) tns[0].left = tns[1];
            else tns[0].right = tns[1];
        }
        return root;
    }

    private TreeNode[] search(TreeNode root, int key) {
        if (root == null) return new TreeNode[]{null, null};
        if (root.val == key) return new TreeNode[]{null, root};
        TreeNode[] tns = key < root.val ? search(root.left, key) : search(root.right, key);
        if (tns[1] != null && tns[0] == null) tns[0] = root;
        return tns;
    }
}
