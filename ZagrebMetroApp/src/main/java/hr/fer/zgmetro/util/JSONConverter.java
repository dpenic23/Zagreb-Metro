package hr.fer.zgmetro.util;

import org.codehaus.jackson.map.ObjectMapper;

import hr.fer.zgmetro.json.Distance;
import hr.fer.zgmetro.json.PairOfStations;
import hr.fer.zgmetro.json.PathsWithStops;
import hr.fer.zgmetro.json.Stations;
import hr.fer.zgmetro.json.StationsWithStops;

public class JSONConverter {

	public static Stations convertJSONStringToStations(String jsonStations) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();

		Stations stations = objectMapper.readValue(jsonStations, Stations.class);

		return stations;
	}

	public static Distance convertJSONStringToDistance(String jsonDistance) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();

		Distance distance = objectMapper.readValue(jsonDistance, Distance.class);

		return distance;
	}

	public static String convertDistanceToJSONString(Distance distance) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(distance);
	}

	public static PairOfStations convertJSONStringToPairOfStations(String jsonPairOfStations) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();

		PairOfStations pairOfStations = objectMapper.readValue(jsonPairOfStations, PairOfStations.class);

		return pairOfStations;
	}

	public static String convertPathsWithStopstoJSONString(PathsWithStops paths) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(paths);
	}

	public static StationsWithStops convertJSONStringtoStationsWithStops(String jsonStationsWithStops)
			throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();

		StationsWithStops stationsWithStops = objectMapper.readValue(jsonStationsWithStops, StationsWithStops.class);

		return stationsWithStops;

	}

}
