package br.com.camilo.gabriela.techchallenge5soat49.business.entities.product;

import br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.product.Product;
import br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.product.ProductType;
import br.com.camilo.gabriela.techchallenge5soat49.business.exceptions.DomainConstraintException;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import org.instancio.Instancio;
import org.instancio.settings.Keys;
import org.instancio.settings.Settings;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MockProduct {
    private String id;

    @PastOrPresent
    private LocalDateTime createdAt;

    @PastOrPresent
    private LocalDateTime updatedAt;

    @NotBlank
    private String name;

    @NotNull
    private ProductType type;
    private String description;

    @NotNull
    @DecimalMin("0")
    private BigDecimal price;

    private MockProduct() {
        throw new IllegalStateException("Utility class");
    }

    public static MockProduct generateMockData() {
        return Instancio.of(MockProduct.class)
                .withSettings(Settings.create().set(Keys.BEAN_VALIDATION_ENABLED, true))
                .create();
    }

    public static Product generateValidProduct() throws DomainConstraintException {
        MockProduct mockProduct = generateMockData();
        return Product.create(
                mockProduct.getId(),
                mockProduct.getCreatedAt(),
                mockProduct.getUpdatedAt(),
                mockProduct.getName(),
                mockProduct.getType(),
                mockProduct.getDescription(),
                mockProduct.getPrice()
        );
    }

    public MockProduct withEmptyName() {
        this.name = "";
        return this;
    }

    public MockProduct withNullName() {
        this.name = null;
        return this;
    }

    public MockProduct withNullType() {
        this.type = null;
        return this;
    }

    public MockProduct withNullPrice() {
        this.price = null;
        return this;
    }

    public MockProduct withNegativePrice() {
        this.price = BigDecimal.valueOf(-1);
        return this;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
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
