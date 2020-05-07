package com.zarrar.phonechess;

import java.awt.Point;

public class PhonePad {

	private String number = "";
	private Point coordinates = null;

	public PhonePad(String number, Point coordinates) {
		if (number != null && number.isEmpty() == false)
			this.number = number;
		else
			throw new IllegalArgumentException("Input cannot be null or empty.");

		if (coordinates == null || coordinates.x < 0 || coordinates.y < 0)
			throw new IllegalArgumentException();
		else
			this.coordinates = coordinates;

	}

	public String getNumber() {
		return this.number;
	}

	public Integer getNumberAsNumber() {
		return Integer.parseInt(this.number);
	}

	public Point getCoordinates() {
		return this.coordinates;
	}

	public int getX() {
		return this.coordinates.x;
	}

	public int getY() {
		return this.coordinates.y;
	}

}
