package graph.adjacencyMatrix;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<GraphNode> vertices = new ArrayList<>();
        vertices.add(new GraphNode("A", 0));
        vertices.add(new GraphNode("B", 1));
        vertices.add(new GraphNode("C", 2));
        vertices.add(new GraphNode("D", 3));
        vertices.add(new GraphNode("E", 4));

        Graph g1 = new Graph(vertices);
        g1.insertEdge(0, 1);
        g1.insertEdge(0, 3);
        g1.insertEdge(1, 2);
        g1.insertEdge(1, 4);
        g1.insertEdge(2, 4);
        System.out.println(g1.toString());
        System.out.println(g1.bfsTraversal());
    }
}
