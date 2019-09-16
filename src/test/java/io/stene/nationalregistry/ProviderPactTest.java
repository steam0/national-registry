package io.stene.nationalregistry;

import au.com.dius.pact.provider.junit.IgnoreNoPactsToVerify;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import au.com.dius.pact.provider.spring.SpringRestPactRunner;
import io.stene.nationalregistry.domain.Person;
import io.stene.nationalregistry.repository.PersonRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Provider("national-registry")
@IgnoreNoPactsToVerify
@PactBroker(host = "localhost", port = "3000")
@RunWith(SpringRestPactRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ProviderPactTest {

    @TestTarget
    public final Target target = new HttpTarget(8888);

    @Autowired
    private PersonRepository personRepository;

    @State("Person with ssn (71129011111) exist")
    public void getPersonPact() {
        personRepository.add(new Person(null, "71129011111", "Test testesen", null));
    }
}
