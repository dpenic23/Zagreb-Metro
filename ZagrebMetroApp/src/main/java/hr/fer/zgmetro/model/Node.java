package hr.fer.zgmetro.model;

import java.util.HashMap;

public class Node {

	private String name;
	private HashMap<Node, Integer> successors;

	public Node(String name) {
		this.name = name;
		successors = new HashMap<>();
	}
	
	public void addSuccessor (Node node, int distance) {
		successors.put(node, distance);
	}

	public String getName() {
		return name;
	}

	public HashMap<Node, Integer> getSuccessors() {
		return successors;
	}

	public void addSuccessor(Node successor, Integer distance){
		successors.put(successor,distance );
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
