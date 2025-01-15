package com.graphs;

import java.util.ArrayList;
import java.util.List;

//Recursive. Print neighbours vertices first before all of current vertex's neighbours
public class MY_IMPL_DfsDirectedCycle {

	static int size = 5;

	@SuppressWarnings("unchecked")
	List<Edge>[] graph = new ArrayList[size];

	public static void main(String[] args) {
		MY_IMPL_DfsDirectedCycle graph = new MY_IMPL_DfsDirectedCycle();
		graph.createGraph();

		boolean[] visited = new boolean[size];

		for(int i=0; i<size; i++) {
			if(graph.cycle(i, visited)) {
				System.out.println("yessss");
			}
		}
	}

	private boolean cycle(int curr, boolean[] visited) {

		visited[curr] = true;
		for(Edge e : graph[curr]) {
			if(visited[e.dest]) {
				return true;
			} else {
				if(cycle(e.dest, visited)) {
					return true;
				}
			}
		}

		visited[curr] = false;
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

		//		graph[0].add(new Edge(0, 1));
		//		graph[1].add(new Edge(1, 2));
		//		graph[0].add(new Edge(0, 3));
		//		graph[3].add(new Edge(3, 2));




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
