package com.graphs;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.createGraph();
		graph.printNeighbours();
	}

	List<List<Edge>> graph = new ArrayList<>();

	public void createGraph() {

		List<Edge> edges = new ArrayList<>();
		edges.add(new Edge(0, 1, 20));
		graph.add(edges);

		edges = new ArrayList<>();
		edges.add(new Edge(1, 2, 10));
		edges.add(new Edge(1, 3, 0));
		graph.add(edges);

		edges = new ArrayList<>();
		edges.add(new Edge(2, 0, 2));
		edges.add(new Edge(2, 1, 10));
		edges.add(new Edge(2, 3, -1));
		graph.add(edges);

		edges = new ArrayList<>();
		edges.add(new Edge(3, 1, 0));
		edges.add(new Edge(3, 2, -1));
		graph.add(edges);
	}

	public void printNeighbours() {
		List<Edge> edges = graph.get(2);

		for(Edge e : edges) {
			System.out.println(e.dest + " " + e.weight);
		}
	}

	private class Edge {
		int src;
		int dest;
		int weight;

		public Edge(int src, int dest, int weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}

	}

}