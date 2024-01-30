package br.com.camilo.gabriela.techchallenge5soat49.core.domain.order;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.bundle.Bundle;
import br.com.camilo.gabriela.techchallenge5soat49.core.domain.product.Product;
import br.com.camilo.gabriela.techchallenge5soat49.core.domain.product.ProductType;

import java.math.BigDecimal;
import java.util.List;

public class OrderProduct {

    private String name;
    private ProductType type;
    private Integer quantity;
    private BigDecimal price;
    private List<OrderProduct> addOns;

    private OrderProduct(String name, ProductType type, Integer quantity, BigDecimal price, List<OrderProduct> addOns) {
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
        this.addOns = addOns;
    }

    public OrderProduct product(Product product, Integer quantity, List<OrderProduct> addOns) {
        return new OrderProduct(product.getName(), product.getType(), quantity, product.getPrice(), addOns);
    }

    public OrderProduct bundle(Bundle bundle, Integer quantity) {
        return new OrderProduct(bundle.getName(), ProductType.BUNDLE, quantity, bundle.getPrice(), null);
    }

    public String getName() {
        return name;
    }

    public ProductType getType() {
        return type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public List<OrderProduct> getAddOns() {
        return addOns;
    }
}
