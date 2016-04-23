package hr.fer.zgmetro.algorithm;

import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import hr.fer.zgmetro.model.Graph;
import hr.fer.zgmetro.model.Node;

public class ShortestDistance implements ShortestDistanceAlgorithm {

	@Override
	public int calculateShortestDistance(Graph graph, String startNode, String endNode) {

		TreeMap<Integer, Node> open = new TreeMap<>();
		open.put(0, graph.getNodeByName(startNode));
		int done;

		if (startNode.equals(endNode))
			done = -1;
		else
			done = 0;

		Set<Node> visited = new HashSet<>();

		while (!open.isEmpty()) {
			int dist = open.firstKey();
			Node node = open.get(open.firstKey());
			open.remove(open.firstKey());

			if (done != -1)
				visited.add(node);
			if (node.getName().equals(endNode)) {
				++done;
			}

			if (done == 1)
				return dist;

			for (Entry<Node, Integer> e : node.getSuccessors().entrySet()) {
				if (!visited.contains(e.getKey()))
					open.put(e.getValue() + dist, e.getKey());
			}
		}
		return -1;
	}
}
