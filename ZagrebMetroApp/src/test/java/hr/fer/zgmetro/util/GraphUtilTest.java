package hr.fer.zgmetro.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import hr.fer.zgmetro.algorithm.DijkstrasAlgorithm;
import hr.fer.zgmetro.algorithm.ShortestDistanceAlgorithm;
import hr.fer.zgmetro.algorithm.TripDistanceAlgorithm;
import hr.fer.zgmetro.model.Graph;
import hr.fer.zgmetro.model.Path;
import hr.fer.zgmetro.model.loader.FileLoader;
import hr.fer.zgmetro.model.loader.IGraphLoader;
import junit.framework.TestCase;

public class GraphUtilTest extends TestCase {

	protected Graph graph;

	@Override
	protected void setUp() throws Exception {
		IGraphLoader graphLoader = new FileLoader("src/main/resources/metro.txt");
		graph = graphLoader.load();
	}

	public void testShortestDistance() {
		ShortestDistanceAlgorithm sda = new DijkstrasAlgorithm();
		int distance = GraphUtil.calculateShortestDistance(graph, "MAKSIMIR", "DUBRAVA", sda);
		assertEquals(distance, 7);
	}

	public void testTripCounter() {
		List<Path> list = GraphUtil.findTripsWithStopsLimit(graph, "MAKSIMIR", "SPANSKO", 4);
		assertEquals(list.size(), 3);
	}

	public void testRoundTripCounter() {
		List<Path> list = GraphUtil.findRoundTripsWithStopsLimit(graph, "SPANSKO", 3);
		assertEquals(list.size(), 2);
	}

	public void testTripDistance() {
		// Case 1
		ArrayList<String> trip = new ArrayList<String>();
		int distance;
		trip.clear();
		trip.add("MAKSIMIR");
		trip.add("SIGET");
		trip.add("SPANSKO");
		distance = GraphUtil.calculateTripDistance(graph, trip);
		assert (distance == 9);

		// Case 2
		trip.clear();
		trip.add("MAKSIMIR");
		trip.add("MEDVESCAK");
		distance = GraphUtil.calculateTripDistance(graph, trip);
		assert (distance == 5);

		// Case 3
		trip.clear();
		trip.add("MAKSIMIR");
		trip.add("MEDVESCAK");
		trip.add("SPANSKO");
		distance = GraphUtil.calculateTripDistance(graph, trip);
		assert (distance == 13);

		// Case 4
		trip.clear();
		trip.add("MAKSIMIR");
		trip.add("DUBRAVA");
		trip.add("SIGET");
		trip.add("SPANSKO");
		trip.add("MEDVESCAK");
		distance = GraphUtil.calculateTripDistance(graph, trip);
		assert (distance == 22);
	}

	public void testTripDistanceWithNoSuchRoute() {
		ArrayList<String> trip = new ArrayList<String>();
		int distance;
		trip.clear();
		trip.add("MAKSIMIR");
		trip.add("DUBRAVA");
		trip.add("MEDVESCAK");
		distance = GraphUtil.calculateTripDistance(graph, trip);
		assert (distance == -1);
	}
}
