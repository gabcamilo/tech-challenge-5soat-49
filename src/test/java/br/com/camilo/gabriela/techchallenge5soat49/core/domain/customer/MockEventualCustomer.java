package br.com.camilo.gabriela.techchallenge5soat49.core.domain.customer;

import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DomainConstraintException;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.PastOrPresent;
import org.hibernate.validator.constraints.br.CPF;
import org.instancio.Instancio;
import org.instancio.settings.Keys;
import org.instancio.settings.Settings;

import java.time.LocalDateTime;

import static br.com.camilo.gabriela.techchallenge5soat49.TestUtil.generateValidCpf;
import static org.instancio.Select.field;

public class MockEventualCustomer {
    private String name;

    private MockEventualCustomer() {
        throw new IllegalStateException("Utility class");
    }

    public static MockEventualCustomer generateMockData() {
        return Instancio.of(MockEventualCustomer.class)
                .withSettings(Settings.create().set(Keys.BEAN_VALIDATION_ENABLED, true))
                .create();
    }

    public static EventualCustomer generateValidCustomer() throws DomainConstraintException {
        MockEventualCustomer mockCustomer = generateMockData();
        return EventualCustomer.create(
                mockCustomer.getName()
        );
    }

    public String getName() {
        return name;
    }


    public MockEventualCustomer withEmptyName() {
        this.name = "";
        return this;
    }

    public MockEventualCustomer withNullName() {
        this.name = null;
        return this;
    }

}
