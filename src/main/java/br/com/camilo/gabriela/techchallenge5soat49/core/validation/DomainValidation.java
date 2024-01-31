package br.com.camilo.gabriela.techchallenge5soat49.core.validation;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.BaseDomain;
import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DomainConstraintException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;

public class DomainValidation {

    private static Validator validator = getValidator();

    public static <T extends BaseDomain> void checkConstraints(T domain) throws DomainConstraintException {
        Set<ConstraintViolation<BaseDomain>> constraintViolations = validator.validate(domain);
        if (!constraintViolations.isEmpty())
            throw new DomainConstraintException(constraintViolations, domain.getClass().getSimpleName());
    }

    private static Validator getValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        return factory.getValidator();
    }
}
