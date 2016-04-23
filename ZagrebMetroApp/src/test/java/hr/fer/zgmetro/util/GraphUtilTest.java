package hr.fer.zgmetro.util;

import hr.fer.zgmetro.algorithm.DijkstrasAlgorithm;
import hr.fer.zgmetro.algorithm.ShortestDistanceAlgorithm;
import hr.fer.zgmetro.model.Graph;
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

	
}
