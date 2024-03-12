package br.com.camilo.gabriela.techchallenge5soat49.business.exceptions;

import br.com.camilo.gabriela.techchallenge5soat49.business.entities.base.BaseDomain;
import jakarta.validation.ConstraintViolation;

import java.util.Set;

public class DomainConstraintException extends Throwable {

    private final Set<ConstraintViolation<BaseDomain>> constraintViolations;

    private final String domainName;

    public DomainConstraintException(Set<ConstraintViolation<BaseDomain>> constraintViolations, String domainName) {
        this.constraintViolations = constraintViolations;
        this.domainName = domainName;
    }
}
