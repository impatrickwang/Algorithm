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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Map<String, List<TreeNode>>> maps = new HashMap<>();
        visit(root, maps);
        List<TreeNode> res = new LinkedList<>();
        for (Map<String, List<TreeNode>> map:maps.values()) {
            for (List<TreeNode> list:map.values()) {
                if (list.size() > 1) res.add(list.get(0));
            }
        }
        return res;
    }

    private String[] visit(TreeNode root, Map<String, Map<String, List<TreeNode>>> maps) {
        if (root == null) return null;
        String[] l = visit(root.left, maps);
        String[] r = visit(root.right, maps);
        String[] res = new String[] {
            ""+root.val+(l != null ? l[0] : "#")+(r != null ? r[0] : "#"), (l != null ? l[1]:"#")+root.val+(r != null ? r[1]:"#")};
        if (!maps.containsKey(res[0])) maps.put(res[0], new HashMap<String, List<TreeNode>>());
        if (!maps.get(res[0]).containsKey(res[1])) maps.get(res[0]).put(res[1], new LinkedList<TreeNode>());
        maps.get(res[0]).get(res[1]).add(root);
        return res;
    }
}
