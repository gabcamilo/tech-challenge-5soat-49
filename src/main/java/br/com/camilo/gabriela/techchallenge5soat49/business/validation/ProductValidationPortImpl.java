package br.com.camilo.gabriela.techchallenge5soat49.business.validation;

import br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.product.Product;
import br.com.camilo.gabriela.techchallenge5soat49.business.exceptions.DataValidationException;
import br.com.camilo.gabriela.techchallenge5soat49.business.entities.boundaries.product.ProductPersistencePort;
import br.com.camilo.gabriela.techchallenge5soat49.business.entities.boundaries.product.ProductValidationPort;

public class ProductValidationPortImpl implements ProductValidationPort {

    @Override
    public void validateCreationalBusinessRules(Product domainItem, ProductPersistencePort persistencePort) throws DataValidationException {

    }

    @Override
    public void validateUpdateBusinessRules(Product updatedData, Product persistedData, ProductPersistencePort persistencePort) throws DataValidationException {

    }
}
