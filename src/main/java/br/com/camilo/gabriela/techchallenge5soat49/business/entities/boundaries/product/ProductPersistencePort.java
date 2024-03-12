package br.com.camilo.gabriela.techchallenge5soat49.business.entities.boundaries.product;

import br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.product.Product;
import br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.product.ProductType;
import br.com.camilo.gabriela.techchallenge5soat49.business.entities.boundaries.PersistencePort;

import java.util.List;

public interface ProductPersistencePort extends PersistencePort<Product> {
    List<Product> listProductsByType(ProductType typeEnum);

    List<Product> listProductsByIds(List<String> products);
}
