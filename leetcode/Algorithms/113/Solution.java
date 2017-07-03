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
	// 12:37
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                List<Integer> list = new ArrayList<>();
                list.add(sum);
                res.add(list);
            }
            return res;
        }
        List<List<Integer>> l = pathSum(root.left, sum - root.val);
        List<List<Integer>> r = pathSum(root.right, sum - root.val);
        for (List<Integer> list:l) {
            list.add(0, root.val);
            res.add(list);
        }
        for (List<Integer> list:r) {
            list.add(0, root.val);
            res.add(list);
        }
        return res;
    }
}
