	package com.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


// Print vertices as level order travsersal. Print each vertices neighbours first before moving on to neighbours vertices
public class BFS {

	static int size = 7;

	@SuppressWarnings("unchecked")
	List<Edge>[] graph = new ArrayList[size];

	public static void main(String[] args) {
		BFS graph = new BFS();
		graph.createGraph();
		graph.bfs();

		boolean[] visited = new boolean[size];
	}

	private void disjointedBfs() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[size];
		for(int i = 0; i<size; i++) {
			if(visited[i] == false) {
				q.add(i);

				while(!q.isEmpty()) {
					int curr = q.poll();

					if(visited[curr] == false) {
						System.out.print(curr + " ");
						visited[curr] = true;

						for(Edge e : graph[curr]) {
							q.add(e.dest);
						}
					}
				}
			}

		}
	}

	private void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);

		boolean[] visited = new boolean[size];
		while(!queue.isEmpty()) {
			int v = queue.poll();

			if(visited[v] == false) {
				System.out.print(v + " ");
				visited[v] = true;

				for(Edge e : graph[v]) {
					queue.add(e.dest);
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
