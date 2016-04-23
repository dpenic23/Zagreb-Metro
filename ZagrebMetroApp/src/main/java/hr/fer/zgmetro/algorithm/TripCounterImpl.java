package hr.fer.zgmetro.algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import hr.fer.zgmetro.model.Graph;
import hr.fer.zgmetro.model.Node;
import hr.fer.zgmetro.model.Path;

public class TripCounterImpl implements TripCounterAlgorithm {
	
	@Override
	public List<Path> findTripsWithStopsLimit(Graph graph, String startNode, String endNode, int stopLimit) {

		List<Path> paths = new LinkedList<>();

		for (LinkedList<String> l : recursion(graph, startNode, endNode, stopLimit)) {
			paths.add(new Path(l));
		}
		
		return paths;
	}

	public static LinkedList<LinkedList<String>> recursion(Graph graph, String state, String goal, int n) {
		LinkedList<LinkedList<String>> ret = new LinkedList<>();

		if (n == 0) {
			if (state.equals(goal)) {
				LinkedList<String> l = new LinkedList<>();
				l.add(state);
				ret.add(l);
				return ret;
			}
			return ret;
		}

		Node node = graph.getNodeByName(state);

		Map<Node, Integer> succ = node.getSuccessors();

		for (Entry<Node, Integer> e : succ.entrySet()) {
			LinkedList<LinkedList<String>> tmp = recursion(graph, e.getKey().getName(), goal, n - 1);
			if (tmp.isEmpty())
				continue;
			for (LinkedList<String> l : tmp)
				l.addFirst(state);
			ret.addAll(tmp);
		}

		return ret;
	}



	@Override
	public List<Path> findRoundTripsWithStopsLimit(Graph graph, String node, int stopLimit) {
		List<Path> ret = new LinkedList<>();
		for(int i = 1; i <= stopLimit; ++i) {
			ret.addAll(findTripsWithStopsLimit(graph, node, node, i));
		}
		return ret;
	}
}
