package graph.adjacencyList;

import java.util.ArrayList;

public class GraphNode {
    private String name;
    private int index;
    private Boolean isVisited;

    public Boolean getIsVisited() {
        return isVisited;
    }

    public void setIsVisited(Boolean isVisited) {
        this.isVisited = isVisited;
    }


    private ArrayList<GraphNode> neighbours = new ArrayList<>();

    public GraphNode(String name, int index){
        this.name = name;
        this.index = index;
        this.isVisited = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ArrayList<GraphNode> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(ArrayList<GraphNode> neighbours) {
        this.neighbours = neighbours;
    }

    
}
