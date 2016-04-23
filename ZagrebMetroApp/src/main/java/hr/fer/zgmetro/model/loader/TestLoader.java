package hr.fer.zgmetro.model.loader;

import java.util.HashMap;

import hr.fer.zgmetro.model.Graph;
import hr.fer.zgmetro.model.Node;

public class TestLoader implements IGraphLoader {

	@Override
	public Graph load() {
		HashMap<String, Node> nodes = new HashMap<>();
		
		//Create metro stations
		Node maksimir = new Node("MAKSIMIR");
		Node siget = new Node("SIGET");
		Node spansko = new Node("SPANSKO");
		Node medvescak = new Node("MEDVESCAK");
		Node dubrava = new Node("DUBRAVA");
		
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
		nodes.put("MAKSIMIR", maksimir);
		nodes.put("SIGET", siget);
		nodes.put("SPANSKO", spansko);
		nodes.put("MEDVESCAK", medvescak);
		nodes.put("DUBRAVA", dubrava);
		
		return new Graph(nodes);
				
	}

}
