package br.com.camilo.gabriela.techchallenge5soat49.adapters.inbound.api.dtos.product;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.product.ProductType;

import java.math.BigDecimal;

public record CreateProductRequest(String name,
                                   ProductType type,
                                   String description,
                                   BigDecimal price) {
}
