package com.example.distanceservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.distanceservice.converter.DistanceConverter;
import com.example.distanceservice.response.Response;

@SpringBootApplication
@RestController
public class DistanceserviceApplication {

	@Autowired
  	private DistanceConverter converter;

  	@GetMapping("/convert")
	public String convert(
			@RequestParam double distance1,
			@RequestParam String unit1,
			@RequestParam double distance2,
			@RequestParam String unit2,
			@RequestParam String outputUnit
	) {
		double total = converter.convert(distance1, unit1, distance2, unit2, outputUnit);

		return new Response(total, outputUnit).toString();

	}

	public static void main(String[] args) {
		SpringApplication.run(DistanceserviceApplication.class, args);
	}

}