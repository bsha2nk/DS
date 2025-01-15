package com.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BellmanFord_nonGreedy {
	
	static Map<String, List<Vertex>> map = new LinkedHashMap<>();
	
	public static void main(String[] args) {
		createGraph();
		Map<String, Integer> dist = bellmanFord();
		
		System.out.println(dist);
	}		
	
	private static Map<String, Integer> bellmanFord() {
		Map<String, Integer> dist = new HashMap<>();
		
		for(String s : map.keySet()) {
			if(!s.equals("s")) {
				dist.put(s, Integer.MAX_VALUE);
			} else {
				dist.put(s, 0);
			}
		}
		
		for(int i=0; i<map.size() - 1; i++) {
			for(String s : map.keySet()) {
				for(Vertex vert : map.get(s)) {
					if(dist.get(s) != Integer.MAX_VALUE && dist.get(s) + vert.wt < dist.get(vert.v)) {
						dist.put(vert.v, dist.get(s) + vert.wt);
					}
				}				
			}
		}
		
		return dist;
	}
	
	private static void createGraph() {
		ArrayList<Vertex> list = new ArrayList<>();
		list.add(new Vertex("e", 8));
		list.add(new Vertex("a", 10));
		map.put("s", list);
		
		list = new ArrayList<>();
		list.add(new Vertex("c", 2));
		map.put("a", list);
		
		list = new ArrayList<>();
		list.add(new Vertex("a", 1));
		map.put("b", list);
		
		list = new ArrayList<>();
		list.add(new Vertex("b", -2));
		map.put("c", list);
		
		list = new ArrayList<>();
		list.add(new Vertex("a", -4));
		list.add(new Vertex("c", -1));
		map.put("d", list);
		
		list = new ArrayList<>();
		list.add(new Vertex("d", 1));
		map.put("e", list);
	}

	static class Vertex {
		String v;
		int wt;
		
		public Vertex(String v, int wt) {
			this.v = v;
			this.wt = wt;
		}
	}
}
