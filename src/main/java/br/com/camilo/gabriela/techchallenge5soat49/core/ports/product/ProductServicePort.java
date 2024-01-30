package br.com.camilo.gabriela.techchallenge5soat49.core.ports.product;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.product.Product;
import br.com.camilo.gabriela.techchallenge5soat49.core.ports.ServicePort;

public interface ProductServicePort extends ServicePort<Product, ProductValidationPort, ProductPersistencePort> {
}
