/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode ugn = new UndirectedGraphNode(node.label);
        map.put(node, ugn);
        queue.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.remove();
            for (UndirectedGraphNode n : cur.neighbors) {
                if (!map.containsKey(n)) {
                    UndirectedGraphNode nn = new UndirectedGraphNode(n.label);
                    map.put(n, nn);
                    queue.add(n);
                }
                map.get(cur).neighbors.add(map.get(n));
            }
        }
        return ugn;
    }
}
