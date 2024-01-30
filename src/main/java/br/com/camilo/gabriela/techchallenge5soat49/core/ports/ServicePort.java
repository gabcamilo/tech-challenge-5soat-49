package br.com.camilo.gabriela.techchallenge5soat49.core.ports;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.BaseDomain;
import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DataValidationException;
import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DomainConstraintException;
import br.com.camilo.gabriela.techchallenge5soat49.core.validation.ValidationPort;

import java.util.List;

public interface ServicePort <T extends BaseDomain, V extends ValidationPort, G extends PersistencePort> {
    T create(T domain) throws DomainConstraintException;
    T update(T domain, String id) throws DomainConstraintException;
    T get(String id) throws DataValidationException;
    void delete(String id) throws DataValidationException;
    List<T> list();
}
