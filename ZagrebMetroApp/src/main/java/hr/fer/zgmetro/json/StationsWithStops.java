package hr.fer.zgmetro.json;

import java.util.Map;

public class StationsWithStops {

	private Map<String, String> stations;

	public Map<String, String> getStations() {
		return stations;
	}

	public void setStations(Map<String, String> stations) {
		this.stations = stations;
	}

	public int getStops() {
		return stops;
	}

	public void setStops(int stops) {
		this.stops = stops;
	}

	private int stops;

}
