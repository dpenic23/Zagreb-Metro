package hr.fer.zgmetro;

import java.io.IOException;

import hr.fer.zgmetro.model.Graph;
import hr.fer.zgmetro.model.loader.FileLoader;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) throws IOException {
		System.out.println("Hello World!");
		System.out.println("Bok");
		System.out.println("test");
		System.out.println("hari smrdi");
		FileLoader loader;
		Graph graph;
		
			loader = new FileLoader("metro.txt");
			graph = loader.load();
			System.out.println(graph.toString());
		
		
		
	
		
	}

}
