package com.graphs;

import java.util.ArrayList;
import java.util.List;

public class AllPaths {

	static int size = 7;

	@SuppressWarnings("unchecked")
	static List<Edge>[] graph = new ArrayList[size];

	public static void main(String[] args) {
		AllPaths graph = new AllPaths();
		graph.createGraph();
		
		boolean[] visited = new boolean[size];
		String path = "0";
		int target = 5;
		dfsAllPaths(0, visited, path, target);
		
	}

	public static void dfsAllPaths(int curr, boolean[] visited, String path, int target) {
		if(target == curr) {
			System.out.println(path);
			return;
		}
		
		for(Edge e : graph[curr]) {
			visited[curr] = true;
			if(visited[e.dest] == false) {
				dfsAllPaths(e.dest, visited, path + " " + e.dest, target);
			}
			visited[curr] = false;
		}

	}

	public void createGraph() {

		for(int i=0; i<size; i++) {
			graph[i] = new ArrayList<>();
		}


		graph[0].add(new Edge(0, 1));
		graph[0].add(new Edge(0, 2));

		graph[1].add(new Edge(1, 0));
		graph[1].add(new Edge(1, 3));

		graph[2].add(new Edge(2, 0));
		graph[2].add(new Edge(2, 4));

		graph[3].add(new Edge(3, 1));
		graph[3].add(new Edge(3, 4));
		graph[3].add(new Edge(3, 5));

		graph[4].add(new Edge(4, 2));
		graph[4].add(new Edge(4, 3));
		graph[4].add(new Edge(4, 5));

		graph[5].add(new Edge(5, 3));
		graph[5].add(new Edge(5, 4));
		graph[5].add(new Edge(5, 6));

		graph[6].add(new Edge(6, 5));
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
