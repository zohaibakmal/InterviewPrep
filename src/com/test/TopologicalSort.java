package com.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort {
    public List<GraphNode> sort(GraphNode<Integer> root) {
        Stack<GraphNode> stack = new Stack<>();
        Set<GraphNode> visited = new HashSet();
        for (GraphNode node : root.getNeighbours()) {
            if (visited.contains(node)) {
                continue;

            }
//            top
        }
        return null;
    }

    private void topSortUtil(GraphNode<Integer> root, Stack<GraphNode<Integer>> stack, Set<GraphNode<Integer>> visited) {
        visited.add(root);
        for (GraphNode childVertex : root.getNeighbours()) {
            if (visited.contains(childVertex)) {
                continue;
            }
            topSortUtil(childVertex, stack, visited);
        }
        stack.add(root);
    }
}
