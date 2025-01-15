package com.graphs;

import java.util.ArrayList;
import java.util.List;

//Recursive. Print neighbours vertices first before all of current vertex's neighbours
public class DfsDirectedCycle {

	static int size = 5;

	@SuppressWarnings("unchecked")
	List<Edge>[] graph = new ArrayList[size];

	public static void main(String[] args) {
		DfsDirectedCycle graph = new DfsDirectedCycle();
		graph.createGraph();

		boolean[] visited = new boolean[size];
		boolean[] stack = new boolean[size];

		for(int i=0; i<size; i++) {
			if(visited[i] == false) {
				if (graph.cycle(i, visited, stack)) {
					System.out.println("cycle detected");
					break;
				}
			}
		}
		
	}
	
	private boolean cycle(int curr, boolean[] visited, boolean[] stack) {

		visited[curr] = true;
		stack[curr] = true;
		
		for(Edge e : graph[curr]) {
			if (stack[e.dest]) {
				return true;
			} else if (!visited[e.dest]) {
				if(cycle(e.dest, visited, stack)) {
					return true;
				}
			}
		}
		
		stack[curr] = false;
		return false;
	}

	public void createGraph() {

		for(int i=0; i<size; i++) {
			graph[i] = new ArrayList<>();
		}

//		graph[1].add(new Edge(1, 0));
//		graph[0].add(new Edge(0, 2));
//		graph[2].add(new Edge(2, 3));
//		graph[3].add(new Edge(3, 0));

		graph[1].add(new Edge(1, 0));
		graph[2].add(new Edge(2, 0));
		graph[2].add(new Edge(2, 3));
		graph[3].add(new Edge(3, 4));
		graph[4].add(new Edge(4, 2));
		

	}

	private class Edge {
		@SuppressWarnings("unused")
		int src;
		int dest;

		public Edge(int src, int dest) {
			this.src = src;
			this.dest = dest;
		}

	}


}
