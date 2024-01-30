package br.com.camilo.gabriela.techchallenge5soat49.core.services;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.BaseDomain;
import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DataValidationException;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.PersistencePort;
import br.com.camilo.gabriela.techchallenge5soat49.core.validation.ValidationPort;

public class ProductValidationPortImpl implements ValidationPort {
    @Override
    public void validateCreationalBusinessRules(BaseDomain domainItem, PersistencePort persistencePort) throws DataValidationException {

    }

    @Override
    public void validateUpdateBusinessRules(BaseDomain updatedData, BaseDomain persistedData, PersistencePort persistencePort) throws DataValidationException {

    }
}
