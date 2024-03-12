package br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.order;

import br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.product.Product;

public class OrderProduct {
    private final Product product;
    private final Integer quantity;

    public OrderProduct(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }

}
