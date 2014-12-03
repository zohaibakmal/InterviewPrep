package com.test;

import java.util.LinkedList;

public class RouteGraph {
/*
	public boolean search (Graph g, Node start, Node end){

		//operates as Queue
		LinkedList <Node> q = new LinkedList<Node>();

		for (Node u : g.getNodes){
			u.state = State.Unvisited;
		}
		start.state = State.Visiting;
		q.add(start);
		Node u;
		while(!q.isEmpty()){
			u= q.removeFirst();
			if (u!=null){
				for (Node v : u.getAdjacent()){
					if (v.state == State.Unvisited){
						if (v==end){
							return true;	
						}
						else {
							v.state = State.Visiting;
							q.add(v);
						}	
					}
				}
				u.state = State.Visisted;
			}
		}
		return false;
	}
	
	public enum State {
		Visisted, Unvisited, Visiting;
	}

	public static void main(String[] args) {


	}

	private static class Node { 
		Node left; 
		Node right; 
		State state;
		int data;

		Node(int newData) { 
			left = null; 
			right = null; 
			data = newData; 
		} 
	}

*/
}
