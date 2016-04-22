package hr.fer.zgmetro.console;

import java.io.IOException;
import java.util.ArrayList;

import hr.fer.zgmetro.algorithms.TripCounter;
import hr.fer.zgmetro.algorithms.TripDistance;
import hr.fer.zgmetro.model.Graph;
import hr.fer.zgmetro.model.loader.FileLoader;

public class ZagrebMetroConsoleApp {
	public static void main(String[] args) {
		FileLoader loader;
		try {
			loader = new FileLoader("metro.txt");
			Graph graph = loader.load();

			System.out.println(graph.toString());

			// Testing TripDistance algorithm METRO-2
			System.out.println("\nTesting TripDistance algorithm.");
			ArrayList<String> trip = new ArrayList<String>();

			// Case 1
			trip.clear();
			trip.add("MAKSIMIR");
			trip.add("SIGET");
			trip.add("SPANSKO");
			System.out.println("distance 1 = " + TripDistance.calculate(graph, trip));

			// Case 2
			trip.clear();
			trip.add("MAKSIMIR");
			trip.add("MEDVESCAK");
			System.out.println("distance 2 = " + TripDistance.calculate(graph, trip));

			// Case 3
			trip.clear();
			trip.add("MAKSIMIR");
			trip.add("MEDVESCAK");
			trip.add("SPANSKO");
			System.out.println("distance 3 = " + TripDistance.calculate(graph, trip));

			// Case 4
			trip.clear();
			trip.add("MAKSIMIR");
			trip.add("DUBRAVA");
			trip.add("SIGET");
			trip.add("SPANSKO");
			trip.add("MEDVESCAK");
			System.out.println("distance 4 = " + TripDistance.calculate(graph, trip));

			// Case 5
			trip.clear();
			trip.add("MAKSIMIR");
			trip.add("DUBRAVA");
			trip.add("MEDVESCAK");
			System.out.println("distance 5 = " + TripDistance.calculate(graph, trip));

			// Testing TripCounter algorithm METRO-3 METRO-4
			String station;
			System.out.println("Testing TripCounter algorithm.");

			// Case 1
			station = "SPANSKO";
			for (int i = 1; i <= 3; i++)
				System.out.println("roundtrips 1 = " + TripCounter.calculate(graph, station, station, i).toString());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
