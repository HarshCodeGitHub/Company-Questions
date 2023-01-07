package com.microsoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Node {
	int nd;
	int data;

	public Node(int nd, int data) {
		this.data = data;
		this.nd = nd;
	}
}

public class Profitable_Path_in_Tree {

	public static int mostProfitablePath(int[][] edges, int bob, int[] data) {
		int m = edges.length;

		Map<Integer, List<Integer>> graph = new HashMap<>();
		Set<Integer> visited = new HashSet<>();
		Set<Integer> opened = new HashSet<>();
		Map<Integer, Integer> parent = new HashMap<>();

		parent.put(0, -1);

		for (int i = 0; i < m; i++) {
			int a = edges[i][0];
			int b = edges[i][1];
			graph.putIfAbsent(a, new ArrayList<>());
			graph.putIfAbsent(b, new ArrayList<>());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		updateParent(graph, visited, 0, parent);
		visited.clear();
		Queue<Node> queue = new LinkedList<>();

		queue.add(new Node(0, data[0]));
		int max = Integer.MIN_VALUE;

		while (!queue.isEmpty()) {
			if (bob != -1) {
				opened.add(bob);
				bob = parent.get(bob);
			}
			int l = queue.size();
			while (l > 0) {
				Node node = queue.poll();
				visited.add(node.nd);
				int val1 = node.data;
				boolean isLeaf = true;
				for (Integer nd : graph.getOrDefault(node.nd, new ArrayList<>())) {
					if (!visited.contains(nd)) {
						isLeaf = false;
						int val = val1;
						if (!opened.contains(nd)) {
							if (bob == nd) {
								val += data[nd] / 2;
							} else {
								val += data[nd];
							}
						}
						queue.add(new Node(nd, val));
					}
				}
				if (isLeaf) {
					max = Math.max(max, node.data);
				}
				l--;
			}
		}
		return max;
	}

	private static void updateParent(Map<Integer, List<Integer>> graph, Set<Integer> visited, int node,
			Map<Integer, Integer> parent) {

		if (visited.contains(node))
			return;
		visited.add(node);
		for (Integer nd : graph.get(node)) {

			if (!visited.contains(nd)) {
				parent.put(nd, node);
				updateParent(graph, visited, nd, parent);
			}

		}
	}
}
