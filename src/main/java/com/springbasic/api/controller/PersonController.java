package com.springbasic.api.controller;

import com.springbasic.api.dto.PersonDTO;
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
    public ResponseEntity<PersonDTO> findById(@PathVariable Long id) throws Exception {
        PersonDTO person = personService.findById(id);

        return ResponseEntity.ok(person);
    }

    @GetMapping
    public ResponseEntity<List<PersonDTO>> findAll() {
        List<PersonDTO> persons = personService.findAll();

        return ResponseEntity.ok(persons);
    }

    @PostMapping
    public ResponseEntity<PersonDTO> create(@RequestBody PersonDTO person) {
        PersonDTO personResponse = personService.create(person);

        return ResponseEntity.status(HttpStatus.CREATED).body(personResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDTO> update(@RequestBody PersonDTO person, @PathVariable Long id) {
        PersonDTO personResponse = personService.update(person, id);

        return ResponseEntity.ok(personResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id) {
        personService.delete(id);

        return ResponseEntity.ok().build();
    }
}
