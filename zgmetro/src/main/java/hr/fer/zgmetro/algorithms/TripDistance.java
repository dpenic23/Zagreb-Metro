package hr.fer.zgmetro.algorithms;

import java.util.HashMap;
import java.util.List;

import hr.fer.zgmetro.model.Graph;
import hr.fer.zgmetro.model.Node;

public class TripDistance {

	
	public static String calculate(Graph graph, List<String> trip){
		
		int totalDistance = 0;
		for (int i=0; i<trip.size()-1; i++) {
			Node currentNode = graph.getNodeByName(trip.get(i));
			Node nextNode = graph.getNodeByName(trip.get(i+1));
			HashMap<Node, Integer> successors = currentNode.getSuccessors();
			
			Integer distance;
			if ((distance = successors.get(nextNode)) != null)
				totalDistance += distance.intValue();
			else
				return "NO SUCH ROUTE";
		}
		
		return totalDistance+"";
	}
	
}
