package hr.fer.zgmetro.console;

import hr.fer.zgmetro.model.Graph;
import hr.fer.zgmetro.model.loader.FileLoader;

public class ZagrebMetroConsoleApp {
	public static void main(String[] args) {
		FileLoader loader = new FileLoader("src/main/resources/metro.txt");
		Graph graph = loader.load();

		System.out.println(graph.toString());
	}
}
