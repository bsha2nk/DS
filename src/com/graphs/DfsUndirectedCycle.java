package com.graphs;

import java.util.ArrayList;
import java.util.List;

//Recursive. Print neighbours vertices first before all of current vertex's neighbours
public class DfsUndirectedCycle {

	static int size = 7;

	@SuppressWarnings("unchecked")
	List<Edge>[] graph = new ArrayList[size];

	public static void main(String[] args) {
		DfsUndirectedCycle graph = new DfsUndirectedCycle();
		graph.createGraph();

		boolean[] visited = new boolean[size];

		System.out.println(graph.cycle(0, visited, -1));

	}

	private boolean cycle(int curr, boolean[] visited, int parent) {

		visited[curr] = true;
		for(Edge e : graph[curr]) {
			if(visited[e.dest] && parent != e.dest) {
				return true;
			} else if(visited[e.dest] == false) {
				if (cycle(e.dest, visited, curr)) {
					return true;					
				}
			}
		}
		
		return false;
	}

	public void createGraph() {

		for(int i=0; i<size; i++) {
			graph[i] = new ArrayList<>();
		}


		graph[0].add(new Edge(0, 1));
		graph[0].add(new Edge(0, 4));

		graph[1].add(new Edge(1, 0));
		graph[1].add(new Edge(1, 2));
		graph[1].add(new Edge(1, 4));

		graph[2].add(new Edge(2, 1));
		graph[2].add(new Edge(2, 3));

		graph[3].add(new Edge(3, 2));

		graph[4].add(new Edge(4, 0));
		graph[4].add(new Edge(4, 1)); 
		graph[4].add(new Edge(4, 5));

		graph[5].add(new Edge(5, 4));
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
