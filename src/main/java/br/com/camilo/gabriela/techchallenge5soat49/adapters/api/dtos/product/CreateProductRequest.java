package br.com.camilo.gabriela.techchallenge5soat49.adapters.api.dtos.product;

import br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.product.ProductType;

import java.math.BigDecimal;

public record CreateProductRequest(String name,
                                   ProductType type,
                                   String description,
                                   BigDecimal price) {
}
