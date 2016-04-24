package hr.fer.zgmetro.json;

import java.util.List;

public class PathsWithStops {

	private int count;
	private List<String> stops;

	public PathsWithStops(int count, List<String> stops) {
		this.count = count;
		this.stops = stops;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<String> getstops() {
		return stops;
	}

	public void setstops(List<String> stops) {
		this.stops = stops;
	}

}
