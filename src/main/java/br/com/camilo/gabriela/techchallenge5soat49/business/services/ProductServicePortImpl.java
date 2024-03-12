package br.com.camilo.gabriela.techchallenge5soat49.business.services;

import br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.product.Product;
import br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.product.ProductType;
import br.com.camilo.gabriela.techchallenge5soat49.business.exceptions.DataValidationException;
import br.com.camilo.gabriela.techchallenge5soat49.business.exceptions.DomainConstraintException;
import br.com.camilo.gabriela.techchallenge5soat49.business.entities.boundaries.product.ProductPersistencePort;
import br.com.camilo.gabriela.techchallenge5soat49.business.entities.boundaries.product.ProductServicePort;
import br.com.camilo.gabriela.techchallenge5soat49.business.entities.boundaries.product.ProductValidationPort;

import java.util.List;

public class ProductServicePortImpl implements ProductServicePort {

    private static final String PRODUCT = "Product";

    private final ProductPersistencePort persistencePort;
    private final ProductValidationPort validationPort;

    public ProductServicePortImpl(ProductPersistencePort persistencePort, ProductValidationPort validationPort) {
        this.persistencePort = persistencePort;
        this.validationPort = validationPort;
    }

    @Override
    public Product create(Product domain) throws DomainConstraintException {
        validationPort.validateCreationalBusinessRules(domain, persistencePort);
        return persistencePort.save(domain);
    }

    @Override
    public Product update(Product updatedData, Product persistedData) throws DomainConstraintException {
        validationPort.validateUpdateBusinessRules(updatedData, persistedData, persistencePort);
        Product update = persistedData.update(updatedData);
        return persistencePort.save(update);
    }

    @Override
    public Product get(String id) throws DataValidationException {
        return persistencePort.get(id).orElseThrow(() -> new DataValidationException("Product not found"));
    }

    @Override
    public List<Product> list() {
        return persistencePort.list();
    }

    @Override
    public List<Product> listProductsByType(ProductType typeEnum) {
        return persistencePort.listProductsByType(typeEnum);
    }
}
