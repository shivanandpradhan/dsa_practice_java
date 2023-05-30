package graph.adjacencyList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    ArrayList<GraphNode> vertices = new ArrayList<>();

    Graph(ArrayList<GraphNode> graphNodes) {
        this.vertices = graphNodes;
    }

    public void addUndirectedEdge(int i, int j) {
        GraphNode v1 = vertices.get(i);
        GraphNode v2 = vertices.get(j);
        v1.getNeighbours().add(v2);
        v2.getNeighbours().add(v1);
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < vertices.size(); i++) {
            GraphNode node = vertices.get(i);
            str.append(node.getName() + ": ");
            int j = 0;
            for (; j < node.getNeighbours().size() - 1; j++) {
                str.append(node.getNeighbours().get(j).getName() + " -> ");
            }
            if (node.getNeighbours().size() > j) {
                str.append(node.getNeighbours().get(j).getName());
            }
            str.append("\n");
        }
        return new String(str);
    }

    /** bfs traversal */
    public String bfsTraversal() {
        StringBuilder res = new StringBuilder();
        res.append("BFS : ");
        boolean[] visited = new boolean[vertices.size()];
        Queue<GraphNode> que = new LinkedList<GraphNode>();

        que.add(vertices.get(0));

        while (!que.isEmpty()) {
            GraphNode tempNode = que.poll();
            int index = tempNode.getIndex();
            res.append(tempNode.getName() + " ");
            visited[index] = true;
            for (GraphNode node : tempNode.getNeighbours()) {
                if (!visited[node.getIndex()]) {
                    que.add(node);
                    visited[node.getIndex()] = true;
                }
            }
        }
        return new String(res.append("\n"));
    }

    /** DFS Traversal */
    public String dfsTraversal(){
        StringBuilder str = new StringBuilder();
        for(GraphNode node : vertices){
            str.append(dfsTraversalFromNode(node));
        }
        return new String(str);
    }

    public String dfsTraversalFromNode(GraphNode graphNode){
        StringBuilder str = new StringBuilder();

        Stack<GraphNode> stk = new Stack<>(); 
        stk.push(graphNode);                                // adding node in the stack.
        while(!stk.isEmpty()){
            GraphNode node = stk.pop();        // pop the node.
            if(!node.getIsVisited()){               // node is not visited. 
                str.append(node.getName() + " ");
                node.setIsVisited(true);    

                // push all adjacent unvisited node
                for(GraphNode neighbour : node.getNeighbours()){
                    if (!neighbour.getIsVisited()){
                        stk.push(neighbour);
                    }
                }
            }
        }
        return new String(str);
    }

}
