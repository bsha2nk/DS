package com.graphs;

import java.util.ArrayList;
import java.util.List;

public class BellmanFord_nonGreedy_AdjList {
	
	private static List<Edge>[] graph = new ArrayList[5];
	
	public static void main(String[] args) {
		createGraph();
		bellmanFord(0);
		
	}		
	
	private static void bellmanFord(int src) {
		int n = graph.length;
		int[] dist = new int[n];
		
		for (int i=0; i<n; i++) {
			if (i != src) {
				dist[i] = Integer.MAX_VALUE;
			}
		}
		
		for (int i=0; i<n-1; i++) {
			for (int j=0; j<n; j++) {
				for (Edge e : graph[j]) {
					int u = j;
					int v = e.dest;
					if (dist[u] != Integer.MAX_VALUE && dist[u] + e.wt < dist[v]) {
						dist[v] = dist[u] + e.wt;
					}
				}
			}
		}
		
		for (int j=0; j<n; j++) {
			for (Edge e : graph[j]) {
				int u = j;
				int v = e.dest;
				if (dist[u] != Integer.MAX_VALUE && dist[u] + e.wt < dist[v]) {
					System.out.println("Negative cycle detected");
				}
			}
		}
		
		for (int i : dist) {
			System.out.print(i + " ");
		}
	}
	
	private static void createGraph() {
		for (int i=0; i<graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		
		graph[0].add(new Edge(0, 1, 2));
		graph[0].add(new Edge(0, 2, 4));

		graph[1].add(new Edge(1, 2, -4));

		graph[2].add(new Edge(2, 3, 2));

		graph[3].add(new Edge(3, 4, 4));

		graph[4].add(new Edge(4, 1, -1));
	}

	static class Edge {
		int src;
		int dest;
		int wt;
		
		public Edge(int src, int dest, int wt) {
			this.src = src;
			this.dest = dest;
			this.wt = wt;
		}
	}
	
}
