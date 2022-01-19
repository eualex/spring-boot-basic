package com.springbasic.api.services.contracts;

import com.springbasic.api.model.Person;

import java.util.List;

public interface IPersonService {
    Person findPersonById(String id);
    List<Person> findAllPerson();
}
