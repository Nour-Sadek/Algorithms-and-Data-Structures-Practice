package graphs;

import java.util.*;

public class GraphTraversals {

    public static void depthFirstTraversal(Graph graph, Vertex start) {
        if (!graph.getVertices().contains(start)) {
            throw new Error("The graph doesn't contain the provided vertex!");
        }

        List<Vertex> visitedVertices = new ArrayList<>();
        visitedVertices.add(start);

        DFSHelper(start, visitedVertices);
        
    }

    private static void DFSHelper(Vertex start, List<Vertex> visitedVertices) {
        Stack<Vertex> visitStack = new Stack<>();
        visitStack.push(start);
        System.out.println(start.getData());

        while (!visitStack.isEmpty()) {
            Vertex current = visitStack.peek();
            boolean anyUnvisited = false;

            for (Edge edge: current.getEdges()) {
                Vertex neighbor = edge.getEnd();

                if (!visitedVertices.contains(neighbor)) {
                    anyUnvisited = true;
                    visitedVertices.add(neighbor);
                    visitStack.push(neighbor);
                    System.out.println(neighbor.getData());
                    break;
                }
            }

            if (!anyUnvisited) {
                visitStack.pop();
            }
        }

    }

    public static void breadthFirstTraversal(Graph graph, Vertex start) {
        if (!graph.getVertices().contains(start)) {
            throw new Error("The graph doesn't contain the provided vertex!");
        }

        List<Vertex> visitedVertices = new ArrayList<>();
        visitedVertices.add(start);

        BFSHelper(start, visitedVertices);

    }

    private static void BFSHelper(Vertex start, List<Vertex> visitedVertices) {
        Queue<Vertex> visitQueue = new LinkedList<Vertex>();
        visitQueue.add(start);

        while (!visitQueue.isEmpty()) {
            Vertex current = visitQueue.poll();
            System.out.println(current.getData());

            for (Edge edge: current.getEdges()) {
                Vertex neighbor = edge.getEnd();

                if (!visitedVertices.contains(neighbor)) {
                    visitedVertices.add(neighbor);
                    visitQueue.offer(neighbor);
                }
            }

        }

    }

}
