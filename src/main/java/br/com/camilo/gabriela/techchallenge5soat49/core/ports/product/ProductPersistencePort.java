package br.com.camilo.gabriela.techchallenge5soat49.core.ports.product;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.product.Product;
import br.com.camilo.gabriela.techchallenge5soat49.core.domain.product.ProductType;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.PersistencePort;

import java.util.List;

public interface ProductPersistencePort extends PersistencePort<Product> {
    List<Product> listProductsByType(ProductType typeEnum);

    List<Product> listProductsByIds(List<String> products);
}
