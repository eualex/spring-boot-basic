package com.springbasic.api.services;

import com.springbasic.api.exception.ResourceNotFoundException;
import com.springbasic.api.model.Person;
import com.springbasic.api.repository.PersonRepository;
import com.springbasic.api.services.contracts.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements IPersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

     public Person findById(Long id) {
         return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
             "Nenhum registro foi encontrado para este ID!"
         ));
     }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person create(Person person) {
        return personRepository.save(person);
    }

    public Person update(Person person, Long id) {
        Person personEntity = personRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Nenhum registro foi encontrado para este ID!")
        );

        personEntity.setFirstName(person.getFirstName());
        personEntity.setLastName(person.getLastName());
        personEntity.setAddress(person.getAddress());
        personEntity.setGender(person.getGender());

        return personRepository.save(personEntity);
    }

    @Override
    public void delete(Long id) {
        Person personEntity = personRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Nenhum registro foi encontrado para este ID!")
        );

        personRepository.delete(personEntity);
    }
}
