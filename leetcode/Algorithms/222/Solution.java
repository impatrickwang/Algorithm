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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        TreeNode tn = root;
        long cnt = 1;
        int w = 0;
        while (tn.left != null) {
            cnt *= 2;
            w++;
            tn = tn.left;
        }
        return (int) (cnt+countNodes(root, 0, cnt-1, w));
    }

    private long countNodes(TreeNode root, long l, long h, int w) {
        if (l == h) return l;
        if (l+1 == h) {
            if (findNode(root, h, w)) return h;
            else return l;
        }
        long m = (l+h)/2;
        if (!findNode(root, m, w)) return countNodes(root, l, m-1, w);
        else return countNodes(root, m, h, w);
    }

    private boolean findNode(TreeNode root, long index, int w) {
        long mask = 1 << (w-1);
        TreeNode tn = root;
        for (int i = 0; i < w; i++) {
            if ((index & mask) > 0) tn = tn.right;
            else tn = tn.left;
            mask = mask >> 1;
        }
        return tn != null;
    }
}
