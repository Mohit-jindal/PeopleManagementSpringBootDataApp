package com.infotech.people.management.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infotech.people.management.app.entities.Person;

@Repository
public interface PeopleManagementDao extends CrudRepository<Person, Integer> 
{

	
}
