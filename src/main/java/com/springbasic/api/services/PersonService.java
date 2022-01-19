package com.springbasic.api.services;

import com.springbasic.api.model.Person;
import com.springbasic.api.services.contracts.IPersonService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService implements IPersonService {

     public Person findPersonById(String id) {
         Person person = mockPerson(id);

         return person;
     }

    public List<Person> findAllPerson() {
         List<Person> persons = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(Integer.toString(i + 1));

            persons.add(person);
        }

        return persons;
    }

    private Person mockPerson(String id) {
        Person person = new Person();

        person.setId(Long.parseLong(id));
        person.setFirstName("Pepeto");
        person.setLastName("Vava");
        person.setGender("Male");
        person.setAddress("Icebox - VAVA");

        return person;
    }
}
