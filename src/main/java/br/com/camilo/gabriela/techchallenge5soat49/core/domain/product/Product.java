package br.com.camilo.gabriela.techchallenge5soat49.core.domain.product;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.BaseDomain;
import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DomainConstraintException;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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

    private Product(String id, LocalDateTime createdAt, LocalDateTime updatedAt, String name, ProductType type, String description, BigDecimal price) throws DomainConstraintException {
        super(id, createdAt, updatedAt);
        this.name = name;
        this.type = type;
        this.description = description;
        this.price = price;

        this.isValid();
    }

    public static Product createNew(String name,
                                    ProductType type,
                                    String description,
                                    BigDecimal price) throws DomainConstraintException {
        return new Product(null, LocalDateTime.now(), LocalDateTime.now(), name, type, description, price);
    }

    public static Product create(@NotBlank String id,
                                 LocalDateTime createdAt,
                                 LocalDateTime updatedAt,
                                 String name,
                                 ProductType type,
                                 String description,
                                 BigDecimal price) throws DomainConstraintException {
        return new Product(id, createdAt, updatedAt, name, type, description, price);
    }

    public Product update(Product product) throws DomainConstraintException {
        return new Product(
                getId(),
                getCreatedAt(),
                LocalDateTime.now(),
                product.getName(),
                product.getType(),
                product.getDescription(),
                product.getPrice());
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
