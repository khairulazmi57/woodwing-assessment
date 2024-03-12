package com.example.distanceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DistanceserviceApplication {

	@GetMapping("/convert")
	public double convert(
			@RequestParam double distance1,
			@RequestParam String unit1,
			@RequestParam double distance2,
			@RequestParam String unit2,
			@RequestParam String outputUnit) {
		DistanceConverter converter = new DistanceConverter();
		return converter.convert(distance1, unit1, distance2, unit2, outputUnit);

	}

	@GetMapping("/convert2")
	public Response convert2(
			@RequestParam double distance1,
			@RequestParam String unit1,
			@RequestParam double distance2,
			@RequestParam String unit2,
			@RequestParam String outputUnit
	) {

		DistanceConverter converter = new DistanceConverter();
		double total = converter.convert(distance1, unit1, distance2, unit2, outputUnit);

		return new Response(total, outputUnit);

	}

	public static void main(String[] args) {
		SpringApplication.run(DistanceserviceApplication.class, args);
	}

}

class Response {

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

}

class DistanceConverter {

	double convert(double distance1, String unit1, double distance2, String unit2, String outputUnit) {

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

		return total;

	}

	double yardsToMeters(double yards) {
		return yards * 0.9144;
	}

	double metersToYards(double meters) {
		return meters / 0.9144;
	}

}