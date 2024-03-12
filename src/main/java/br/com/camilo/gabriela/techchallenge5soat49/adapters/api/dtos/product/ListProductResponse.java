package br.com.camilo.gabriela.techchallenge5soat49.adapters.api.dtos.product;

import br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.product.Product;

import java.io.Serializable;
import java.util.List;

public class ListProductResponse implements Serializable {

    List<ProductResponse> products;
    public ListProductResponse(List<Product> products) {
        this.products = products.stream().map(ProductResponse::new).toList();
    }

    public List<ProductResponse> getProducts() {
        return products;
    }
}
