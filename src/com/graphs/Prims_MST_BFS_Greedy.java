package com.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Prims_MST_BFS_Greedy {
	
	static int size = 4;
	static List<Edge>[] graph = new ArrayList[size];
	
	public static void main(String[] args) {
		createGraph();
		primsMST();
	}
	
	private static void primsMST() {
		Queue<Pair> queue = new PriorityQueue<>();
		queue.add(new Pair(0, 0));
		
		boolean[] visited = new boolean[size];
		int cost = 0;
		
		while(!queue.isEmpty()) {
			Pair curr = queue.poll();
			if(visited[curr.v] == false) {
				visited[curr.v] = true;
				cost += curr.cost;
				
				for(Edge e : graph[curr.v]) {
					if(visited[e.dest] == false) {
						queue.add(new Pair(e.dest, e.wt));
					}
				}
			}
		}
		
		System.out.println(cost);
	}

	public static void createGraph() {

		for(int i=0; i<size; i++) {
			graph[i] = new ArrayList<>();
		}

		graph[0].add(new Edge(0, 1, 10));
		graph[0].add(new Edge(0, 2, 15));
		graph[0].add(new Edge(0, 3, 30));

		graph[1].add(new Edge(1, 0, 10));
		graph[1].add(new Edge(1, 3, 40));

		graph[2].add(new Edge(2, 0, 15));
		graph[2].add(new Edge(2, 3, 50));

		graph[3].add(new Edge(3, 0, 30));
		graph[3].add(new Edge(3, 1, 40));
		graph[3].add(new Edge(3, 2, 50));
	}
	
	static class Pair implements Comparable<Pair>{
		int v;
		int cost;
		
		Pair(int v, int wt) {
			this.v = v;
			this.cost = wt;
		}

		@Override
		public int compareTo(Pair o) {
			return this.cost - o.cost;
		}		
		
	}

	static class Edge {
		@SuppressWarnings("unused")
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
