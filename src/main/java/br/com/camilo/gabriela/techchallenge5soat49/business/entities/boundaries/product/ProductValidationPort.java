package br.com.camilo.gabriela.techchallenge5soat49.business.entities.boundaries.product;

import br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.product.Product;
import br.com.camilo.gabriela.techchallenge5soat49.business.validation.ValidationPort;

public interface ProductValidationPort extends ValidationPort<Product, ProductPersistencePort> {
}
