package hr.fer.zgmetro.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hr.fer.zgmetro.model.loader.IGraphLoader;

public class Graph {
	
	private HashMap<String, Node> nodes;
	
	public Graph(HashMap<String, Node> nodes) {
		this.nodes = nodes;
	}
	
	public Node getNodeByName(String name)	{
		return nodes.get(name);
	}
	
}
