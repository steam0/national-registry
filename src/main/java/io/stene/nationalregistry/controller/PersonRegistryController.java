package io.stene.nationalregistry.controller;

import io.stene.nationalregistry.domain.Person;
import io.stene.nationalregistry.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class PersonRegistryController {

    private PersonRepository personRepository;

    public PersonRegistryController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/v1/person", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Person createPerson(@RequestBody Person person) {
        return personRepository.add(person);
    }
}
