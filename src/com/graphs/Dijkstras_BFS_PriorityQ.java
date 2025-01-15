package com.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


// O(V + ElogV)
public class Dijkstras_BFS_PriorityQ {
	
	public static void main(String[] args) {
		int v = 6;
		
		@SuppressWarnings("unchecked")
		List<Edge>[] graph = new ArrayList[v];
		createGraph(graph);
		
		int[] distances = findShortestDist(graph, 0);
		System.out.println();
		System.out.println("Distance from 0 to 6 is " + distances[5]);
		
	}

	private static int[] findShortestDist(List<Edge>[] graph, int src) {
		
		int[] dist = new int[graph.length];
		for(int i=0; i<graph.length; i++) {
			if(i != src) {
				dist[i] = Integer.MAX_VALUE;
			}
		}
		
		Queue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(0, 0));
		
		boolean[] visited = new boolean[graph.length];
		int[] prev = new int[graph.length];
		prev[src] = -1;
		
		while(!pq.isEmpty()) {
			Pair curr = pq.poll();
			
			if(visited[curr.node] == false) {
				visited[curr.node] = true;
				
				for(Edge e : graph[curr.node]) {
					int u = e.src;
					int v = e.dest;
					if(dist[u] + e.wt < dist[v]) {
						dist[v] = dist[u] + e.wt;
						pq.add(new Pair(v, dist[v]));
						prev[v] = u;
					}
				}
			}
		}
		
		printShortestPath(prev);
		
		return dist;
	}
	
	

	private static void printShortestPath(int[] prev) {
		int dest = 5;
		int prevVertex = prev[dest];
		System.out.print(dest + " ");
		while(prevVertex != -1) {
			System.out.print(prevVertex + " ");
			prevVertex = prev[prevVertex];
		}
	}

	public static void createGraph(List<Edge>[] graph) {

		for(int i=0; i<graph.length; i++) {
			graph[i] = new ArrayList<>();
		}

		graph[0].add(new Edge(0, 1, 2));
		graph[0].add(new Edge(0, 2, 4));

		graph[1].add(new Edge(1, 3, 7));
		graph[1].add(new Edge(1, 2, 1));

		graph[2].add(new Edge(2, 4, 3));

		graph[3].add(new Edge(3, 5, 1));

		graph[4].add(new Edge(4, 3, 2));
		graph[4].add(new Edge(4, 5, 5));

//		graph[0].add(new Edge(0, 1, 3));
//		graph[0].add(new Edge(0, 2, 2));
//		
//		graph[1].add(new Edge(1, 0, 3));
//		graph[1].add(new Edge(1, 2, 2));
//		graph[1].add(new Edge(1, 3, 1));
//		graph[1].add(new Edge(1, 4, 4));
//		
//		graph[2].add(new Edge(2, 0, 2));
//		graph[2].add(new Edge(2, 1, 2));
//		graph[2].add(new Edge(2, 3, 3));
//		graph[2].add(new Edge(2, 5, 5));
//		graph[2].add(new Edge(2, 6, 6));
//
//		graph[3].add(new Edge(3, 1, 1));
//		graph[3].add(new Edge(3, 2, 3));
//		graph[3].add(new Edge(3, 6, 10));
//		
//		graph[4].add(new Edge(4, 1, 4));
//		graph[4].add(new Edge(4, 6, 1));
//		
//		graph[5].add(new Edge(5, 2, 5));
//		graph[5].add(new Edge(5, 6, 2));
//
//		graph[6].add(new Edge(6, 2, 6));
//		graph[6].add(new Edge(6, 3, 10));
//		graph[6].add(new Edge(6, 4, 1));
//		graph[6].add(new Edge(6, 5, 2));
	}

	static class Pair implements Comparable<Pair>{
		int node;
		int dist;
		
		public Pair(int node, int dist) {
			this.node = node;
			this.dist = dist;
		}

		@Override
		public int compareTo(Pair o) {
			return this.dist - o.dist;
		}
		
	}
	private static class Edge {
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
