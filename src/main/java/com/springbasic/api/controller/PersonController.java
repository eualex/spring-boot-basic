package com.springbasic.api.controller;

import com.springbasic.api.model.Person;

import com.springbasic.api.services.contracts.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/person")
public class PersonController {

    private final IPersonService personService;

    @Autowired
    public PersonController(IPersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findPersonById(@PathVariable String id) throws Exception {
        Person person = personService.findPersonById(id);

        return ResponseEntity.ok(person);
    }

    @GetMapping()
    public ResponseEntity<List<Person>> findAllPerson() {
        List<Person> persons = personService.findAllPerson();

        return ResponseEntity.ok(persons);
    }
}
