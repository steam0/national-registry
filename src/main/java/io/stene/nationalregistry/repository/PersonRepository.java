package io.stene.nationalregistry.repository;

import io.stene.nationalregistry.domain.Person;
import io.stene.nationalregistry.validator.SSNValidator;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PersonRepository {

    private static int ID_COUNTER = 1;

    Map<Integer, Person> map = new HashMap<>();

    public Person add(Person person) {
        SSNValidator.validate(person.getSocialSecurityNumber());
        person.setId(ID_COUNTER++);
        map.put(person.getId(), person);

        return person;
    }

    public Person get(Integer id) {
        return map.get(id);
    }

    public Person getBySSn(String ssn) {
        return map.values().stream()
                .filter(person -> person.getSocialSecurityNumber().equals(ssn))
                .findFirst().orElse(null);
    }
}
