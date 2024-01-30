package br.com.camilo.gabriela.techchallenge5soat49.core.domain.bundle;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.product.MockProduct;
import br.com.camilo.gabriela.techchallenge5soat49.core.domain.product.Product;
import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DomainConstraintException;
import jakarta.validation.constraints.*;
import org.instancio.Instancio;
import org.instancio.settings.Keys;
import org.instancio.settings.Settings;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MockBundle {
    private String id;

    @PastOrPresent
    private LocalDateTime createdAt;

    @PastOrPresent
    private LocalDateTime updatedAt;

    @NotBlank
    private String name;

    @Size(min = 2)
    private List<Product> products;

    @DecimalMin("0")
    @DecimalMax("1")
    private BigDecimal discountPercentage;


    private MockBundle() {
        throw new IllegalStateException("Utility class");
    }

    public static MockBundle generateMockData() {
        return Instancio.of(MockBundle.class)
                .withSettings(Settings.create().set(Keys.BEAN_VALIDATION_ENABLED, true))
                .create();
    }

    public static Bundle generateValidBundle() throws DomainConstraintException {
        MockBundle mockBundle = generateMockData();
        return Bundle.create(
                mockBundle.getId(),
                mockBundle.getCreatedAt(),
                mockBundle.getUpdatedAt(),
                mockBundle.getName(),
                mockBundle.getProducts(),
                mockBundle.getDiscountPercentage()
        );
    }

    public MockBundle withEmptyName() {
        this.name = "";
        return this;
    }

    public MockBundle withNullName() {
        this.name = null;
        return this;
    }

    public MockBundle withNoProducts() throws DomainConstraintException {
        this.products = new ArrayList<>();
        return this;
    }

    public MockBundle withOnlyOneProduct() throws DomainConstraintException {
        this.products = List.of(MockProduct.generateValidProduct());
        return this;
    }

    public MockBundle withDiscountPercentageGreaterThanOne() {
        this.discountPercentage = BigDecimal.valueOf(1.1);
        return this;
    }

    public MockBundle withNegativeDiscountPercentage() {
        this.discountPercentage = BigDecimal.valueOf(-1);
        return this;
    }

    public MockBundle withNullDiscountPercentage() {
        this.discountPercentage = null;
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

    public List<Product> getProducts() {
        return products;
    }

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }
}
