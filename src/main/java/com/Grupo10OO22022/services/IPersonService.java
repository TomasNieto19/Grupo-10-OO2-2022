package com.Grupo10OO22022.services;
import java.util.List;

import com.Grupo10OO22022.entities.Person;
import com.Grupo10OO22022.models.PersonModel;


public interface IPersonService {

	public List<Person> getAll();
	
	public Person findById(int id);
	
	public PersonModel findByName(String name);
	
	public PersonModel insertOrUpdate(Person person);
	
	public boolean remove(int id);
	
	public List<PersonModel> findByDegreeName(String degreeName);
}

