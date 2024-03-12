package br.com.camilo.gabriela.techchallenge5soat49.business.entities.boundaries;

import br.com.camilo.gabriela.techchallenge5soat49.business.entities.base.BaseDomain;
import br.com.camilo.gabriela.techchallenge5soat49.business.exceptions.DataValidationException;
import br.com.camilo.gabriela.techchallenge5soat49.business.exceptions.DomainConstraintException;
import br.com.camilo.gabriela.techchallenge5soat49.business.validation.ValidationPort;

import java.util.List;

public interface ServicePort <T extends BaseDomain, V extends ValidationPort, G extends PersistencePort> {
    T create(T domain) throws DomainConstraintException;
    T update(T updatedData, T persistedData) throws DomainConstraintException;
    T get(String id) throws DataValidationException;
    List<T> list();
}
