package br.com.camilo.gabriela.techchallenge5soat49.core.domain;

import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DomainConstraintException;
import br.com.camilo.gabriela.techchallenge5soat49.core.validation.DomainValidation;
import jakarta.validation.constraints.PastOrPresent;

import java.io.Serializable;
import java.time.LocalDateTime;

public class BaseDomain implements Domain, Serializable {

    private String id;

    @PastOrPresent
    private LocalDateTime createdAt;

    @PastOrPresent
    private LocalDateTime updatedAt;

    protected BaseDomain(String id, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public void isValid() throws DomainConstraintException {
        DomainValidation.checkConstraints(this);
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    @Override
    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }
}
