package br.com.camilo.gabriela.techchallenge5soat49.adapters.outbound;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.product.Product;
import br.com.camilo.gabriela.techchallenge5soat49.core.domain.product.ProductType;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByType(ProductType type);

    List<Product> findAllById(List<String> products);
}
