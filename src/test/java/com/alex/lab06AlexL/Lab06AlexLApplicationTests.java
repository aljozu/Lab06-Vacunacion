package com.alex.lab06alexl;

import java.util.logging.Logger;

import com.alex.lab06alexl.persona.Persona;
import com.alex.lab06alexl.persona.PersonaController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;

@SpringBootTest
class Lab06AlexLApplicationTests {
	static final Logger logger = Logger.getLogger(Lab06AlexLApplicationTests.class.getName());

	@Autowired
	private PersonaController controller;

	@Test
	void contextLoads() {
		Assertions.assertNotNull(controller);
	}

	@Test
	void expectedGetPersona() {
		var persona = controller.getPersonaByDNI("48874885");
		Assertions.assertEquals("48874885", persona.getId());
	}

	@Test
	void expectedTime() {
		Persona persona = controller.getPersonaByDNI("48874885");
		long start = System.currentTimeMillis();
		persona.getFdv();
		long end = System.currentTimeMillis();
		long duration = end - start;
		logger.info(Long.toString(duration));
		Assertions.assertTrue(duration <= 400);
	}

}
