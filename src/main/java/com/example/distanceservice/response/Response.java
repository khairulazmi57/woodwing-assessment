package com.example.distanceservice.response;

public class Response {

	private double total;
	private String unit;

	public Response(double total, String unit) {
		this.total = total;
		this.unit = unit;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public String toString() {
		return "total = " + total + " " + unit;
	}

}