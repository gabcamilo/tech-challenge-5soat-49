package br.com.camilo.gabriela.techchallenge5soat49.business.entities.product;

import br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.product.Product;
import br.com.camilo.gabriela.techchallenge5soat49.business.exceptions.DomainConstraintException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest {

    @Test
    @DisplayName("[CORE][DOMAIN][PRODUCT] - should not create product with invalid name")
    void create_product_with_invalid_data_name() {
        var mockProductData = MockProduct.generateMockData();

        // should not allow a product without name
        mockProductData.withEmptyName();

        assertThrows(DomainConstraintException.class, () -> {
            Product.create(
                    mockProductData.getId(),
                    mockProductData.getCreatedAt(),
                    mockProductData.getUpdatedAt(),
                    mockProductData.getName(),
                    mockProductData.getType(),
                    mockProductData.getDescription(),
                    mockProductData.getPrice()
            );
        });

        mockProductData.withNullName();

        assertThrows(DomainConstraintException.class, () -> {
            Product.create(
                    mockProductData.getId(),
                    mockProductData.getCreatedAt(),
                    mockProductData.getUpdatedAt(),
                    mockProductData.getName(),
                    mockProductData.getType(),
                    mockProductData.getDescription(),
                    mockProductData.getPrice()
            );
        });
    }

    @Test
    @DisplayName("[CORE][DOMAIN][PRODUCT] - should not create product with invalid type")
    void create_product_with_invalid_data_type() {
        var mockProductData = MockProduct.generateMockData();

        // should not allow a product without type
        mockProductData.withNullType();

        assertThrows(DomainConstraintException.class, () -> {
            Product.create(
                    mockProductData.getId(),
                    mockProductData.getCreatedAt(),
                    mockProductData.getUpdatedAt(),
                    mockProductData.getName(),
                    mockProductData.getType(),
                    mockProductData.getDescription(),
                    mockProductData.getPrice()
            );
        });
    }

    @Test
    @DisplayName("[CORE][DOMAIN][PRODUCT] - should not create product with invalid price")
    void create_product_with_invalid_data_price() {
        var mockProductData = MockProduct.generateMockData();

        // should not allow a product without price
        mockProductData.withNullPrice();

        assertThrows(DomainConstraintException.class, () -> {
            Product.create(
                    mockProductData.getId(),
                    mockProductData.getCreatedAt(),
                    mockProductData.getUpdatedAt(),
                    mockProductData.getName(),
                    mockProductData.getType(),
                    mockProductData.getDescription(),
                    mockProductData.getPrice()
            );
        });

        // should not allow a product with negative price
        mockProductData.withNegativePrice();

        assertThrows(DomainConstraintException.class, () -> {
            Product.create(
                    mockProductData.getId(),
                    mockProductData.getCreatedAt(),
                    mockProductData.getUpdatedAt(),
                    mockProductData.getName(),
                    mockProductData.getType(),
                    mockProductData.getDescription(),
                    mockProductData.getPrice()
            );
        });
    }

    @Test
    @DisplayName("[CORE][DOMAIN][PRODUCT] - should create new product with null id")
    void create_new_product_with_null_id() throws DomainConstraintException {
        var mockProductData = MockProduct.generateMockData();

        Product.createNew(
                mockProductData.getName(),
                mockProductData.getType(),
                mockProductData.getDescription(),
                mockProductData.getPrice()
        );
    }

    @Test
    @DisplayName("[CORE][DOMAIN][PRODUCT] - should not create new product with invalid name")
    void create_new_product_with_invalid_data_name() {
        var mockProductData = MockProduct.generateMockData();

        // should not allow a product without name
        mockProductData.withEmptyName();

        assertThrows(DomainConstraintException.class, () -> {
            Product.createNew(
                    mockProductData.getName(),
                    mockProductData.getType(),
                    mockProductData.getDescription(),
                    mockProductData.getPrice()
            );
        });

        mockProductData.withNullName();

        assertThrows(DomainConstraintException.class, () -> {
            Product.createNew(
                    mockProductData.getName(),
                    mockProductData.getType(),
                    mockProductData.getDescription(),
                    mockProductData.getPrice()
            );
        });
    }

    @Test
    @DisplayName("[CORE][DOMAIN][PRODUCT] - should not create new product with invalid type")
    void create_new_product_with_invalid_data_type() {
        var mockProductData = MockProduct.generateMockData();

        // should not allow a product without type
        mockProductData.withNullType();

        assertThrows(DomainConstraintException.class, () -> {
            Product.createNew(
                    mockProductData.getName(),
                    mockProductData.getType(),
                    mockProductData.getDescription(),
                    mockProductData.getPrice()
            );
        });
    }

    @Test
    @DisplayName("[CORE][DOMAIN][PRODUCT] - should not create new product with invalid price")
    void create_new_product_with_invalid_data_price() {
        var mockProductData = MockProduct.generateMockData();

        // should not allow a product without price
        mockProductData.withNullPrice();

        assertThrows(DomainConstraintException.class, () -> {
            Product.createNew(
                    mockProductData.getName(),
                    mockProductData.getType(),
                    mockProductData.getDescription(),
                    mockProductData.getPrice()
            );
        });

        // should not allow a product with negative price
        mockProductData.withNegativePrice();

        assertThrows(DomainConstraintException.class, () -> {
            Product.createNew(
                    mockProductData.getName(),
                    mockProductData.getType(),
                    mockProductData.getDescription(),
                    mockProductData.getPrice()
            );
        });
    }
}
