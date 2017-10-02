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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p, q).tn;
    }

    private Status find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return new Status(false, false, null);
        Status l = find(root.left, p, q);
        Status r = find(root.right, p, q);
        if (l.p && l.q) return l;
        else if (r.p && r.q) return r;
        else if (l.p && r.q || l.q && r.p) return new Status(true, true, root);
        else if (l.p || r.p) {
            if (root == q) return new Status(true, true, root);
            else return new Status(true, false, null);
        } else if (l.q || r.q) {
            if (root == p) return new Status(true, true, root);
            else return new Status(false, true, null);
        } else if (root == p) return new Status(true, false, null);
        else if (root == q) return new Status(false, true, null);
        return new Status(false, false, null);
    }

    static class Status {
        boolean p;
        boolean q;
        TreeNode tn;
        Status(boolean p, boolean q, TreeNode tn) {
            this.p = p;
            this.q = q;
            this.tn = tn;
        }
    }
}
