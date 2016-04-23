package hr.fer.zgmetro.algorithm;

import java.util.List;

import hr.fer.zgmetro.model.Graph;

public interface TripDistanceAlgorithm {

	int calculateTripDistance(Graph graph, List<String> trip);

}
