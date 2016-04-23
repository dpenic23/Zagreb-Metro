package hr.fer.zgmetro.algorithm;

import java.util.List;

import hr.fer.zgmetro.model.Graph;
import hr.fer.zgmetro.model.Path;

public interface TripCounterAlgorithm {

	List<Path> findTripsWithStopsLimit(Graph graph, String startNode, String endNode, int stopLimit);

}
