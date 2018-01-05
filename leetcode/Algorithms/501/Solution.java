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
    public int[] findMode(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        int[] ret = findMode(root, new int[0], res);
        if (ret.length > 0) {
            if (ret[1] > ret[2]) return new int[] {ret[0]};
            else if (ret[1] == ret[2]) res.add(ret[0]);
        }
        int[] r = new int[res.size()];
        for (int i = 0; i < res.size(); i++) r[i] = res.get(i);
        return r;
    }

    private int[] findMode(TreeNode root, int[] status, List<Integer> res) {
        if (root == null) return status;
        status = findMode(root.left, status, res);
        if (status.length > 0) {
            if (root.val != status[0]) {
                if (status[1] > status[2]) {
                    status[2] = status[1];
                    res.clear();
                    res.add(status[0]);
                } else if (status[1] == status[2]) res.add(status[0]);
                status[0] = root.val;
                status[1] = 1;
            } else status[1]++;
        } else status = new int[] {root.val, 1, 0};
        return findMode(root.right, status, res);
    }
}
