package io.pivotal.workshop.model;

public class Limits {

	private int maximum;
	private int minimum;

	public Limits() {
		super();
	}

	public Limits(int maximum, int minimum) {
		this.maximum = maximum;
		this.minimum = minimum;
	}

	public int getMaximum() {
		return maximum;
	}

	public int getMinimum() {
		return minimum;
	}
}
