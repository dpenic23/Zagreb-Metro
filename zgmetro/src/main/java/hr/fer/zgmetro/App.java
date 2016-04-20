package hr.fer.zgmetro;

import java.util.ArrayList;

import hr.fer.zgmetro.algorithms.TripDistance;
import hr.fer.zgmetro.model.Graph;
import hr.fer.zgmetro.model.loader.TestLoader;

/**
 * Tester
 *
 */
public class App {

	public static void main(String[] args) {
		TestLoader loader = new TestLoader();
		Graph graph = loader.load();
		
		System.out.println(graph.toString());
		
		// Testing TripDistance algorithm
		System.out.println("\nTesting TripDistance algorithm.");
		ArrayList<String> trip = new ArrayList<String>();
		
		//Case 1
		trip.add("Maksimir");
		trip.add("Siget");
		trip.add("Spansko");
		System.out.println("distance 1 = " + TripDistance.calculate(graph,trip));
	
	}

}
