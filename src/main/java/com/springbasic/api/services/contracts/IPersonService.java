package com.springbasic.api.services.contracts;

import com.springbasic.api.model.Person;

import java.util.List;

public interface IPersonService {
    Person findById(Long id);
    List<Person> findAll();
    Person create(Person person);
    Person update(Person person, Long id);
    void delete(Long id);
}
