package com.example.distanceservice.converter;

import org.springframework.stereotype.Component;

@Component
public class DistanceConverter {

	public double convert(double distance1, String unit1, double distance2, String unit2, String outputUnit) {

		double total;

		if (unit1.equals("Yards")) {
			distance1 = yardsToMeters(distance1);
		}

		if (unit2.equals("Yards")) {
			distance2 = yardsToMeters(distance2);
		}

		total = distance1 + distance2;

		if (outputUnit.equals("Yards")) {
			total = metersToYards(total);
		}

		return (double) Math.round(total * 100) / 100;

	}

	public double yardsToMeters(double yards) {
		return yards * 0.9144;
	}

	public double metersToYards(double meters) {
		return meters / 0.9144;
	}

}