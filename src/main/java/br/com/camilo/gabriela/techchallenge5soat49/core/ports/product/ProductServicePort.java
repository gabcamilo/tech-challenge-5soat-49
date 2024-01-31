package br.com.camilo.gabriela.techchallenge5soat49.core.ports.product;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.product.Product;
import br.com.camilo.gabriela.techchallenge5soat49.core.domain.product.ProductType;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.ServicePort;

import java.util.List;

public interface ProductServicePort extends ServicePort<Product, ProductValidationPort, ProductPersistencePort> {
    List<Product> listProductsByType(ProductType typeEnum);
}
