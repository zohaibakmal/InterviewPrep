package com.test;

import java.util.LinkedList;
import java.util.List;

public class RouteGraph {

    class Graph{
        private Node [] nodes; //Adjacency List

        public Node [] getNodes(){
            return nodes;
        }

    }

//	public boolean search (Graph g, Node start, Node end){
//
//		//operates as Queue
//		LinkedList <Node> q = new LinkedList<Node>();
//
//		//Mark all nodes in the Graph as unvisited
//		for (Node u : g.getNodes()){
//			u.state = State.Unvisited;
//		}
//
//		start.state = State.Visiting;
//		q.add(start);
//
//		while(!q.isEmpty()){
//            Node u = q.removeFirst();
//			if (u!=null){
//				for (Node v : u.getAdjacent()){
//					if (v.state == State.Unvisited){
//						if (v==end){
//							return true;
//						}
//						else {
//							v.state = State.Visiting;
//							q.add(v);
//						}
//					}
//				}
//				u.state = State.Visisted;
//			}
//		}
//		return false;
//	}

    public boolean search (Graph g, Node start, Node end){
        return false;
    }

//    public boolean search(Node current, Node end){
//        if(current==null){
//            return false;
//        }
//        if(current==end){
//            return true;
//        }
//        current.state = State.Visited;
//        for(Node n:current.getAdjacent()){
//            if(n.state==State.Unvisited){
//                search(n, end);
//            }
//        }
//    }
	
	public enum State {
		Visited, Unvisited, Visiting;
	}

	public static void main(String[] args) {


	}

	class Node {
        private String name;
        private List<Node> adjacent;
		State state;

        public List<Node> getAdjacent(){
            return adjacent;
        }
	}


}
