package hr.fer.zgmetro.model;

import java.util.HashMap;
import hr.fer.zgmetro.model.loader.IGraphLoader;

public class Graph {
	
	private HashMap<String, Node> nodes;
	
	public Graph(HashMap<String, Node> nodes) {
		this.nodes = nodes;
	}
	
	public Node getNodeByName(String name)	{
		return nodes.get(name);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, Node> e : nodes.entrySet()) {
			Node currentNode = e.getValue();
			HashMap<Node, Integer> successors = currentNode.getSuccessors();
			for (Map.Entry<Node,Integer> succ : successors.entrySet()) {
				sb.append("From "+e.getKey() + " to " + succ.getKey().getName() + "-> "+succ.getValue() + "\n");
			}
		}
		
		return sb.toString();
	}
	
	
}
