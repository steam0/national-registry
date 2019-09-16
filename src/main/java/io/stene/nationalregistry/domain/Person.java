package io.stene.nationalregistry.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    Integer id;
    @JsonProperty("ssn")
    String socialSecurityNumber;
    String name;
    String address;
}
