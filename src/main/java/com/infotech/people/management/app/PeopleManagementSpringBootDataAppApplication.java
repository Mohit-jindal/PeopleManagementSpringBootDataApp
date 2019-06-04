package com.infotech.people.management.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infotech.people.management.app.entities.Person;
import com.infotech.people.management.app.service.PeopleManagementService;

@SpringBootApplication
public class PeopleManagementSpringBootDataAppApplication implements CommandLineRunner
{

	@Autowired
	private PeopleManagementService peopleManagementService;
	
	public static void main(String[] args) {
		SpringApplication.run(PeopleManagementSpringBootDataAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		//createPerson();
		//createPersons();
		//getPersonByIds();
		//deletePersonEntity();
		updatePersonEmailById();
	}

	private void updatePersonEmailById()
	{
		peopleManagementService.updatePersonEmailById(2,"barry.j2017@gmail.com");
	}
	
	private void deletePersonEntity()
	{
		Person person = new Person();
		person.setId(3);
		peopleManagementService.deletePersonEntity(person);
	}
	
	private void getPersonByIds()
	{
		List<Integer> ids = new ArrayList<>();
		ids.add(2);
		ids.add(3);
		ids.add(20);
		
		Iterable<Person> personList = peopleManagementService.getPersonByIds(ids);
		personList.forEach(System.out::println);
	}
	
	private void createPersons() 
	{
		List<Person> personList = Arrays.asList(new Person("Barry", "Johnson", "barry@yahoo.com", new Date()),
				new Person("Kishan", "kumar", "kishan@yahoo.com", new Date()));
		Iterable<Person> createPersons = peopleManagementService.createPersons(personList);
		for(Person person : createPersons)
		{
			System.out.println(person);
		}
	}

	private void createPerson()
	{
		Person person = new Person("Sean", "Muphy", "sean@yahoo.com", new Date());
		Person personDb = peopleManagementService.createPerson(person);
	}
}
