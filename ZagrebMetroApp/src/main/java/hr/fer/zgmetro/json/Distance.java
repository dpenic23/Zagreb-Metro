package hr.fer.zgmetro.json;

import java.io.Serializable;

public class Distance implements Serializable {

	/**
	 * Default serial version ID.
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	private int distance;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

}
