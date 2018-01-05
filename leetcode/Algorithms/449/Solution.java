/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        String l = serialize(root.left);
        String r = serialize(root.right);
        return "" + root.val + (l.length() > 0 ? ","+l:l) + (r.length() > 0 ? ","+r:r);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() < 1) return null;
        String[] splits = data.split(",");
        int[] nums = new int[splits.length];
        for (int i = 0; i < nums.length; i++) nums[i] = Integer.valueOf(splits[i]);
        return deserialize(nums, 0, splits.length);
    }

    private TreeNode deserialize(int[] nums, int s, int e) {
        if (s >= e) return null;
        TreeNode root = new TreeNode(nums[s]);
        int m = s+1;
        while (m < e && nums[m] < nums[s]) {
            m++;
        }
        root.left = deserialize(nums, s+1, m);
        root.right = deserialize(nums, m, e);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
