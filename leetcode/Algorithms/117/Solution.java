/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
	// 18:02
    public void connect(TreeLinkNode root) {
        List<TreeLinkNode> list = new LinkedList<>();
        if (root != null) list.add(root);
        int size = list.size();
        while (size > 0) {
            for (int i = 0; i < size; i++) {
                TreeLinkNode tln = list.remove(0);
                if (i < size - 1) tln.next = list.get(0);
                if (tln.left != null) list.add(tln.left);
                if (tln.right != null) list.add(tln.right);
            }
            size = list.size();
        }
    }
}
