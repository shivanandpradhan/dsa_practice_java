package graph.adjacencyMatrix;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
    public ArrayList<GraphNode> vertices = new ArrayList<>();
    public int[][] adjMatrix;

    Graph(ArrayList<GraphNode> graphNodes){
        this.vertices = graphNodes;
        adjMatrix = new int[graphNodes.size()][graphNodes.size()];
    }

    public void insertEdge(int i, int j){
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("   ");
        for(GraphNode node : vertices){
            str.append(node.name + " ");
        } 
        str.append("\n");
        for(int i = 0; i < adjMatrix.length; i++){
            str.append(vertices.get(i).name + ": ");
            for(int j = 0; j < adjMatrix.length; j++){
                str.append(adjMatrix[i][j] + " ");
            }
            str.append("\n");
        }
        return new String(str);
    }
    
    /** get neighbours of the node. */
    public ArrayList<GraphNode> getNeighbours(GraphNode node){
        ArrayList<GraphNode> list = new ArrayList<>();
        int index = node.index;

        for(int i = 0; i < vertices.size(); i++){
            if(adjMatrix[index][i] == 1){
                list.add(vertices.get(i));
            }
        }
        return list;
    }

    /** bfs traversal */
    public String bfsTraversal(){
        StringBuilder str = new StringBuilder();
        str.append("BFS : ");
        boolean[] visited = new boolean[vertices.size()];

        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(vertices.get(0));

        while(!queue.isEmpty()){
            GraphNode node = queue.poll();
            visited[node.index] = true;
            str.append(node.name + " ");
            for(GraphNode neighbour : getNeighbours(node)){
                if(!visited[neighbour.index]){
                    queue.add(neighbour);
                    visited[neighbour.index] = true;
                }
            }
        }

        return new String(str.append("\n"));
    }
}
