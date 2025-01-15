package com.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BfsUndirectedCycle {

	static int size = 7;
	static List<Edge>[] graph = new ArrayList[size];

	public static void main(String[] args) {
		createGraph();
		boolean c = findCycle(0);
		System.out.println(c);
	}

	public static boolean findCycle(int curr) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[size];
		q.offer(curr);
		q.offer(-1);

		visited[0] = true;
		while (!q.isEmpty()) {
			curr = q.poll();
			int parent = q.poll();
			for (Edge e : graph[curr]) {
				if(!visited[e.dest]) {
					visited[e.dest] = true;
					q.offer(e.dest);
					q.offer(curr);
				} else if (e.dest != parent) {
					return true;
				}
			}
		}

		return false;
	}
		

	public static void createGraph() {

		for(int i=0; i<size; i++) {
			graph[i] = new ArrayList<>();
		}

		graph[0].add(new Edge(0, 1));
		graph[0].add(new Edge(0, 2));
//
		graph[1].add(new Edge(1, 0));
//		graph[1].add(new Edge(1, 3));
//
		graph[2].add(new Edge(2, 0));
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

//				graph[0].add(new Edge(0, 1));
//				graph[0].add(new Edge(0, 2));
//		
//				graph[1].add(new Edge(1, 0));
//				graph[1].add(new Edge(1, 2));
//		
//				graph[2].add(new Edge(2, 1));
//				graph[2].add(new Edge(2, 0));

//				graph[0].add(new Edge(0, 1));
//				graph[0].add(new Edge(0, 3));
//				
//				graph[1].add(new Edge(1, 0));
//				graph[1].add(new Edge(1, 2));
//				
//				graph[2].add(new Edge(2, 1));
//				graph[2].add(new Edge(2, 3));
//				
//				graph[3].add(new Edge(3, 2));
//				graph[3].add(new Edge(3, 0));

	}

	private static class Edge {
		@SuppressWarnings("unused")
		int src;
		int dest;

		public Edge(int src, int dest) {
			this.src = src;
			this.dest = dest;
		}

	}

}
