package hr.fer.zgmetro.model.loader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hr.fer.zgmetro.model.Graph;
import hr.fer.zgmetro.model.Node;

public class FileLoader implements IGraphLoader {

	private Map<String, String> edgesMap = new HashMap<>();
	private HashMap<String, Node> nodes = new HashMap<>();
	private Graph graph;

	public FileLoader(String filename) throws IOException {
		String path = "./inputFiles/" + filename.trim();
	
		List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);

		String line = lines.get(0);
		parse(line);
		graph = new Graph(nodes);

	}

	private void parse(String line) {
		String[] edges = line.trim().split(",");
		for (String e : edges) {
			String[] splitEdgeFromDistance = e.split(":");
			edgesMap.put(splitEdgeFromDistance[0], splitEdgeFromDistance[1]);
		}
		createNodes(edgesMap);
	}

	private void createNodes(Map<String, String> edges) {

		for (Map.Entry<String, String> e : edges.entrySet()) {

			int distance = Integer.parseInt(e.getValue());
			String[] stationNode = e.getKey().split("-");
			String firstStation = stationNode[0].trim();
			String secondStation = stationNode[1].trim();
			Node node1;
			Node node2;

			if (!nodes.containsKey(firstStation)) {
				node1 = new Node(firstStation);
				nodes.put(firstStation, node1);

			} else {
				node1 = nodes.get(firstStation);
			}

			if (!nodes.containsKey(secondStation)) {
				node2 = new Node(secondStation);
				nodes.put(secondStation, node2);
			} else {
				node2 = nodes.get(secondStation);
			}

			node1.addSuccessor(node2, distance);
		}
	}

	@Override
	public Graph load() {
		return graph;
	}

}
