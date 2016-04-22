package hr.fer.zgmetro;

import java.util.ArrayList;

import hr.fer.zgmetro.algorithms.TripDistance;
import hr.fer.zgmetro.model.Graph;
import java.io.IOException;
import hr.fer.zgmetro.model.loader.FileLoader;


/**
 * Tester
 *
 */
public class App {

	public static void main(String[] args) {
		FileLoader loader;
		try {
			loader = new FileLoader("metro.txt");
			Graph graph = loader.load();
		
			System.out.println(graph.toString());
			
			// Testing TripDistance algorithm
			System.out.println("\nTesting TripDistance algorithm.");
			ArrayList<String> trip = new ArrayList<String>();
						
			//Case 1
			trip.clear();
			trip.add("MAKSIMIR");
			trip.add("SIGET");
			trip.add("SPANSKO");
			System.out.println("distance 1 = " + TripDistance.calculate(graph,trip));
			
			//Case 2
			trip.clear();
			trip.add("MAKSIMIR");
			trip.add("MEDVESCAK");
			System.out.println("distance 2 = " + TripDistance.calculate(graph,trip));
			
			//Case 3
			trip.clear();
			trip.add("MAKSIMIR");
			trip.add("MEDVESCAK");
			trip.add("SPANSKO");
			System.out.println("distance 3 = " + TripDistance.calculate(graph,trip));
			
			//Case 4
			trip.clear();
			trip.add("MAKSIMIR");
			trip.add("DUBRAVA");
			trip.add("SIGET");
			trip.add("SPANSKO");
			trip.add("MEDVESCAK");
			System.out.println("distance 4 = " + TripDistance.calculate(graph,trip));
			
			//Case 5
			trip.clear();
			trip.add("MAKSIMIR");
			trip.add("DUBRAVA");
			trip.add("MEDVESCAK");
			System.out.println("distance 5 = " + TripDistance.calculate(graph,trip));
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
