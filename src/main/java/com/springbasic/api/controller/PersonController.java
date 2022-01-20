package com.springbasic.api.controller;

import com.springbasic.api.model.Person;

import com.springbasic.api.services.contracts.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Person> findById(@PathVariable Long id) throws Exception {
        Person person = personService.findById(id);

        return ResponseEntity.ok(person);
    }

    @GetMapping
    public ResponseEntity<List<Person>> findAll() {
        List<Person> persons = personService.findAll();

        return ResponseEntity.ok(persons);
    }

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody Person person) {
        Person personResponse = personService.create(person);

        return ResponseEntity.status(HttpStatus.CREATED).body(personResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@RequestBody Person person, @PathVariable Long id) {
        Person personResponse = personService.update(person, id);

        return ResponseEntity.ok(personResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id) {
        personService.delete(id);

        return ResponseEntity.ok().build();
    }
}
