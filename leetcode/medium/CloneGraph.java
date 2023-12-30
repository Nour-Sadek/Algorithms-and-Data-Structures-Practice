package leetcode.medium;

import leetcode.Node;
import java.util.*;

/*

Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

 */

public class CloneGraph {

    public Node cloneGraph(Node node) {

        if (node == null) return null;
        if (node.neighbors.isEmpty()) return new Node(node.val);

        // This map will store val: Node pairs where each Node is a new object
        Map<Integer, Node> newNodes = new HashMap<>();
        // This list will store references to the old nodes
        List<Node> oldNodes = new ArrayList<>();

        newNodes.put(node.val, new Node(node.val));
        oldNodes.add(node);

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        // Populate both the map and list with information about all nodes in the graph
        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            for (Node neighbor: curr.neighbors) {
                if (!newNodes.containsKey(neighbor.val)) {
                    queue.offer(neighbor);
                    newNodes.put(neighbor.val, new Node(neighbor.val));
                    oldNodes.add(neighbor);
                }
            }
        }

        // The new nodes in the map all have empty neighbors; this loop uses the old references in the list to
        // populate the neighbors variable for the new nodes in the map
        for (Node oldNode: oldNodes) {
            Node newNode = newNodes.get(oldNode.val);

            for (Node oldNeighbor: oldNode.neighbors) {
                Node newNeighbor = newNodes.get(oldNeighbor.val);
                newNode.neighbors.add(newNeighbor);
            }
        }

        // Returns the new copy of <node>
        return newNodes.get(node.val);

    }

}
