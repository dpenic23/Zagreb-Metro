package hr.fer.zgmetro.algorithm;

import hr.fer.zgmetro.model.Graph;

public interface ShortestDistanceAlgorithm {

	int calculateShortestDistance(Graph graph, String startNode, String endNode);

}
