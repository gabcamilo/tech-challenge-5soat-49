package br.com.camilo.gabriela.techchallenge5soat49.core.domain.customer;

import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DomainConstraintException;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import org.hibernate.validator.constraints.br.CPF;
import org.instancio.Instancio;
import org.instancio.settings.Keys;
import org.instancio.settings.Settings;

import java.time.LocalDateTime;

import static org.instancio.Select.field;
import static br.com.camilo.gabriela.techchallenge5soat49.TestUtil.generateValidCpf;

public class MockCustomer {

    private String id;

    @PastOrPresent
    private LocalDateTime createdAt;

    @PastOrPresent
    private LocalDateTime updatedAt;

    @NotEmpty
    private String name;

    @Email
    private String email;

    @CPF
    private String cpf;

    private MockCustomer() {
        throw new IllegalStateException("Utility class");
    }

    public static MockCustomer generateMockData() {
        return Instancio.of(MockCustomer.class)
                .withSettings(Settings.create().set(Keys.BEAN_VALIDATION_ENABLED, true))
                .generate(field(MockCustomer::getCpf), gen -> gen.text().pattern(generateValidCpf()))
                .create();
    }

    public static Customer generateValidCustomer() throws DomainConstraintException {
        MockCustomer mockCustomer = generateMockData();
        return Customer.create(
                mockCustomer.getId(),
                mockCustomer.getCreatedAt(),
                mockCustomer.getUpdatedAt(),
                mockCustomer.getName(),
                mockCustomer.getEmail(),
                mockCustomer.getCpf()
        );
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public MockCustomer withInvalidCpf() {
        this.cpf = "invalid cpf";
        return this;
    }

    public MockCustomer withNullCpf() {
        this.cpf = null;
        return this;
    }

    public MockCustomer withEmptyCpf() {
        this.email = "";
        return this;
    }

    public MockCustomer withInvalidEmail() {
        this.email = "invalid email";
        return this;
    }

    public MockCustomer withNullEmail() {
        this.email = null;
        return this;
    }

    public MockCustomer withEmptyEmail() {
        this.email = "";
        return this;
    }

    public MockCustomer withEmptyName() {
        this.name = "";
        return this;
    }

    public MockCustomer withNullName() {
        this.name = null;
        return this;
    }

}
