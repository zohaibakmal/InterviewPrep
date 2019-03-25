package com.test;

import java.util.LinkedList;
import java.util.List;

public class GraphNode <T>{
    private T value;
    private List<GraphNode> neighbours;
    public GraphNode(T value){
        this.value = value;
        neighbours = new LinkedList<>();
    }

    List<GraphNode> getNeighbours (){
        return neighbours;
    }

    public void addNeighbour(GraphNode node){
        neighbours.add(node);
        return;
    }

    T getValue(){
        return this.value;
    }
}
