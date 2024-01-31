package br.com.camilo.gabriela.techchallenge5soat49.core.domain.customer;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.BaseDomain;
import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DomainConstraintException;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDateTime;

public class Customer extends BaseDomain {
    @NotBlank
    private final String name;

    @NotBlank
    @Email
    private final String email;

    @NotBlank
    @CPF
    private final String cpf;

    private Customer(
            String id,
            LocalDateTime createdAt,
            LocalDateTime updatedAt,
            String name,
            String email,
            String cpf) throws DomainConstraintException {
        super(id, createdAt, updatedAt);
        this.name = name;
        this.email = email;
        this.cpf = cpf;

        this.isValid();
    }

    public static Customer createNew(String name,
                                     String email,
                                     String cpf) throws DomainConstraintException {
        return new Customer(null, LocalDateTime.now(), LocalDateTime.now(), name, email, cpf);
    }

    public static Customer create(@NotBlank String id,
                                  LocalDateTime createdAt,
                                  LocalDateTime updatedAt,
                                  String name,
                                  String email,
                                  String cpf) throws DomainConstraintException {
        return new Customer(id, createdAt, updatedAt, name, email, cpf);
    }

    public Customer update(Customer customer) throws DomainConstraintException {
        return new Customer(
                getId(),
                getCreatedAt(),
                LocalDateTime.now(),
                customer.getName(),
                customer.getEmail(),
                this.cpf
        );
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
}
