package io.stene.nationalregistry.domain;

import lombok.Data;

@Data
public class Person {
    Integer id;
    String ssn;
    String name;
}
