package hr.fer.zgmetro.json;

import java.io.Serializable;
import java.util.List;

public class Stations implements Serializable {

	/**
	 * Default serial version ID.
	 */
	private static final long serialVersionUID = 1L;

	private List<String> stations;

	public List<String> getStations() {
		return stations;
	}

	public void setStations(List<String> stations) {
		this.stations = stations;
	}

}
