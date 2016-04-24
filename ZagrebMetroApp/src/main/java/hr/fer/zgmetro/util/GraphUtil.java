package hr.fer.zgmetro.util;

import java.util.List;

import hr.fer.zgmetro.algorithm.TripDistanceImpl;
import hr.fer.zgmetro.algorithm.DijkstrasAlgorithm;
import hr.fer.zgmetro.algorithm.ShortestDistanceAlgorithm;
import hr.fer.zgmetro.algorithm.TripCounterImpl;
import hr.fer.zgmetro.algorithm.TripCounterAlgorithm;
import hr.fer.zgmetro.algorithm.TripDistanceAlgorithm;
import hr.fer.zgmetro.model.Graph;
import hr.fer.zgmetro.model.Path;

public class GraphUtil {

	private static TripDistanceAlgorithm DEFAULT_TRIP_DIST_ALG = new TripDistanceImpl();
	private static ShortestDistanceAlgorithm DEFAULT_SHORTEST_DIST_ALG = new DijkstrasAlgorithm();
	private static TripCounterAlgorithm DEFAULT_TRIP_COUNTER_ALG = new TripCounterImpl();

	public static int calculateTripDistance(Graph graph, List<String> trip) {
		return calculateTripDistance(graph, trip, DEFAULT_TRIP_DIST_ALG);
	}

	public static int calculateTripDistance(Graph graph, List<String> trip, TripDistanceAlgorithm algorithm) {
		return algorithm.calculateTripDistance(graph, trip);
	}

	public static int calculateShortestDistance(Graph graph, String startNode, String endNode) {
		return calculateShortestDistance(graph, startNode, endNode, DEFAULT_SHORTEST_DIST_ALG);
	}

	public static int calculateShortestDistance(Graph graph, String startNode, String endNode,
			ShortestDistanceAlgorithm algorithm) {
		return algorithm.calculateShortestDistance(graph, startNode, endNode);
	}

	public static List<Path> findTripsWithStopsLimit(Graph graph, String startNode, String endNode, int stops) {
		return findTripsWithStopsLimit(graph, startNode, endNode, stops, DEFAULT_TRIP_COUNTER_ALG);
	}

	public static List<Path> findTripsWithStopsLimit(Graph graph, String startNode, String endNode, int stops,
			TripCounterAlgorithm algorithm) {
		return algorithm.findTripsWithStopsLimit(graph, startNode, endNode, stops);
	}

	public static List<Path> findRoundTripsWithStopsLimit(Graph graph, String node, int stops) {
		return findRoundTripsWithStopsLimit(graph, node, stops, DEFAULT_TRIP_COUNTER_ALG);
	}

	public static List<Path> findRoundTripsWithStopsLimit(Graph graph, String node, int stops,
			TripCounterAlgorithm algorithm) {
		return algorithm.findRoundTripsWithStopsLimit(graph, node, stops);
	}
}
