package hr.fer.zgmetro.model;

import java.util.HashMap;
import java.util.Map;

public class Graph {

	private HashMap<String, Node> nodes;

	public Graph(HashMap<String, Node> nodes) {
		this.nodes = nodes;
	}

	public Node getNodeByName(String name) {
		return nodes.get(name);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, Node> e : nodes.entrySet()) {
			Node currentNode = e.getValue();
			HashMap<Node, Integer> successors = currentNode.getSuccessors();
			for (Map.Entry<Node, Integer> succ : successors.entrySet()) {
				// Add line in format : "From <start> to <end> -> <distance>"
				sb.append("From ").append(e.getKey()).append(" to ").append(succ.getKey().getName()).append(" -> ")
						.append(succ.getValue()).append("\n");
			}
		}

		return sb.toString();
	}

}
