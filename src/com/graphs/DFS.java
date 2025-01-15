package com.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Recursive. Print neighbours vertices first before all of current vertex's neighbours
public class DFS {

	static int size = 7;

	@SuppressWarnings("unchecked")
	List<Edge>[] graph = new ArrayList[size];

	public static void main(String[] args) {
		DFS graph = new DFS();
		graph.createGraph();

		boolean[] visited = new boolean[size];

		for(int i=0; i<size; i++) {
			if(visited[i] == false) {
				graph.dfs(i, visited);
			}
		}

		System.out.println();
		visited = new boolean[size];
		for(int i=0; i<size; i++) {
			if(visited[i] == false) {
				graph.dfsStack(i, visited);
			}
		}
	}

	private void dfs(int curr, boolean[] visited) {

		System.out.print(curr + " ");
		visited[curr] = true;
		for(Edge e : graph[curr]) {
			if(visited[e.dest] == false) {
				dfs(e.dest, visited);		
			}
		}

	}

	private void dfsStack(int curr, boolean[] visited) {
		Stack<Integer> stack = new Stack<>();
		stack.push(curr);
		visited[curr] = true;
		while(!stack.empty()) {
			curr = stack.pop();
			System.out.print(curr + " ");
			for(Edge e : graph[curr]) {
				if (!visited[e.dest]) {
					stack.push(e.dest);
					visited[e.dest] = true;
				}
			}
		}
	}

	public void createGraph() {

		for(int i=0; i<size; i++) {
			graph[i] = new ArrayList<>();
		}

		graph[0].add(new Edge(0, 1));
		graph[0].add(new Edge(0, 2));
		graph[0].add(new Edge(0, 3));
		
		graph[1].add(new Edge(1, 0));
		graph[2].add(new Edge(2, 0));
		graph[3].add(new Edge(3, 0));

		graph[1].add(new Edge(1, 4));
		graph[4].add(new Edge(4, 1));
		
		graph[2].add(new Edge(2, 5));
		graph[5].add(new Edge(5, 2));

		graph[3].add(new Edge(3, 6));
		graph[6].add(new Edge(6, 3));
		
		
//		graph[0].add(new Edge(0, 1));
//		graph[0].add(new Edge(0, 2));
//
//		graph[1].add(new Edge(1, 0));
//		graph[1].add(new Edge(1, 3));
//
//		graph[2].add(new Edge(2, 0));
//		graph[2].add(new Edge(2, 4));
//
//		graph[3].add(new Edge(3, 1));
//		graph[3].add(new Edge(3, 4));
//		graph[3].add(new Edge(3, 5));
//
//		graph[4].add(new Edge(4, 2));
//		graph[4].add(new Edge(4, 3));
//		graph[4].add(new Edge(4, 5));
//
//		graph[5].add(new Edge(5, 3));
//		graph[5].add(new Edge(5, 4));
//		graph[5].add(new Edge(5, 6));
//
//		graph[6].add(new Edge(6, 5));
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
