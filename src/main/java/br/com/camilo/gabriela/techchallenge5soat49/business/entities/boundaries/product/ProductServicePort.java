package br.com.camilo.gabriela.techchallenge5soat49.business.entities.boundaries.product;

import br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.product.Product;
import br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.product.ProductType;
import br.com.camilo.gabriela.techchallenge5soat49.business.entities.boundaries.ServicePort;

import java.util.List;

public interface ProductServicePort extends ServicePort<Product, ProductValidationPort, ProductPersistencePort> {
    List<Product> listProductsByType(ProductType typeEnum);
}
