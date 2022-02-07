package com.reto.fullstack.ApiRestful;
import com.reto.fullstack.ApiRestful.exception.BadRequestException;
import com.reto.fullstack.ApiRestful.model.entities.Person;
import com.reto.fullstack.ApiRestful.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class ApiRestfulApplicationTests {
	private PersonService personService;
	@Test
	void contextLoads() {
	}
	@Test
	public void testRegistrarPerson() throws BadRequestException {
		Person newperson = new Person("Luis Arango",new Date("2016-10-08"),"Ines","Roberto","Laura");
		personService.create(newperson);

	}


}
