package hr.fer.zgmetro;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import hr.fer.zgmetro.algorithms.TripDistance;
import hr.fer.zgmetro.model.Graph;
import hr.fer.zgmetro.model.Trip;
import hr.fer.zgmetro.model.loader.FileLoader;

public class AppJSON {

	
	public static void main(String[] args) throws IOException {
		
		FileLoader loader = new FileLoader("metro.txt");
		Graph graph = loader.load();
		
		ObjectMapper mapper = new ObjectMapper();
		
		Trip trip = mapper.readValue(new File("./inputJSON/graph.json"), Trip.class);
		Trip trip2 = mapper.readValue(new File("./inputJSON/graph2.json"), Trip.class);
		Trip trip3 = mapper.readValue(new File("./inputJSON/graph3.json"), Trip.class);
		Trip trip4 = mapper.readValue(new File("./inputJSON/graph4.json"), Trip.class);
		
		String dist = TripDistance.calculate(graph, trip.getStations());
		String dist2 = TripDistance.calculate(graph, trip2.getStations());
		String dist3 = TripDistance.calculate(graph, trip3.getStations());
		String dist4 = TripDistance.calculate(graph, trip4.getStations());
		
		System.out.println("Distance: " + dist);	//MAKSIMIR-SIGET-SPANSKO
		System.out.println("Distance: "+ dist2);	//MAKSIMIR-DUBRAVA-SIGET-SPANSKO-MEDVESCAK
		System.out.println("Distance: "+ dist3);	//MAKSIMIR-DUBRAVA-MEDVESCAK
	//	System.out.println("Distance: "+ dist4);	//MAKSIMIR-MAKSIMIR, TODO treba ispisat 5!!!
	}
}
