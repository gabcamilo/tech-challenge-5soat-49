package br.com.camilo.gabriela.techchallenge5soat49.core.domain.product;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.BaseDomain;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Product extends BaseDomain {
    @NotBlank
    private final String name;

    @NotNull
    private final ProductType type;

    private final String description;

    @NotNull
    @DecimalMin("0")
    private final BigDecimal price;

    protected Product(String id, LocalDateTime createdAt, LocalDateTime updatedAt, String name, ProductType type, String description, BigDecimal price) {
        super(id, createdAt, updatedAt);
        this.name = name;
        this.type = type;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public ProductType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
