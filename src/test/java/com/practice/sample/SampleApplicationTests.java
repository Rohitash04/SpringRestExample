package com.practice.sample;

import com.practice.sample.controller.SampleController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SampleApplicationTests {

	@Autowired
	SampleController sampleController;

	@Test
	void contextLoads() {
		Assertions.assertNotNull(sampleController);
	}

}
