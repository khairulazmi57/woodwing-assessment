package com.example.distanceservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.distanceservice.converter.DistanceConverter;

@SpringBootTest // Unit test
class DistanceserviceApplicationTests {

	@Autowired
	private DistanceserviceApplication app;

	@MockBean
	private DistanceConverter converter;

	@Test
	public void testConvert() {

		when(converter.convert(3, "Yards", 5, "Meters", "Meters")).thenReturn(7.74);

		String response = app.convert(3, "Yards", 5, "Meters", "Meters");

		assertEquals("total = 7.74 Meters", response);

	}

	@Test
	public void testYardsToMeters() {
		when(converter.yardsToMeters(1)).thenReturn(0.9144);
		
		assertEquals(0.9144, converter.yardsToMeters(1));

	}

}
