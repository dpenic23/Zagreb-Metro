package hr.fer.zgmetro.algorithm;

import java.util.HashMap;
import java.util.List;

import hr.fer.zgmetro.model.Graph;
import hr.fer.zgmetro.model.Node;

public class TripDistanceImpl implements TripDistanceAlgorithm {

	@Override
	public int calculateTripDistance(Graph graph, List<String> trip) {
		int totalDistance = 0;

		for (int i = 0; i < trip.size() - 1; i++) {
			Node currentNode = graph.getNodeByName(trip.get(i));
			Node nextNode = graph.getNodeByName(trip.get(i + 1));
			HashMap<Node, Integer> successors = currentNode.getSuccessors();

			Integer distance = successors.get(nextNode);
			if (distance != null) {
				totalDistance += distance.intValue();
			} else {
				return -1;
			}
		}

		return totalDistance;
	}

}
