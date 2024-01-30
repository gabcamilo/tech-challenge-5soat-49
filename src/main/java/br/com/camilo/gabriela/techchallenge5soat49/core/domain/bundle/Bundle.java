package br.com.camilo.gabriela.techchallenge5soat49.core.domain.bundle;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.BaseDomain;
import br.com.camilo.gabriela.techchallenge5soat49.core.domain.product.Product;
import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DomainConstraintException;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Bundle extends BaseDomain {

    @NotBlank
    private final String name;

    @Size(min = 2)
    private final List<Product> products;

    @DecimalMin("0")
    @DecimalMax("1")
    @NotNull
    private final BigDecimal discountPercentage;

    private final BigDecimal price;

    private Bundle(String id,
                   LocalDateTime createdAt,
                   LocalDateTime updatedAt,
                   String name,
                   List<Product> products,
                   BigDecimal discountPercentage) throws DomainConstraintException {
        super(id, createdAt, updatedAt);
        this.name = name;
        this.products = products;
        this.discountPercentage = discountPercentage;

        this.isValid();

        this.price = calculateTotalPrice();
    }

    public static Bundle createNew(String name,
                                   List<Product> products,
                                   BigDecimal discountPercentage) throws DomainConstraintException {
        return new Bundle(
                null,
                LocalDateTime.now(),
                LocalDateTime.now(),
                name,
                products,
                discountPercentage
        );
    }

    public static Bundle create(@NotBlank String id,
                                LocalDateTime createdAt,
                                LocalDateTime updatedAt,
                                String name,
                                List<Product> products,
                                BigDecimal discountPercentage) throws DomainConstraintException {
        return new Bundle(
                id,
                createdAt,
                updatedAt,
                name,
                products,
                discountPercentage
        );
    }

    private BigDecimal calculateTotalPrice() {
        BigDecimal totalPrice = products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return totalPrice.subtract(totalPrice.multiply(discountPercentage));
    }

    public Bundle update(Bundle bundle) throws DomainConstraintException {
        return new Bundle(
                getId(),
                getCreatedAt(),
                LocalDateTime.now(),
                bundle.getName(),
                bundle.getProducts(),
                bundle.getDiscountPercentage()
        );
    }

    public List<Product> getProducts() {
        return products;
    }

    public BigDecimal getDiscountPercentage() {
        return discountPercentage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
