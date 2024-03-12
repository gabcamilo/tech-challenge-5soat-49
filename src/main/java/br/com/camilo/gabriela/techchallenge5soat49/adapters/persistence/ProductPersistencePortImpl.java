package br.com.camilo.gabriela.techchallenge5soat49.adapters.persistence;

import br.com.camilo.gabriela.techchallenge5soat49.configs.database.ProductRepository;
import br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.product.Product;
import br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.product.ProductType;
import br.com.camilo.gabriela.techchallenge5soat49.business.entities.boundaries.product.ProductPersistencePort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductPersistencePortImpl implements ProductPersistencePort {

    private final ProductRepository productRepository;

    public ProductPersistencePortImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product item) {
        return productRepository.save(item);
    }

    @Override
    public List<Product> list() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> get(String id) {
        return productRepository.findById(id);
    }

    @Override
    public Product update(Product item) {
        return productRepository.save(item);
    }

    @Override
    public List<Product> listProductsByType(ProductType typeEnum) {
        return productRepository.findByType(typeEnum);
    }

    @Override
    public List<Product> listProductsByIds(List<String> products) {
        return productRepository.findAllById(products);
    }


}
