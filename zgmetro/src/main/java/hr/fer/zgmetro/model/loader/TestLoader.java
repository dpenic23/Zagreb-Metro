package hr.fer.zgmetro.model.loader;

import java.util.HashMap;

import hr.fer.zgmetro.model.Graph;
import hr.fer.zgmetro.model.Node;

public class TestLoader implements IGraphLoader {

	@Override
	public Graph load() {
		HashMap<String, Node> nodes = new HashMap<>();
		
		//Create metro stations
		Node maksimir = new Node("Maksimir");
		Node siget = new Node("Siget");
		Node spansko = new Node("Spansko");
		Node medvescak = new Node("Medvescak");
		Node dubrava = new Node("Dubrava");
		
		//Add transitions
		maksimir.addSuccessor(siget, 5);
		siget.addSuccessor(spansko, 4);
		spansko.addSuccessor(medvescak, 8);
		medvescak.addSuccessor(spansko, 8);
		medvescak.addSuccessor(dubrava, 6);
		maksimir.addSuccessor(medvescak, 5);
		spansko.addSuccessor(dubrava, 2);
		dubrava.addSuccessor(siget, 3);
		maksimir.addSuccessor(dubrava, 7);

		//Add nodes to map
		nodes.put("Maksimir", maksimir);
		nodes.put("Siget", siget);
		nodes.put("Spansko", spansko);
		nodes.put("Medvescak", medvescak);
		nodes.put("Dubrava", dubrava);
		
		return new Graph(nodes);
				
	}

}
