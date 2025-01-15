package com.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Recursive. Print neighbours vertices first before all of current vertex's children
public class Topological_DFS_Directed_Acyclic {

	static int size = 6;

	@SuppressWarnings("unchecked")
	List<Edge>[] graph = new ArrayList[size];

	public static void main(String[] args) {
		Topological_DFS_Directed_Acyclic graph = new Topological_DFS_Directed_Acyclic();
		graph.createGraph();

		boolean[] visited = new boolean[size];
		Stack<Integer> stack = new Stack<>();

		for(int i=0; i<size; i++) {
			if(visited[i] == false) {
				graph.topologicalSort(i, visited, stack);
			}
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	private void topologicalSort(int curr, boolean[] visited, Stack<Integer> stack) {

		visited[curr] = true;
		for(Edge e : graph[curr]) {
			if(visited[e.dest] == false) {
				topologicalSort(e.dest, visited, stack);
			}
		}
		
		stack.push(curr);
	}

	public void createGraph() {

		for(int i=0; i<size; i++) {
			graph[i] = new ArrayList<>();
		}


		graph[5].add(new Edge(5, 0));
		graph[5].add(new Edge(5, 2));

		graph[2].add(new Edge(2, 3));

		graph[3].add(new Edge(3, 1));

		graph[4].add(new Edge(4, 0));
		graph[4].add(new Edge(4, 1));
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
