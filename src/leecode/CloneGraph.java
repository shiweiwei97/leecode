package leecode;

import java.util.HashMap;
import java.util.Map;

import leecode.common.UndirectedGraphNode;

/***
 * https://leetcode.com/problems/clone-graph/description/
 * 
 * @author weiwei
 *
 */
public class CloneGraph {

    private Map<Integer, UndirectedGraphNode> map = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node) {
        if (node == null) return null;
        if (map.containsKey(node.label)) return map.get(node.label);

        // clone current node
        UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
        map.put(node.label, cloneNode);

        // clone neighbors
        for (UndirectedGraphNode neighbor : node.neighbors)
            cloneNode.neighbors.add(clone(neighbor));

        return cloneNode;
    }
}
