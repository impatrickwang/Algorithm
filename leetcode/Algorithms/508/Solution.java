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
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        solve(root, map);
        List<Integer> res = new ArrayList<Integer>();
        int max = 0;
        for (Map.Entry<Integer, Integer> entry:map.entrySet()) {
            if (entry.getValue() == max) res.add(entry.getKey());
            else if (entry.getValue() > max) {
                res.clear();
                res.add(entry.getKey());
                max = entry.getValue();
            }
        }
        int[] r = new int[res.size()];
        for (int i = 0; i < r.length; i++) r[i] = res.get(i);
        return r;
    }

    private int solve(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return 0;
        int sum = root.val + solve(root.left, map) + solve(root.right, map);
        if (!map.containsKey(sum)) map.put(sum ,1);
        else map.put(sum ,map.get(sum)+1);
        return sum;
    }
}
