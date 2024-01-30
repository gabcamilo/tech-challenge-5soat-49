package br.com.camilo.gabriela.techchallenge5soat49.core.domain.customer;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.BaseDomain;
import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DomainConstraintException;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class EventualCustomer extends BaseDomain {
    @NotBlank
    private final String name;

    protected EventualCustomer(String id, LocalDateTime createdAt, LocalDateTime updatedAt, String name) throws DomainConstraintException {
        super(id, createdAt, updatedAt);
        this.name = name;

        this.isValid();
    }

    public static EventualCustomer create(String name) throws DomainConstraintException {
        return new EventualCustomer(null, LocalDateTime.now(), LocalDateTime.now(), name);
    }

    public String getName() {
        return name;
    }
}
