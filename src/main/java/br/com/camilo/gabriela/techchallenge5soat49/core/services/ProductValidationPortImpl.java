package br.com.camilo.gabriela.techchallenge5soat49.core.services;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.product.Product;
import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DataValidationException;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.product.ProductPersistencePort;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.product.ProductValidationPort;

public class ProductValidationPortImpl implements ProductValidationPort {

    @Override
    public void validateCreationalBusinessRules(Product domainItem, ProductPersistencePort persistencePort) throws DataValidationException {

    }

    @Override
    public void validateUpdateBusinessRules(Product updatedData, Product persistedData, ProductPersistencePort persistencePort) throws DataValidationException {

    }
}
