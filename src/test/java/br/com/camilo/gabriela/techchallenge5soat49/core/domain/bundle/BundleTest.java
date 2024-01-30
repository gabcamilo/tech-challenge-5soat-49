package br.com.camilo.gabriela.techchallenge5soat49.core.domain.bundle;

import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DomainConstraintException;
import br.com.camilo.gabriela.techchallenge5soat49.core.domain.product.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class BundleTest {

    @Test
    @DisplayName("[CORE][DOMAIN][BUNDLE] - should not create a bundle with invalid name")
    void create_bundle_with_invalid_name() {
        var mockBundleData = MockBundle.generateMockData();

        // should not allow a bundle without a name
        mockBundleData.withEmptyName();

        assertThrows(DomainConstraintException.class, () -> {
            Bundle.create(
                    mockBundleData.getId(),
                    mockBundleData.getCreatedAt(),
                    mockBundleData.getUpdatedAt(),
                    mockBundleData.getName(),
                    mockBundleData.getProducts(),
                    mockBundleData.getDiscountPercentage()
            );
        });

        mockBundleData.withNullName();

        assertThrows(DomainConstraintException.class, () -> {
            Bundle.create(
                    mockBundleData.getId(),
                    mockBundleData.getCreatedAt(),
                    mockBundleData.getUpdatedAt(),
                    mockBundleData.getName(),
                    mockBundleData.getProducts(),
                    mockBundleData.getDiscountPercentage()
            );
        });
    }

    @Test
    @DisplayName("[CORE][DOMAIN][BUNDLE] - should not create a bundle with invalid discount percentage")
    void create_bundle_with_invalid_discount_percentage() {
        var mockBundleData = MockBundle.generateMockData();

        // should not allow a bundle without a discount percentage
        mockBundleData.withNullDiscountPercentage();

        assertThrows(DomainConstraintException.class, () -> {
            Bundle.create(
                    mockBundleData.getId(),
                    mockBundleData.getCreatedAt(),
                    mockBundleData.getUpdatedAt(),
                    mockBundleData.getName(),
                    mockBundleData.getProducts(),
                    mockBundleData.getDiscountPercentage()
            );
        });


        mockBundleData.withNegativeDiscountPercentage();

        assertThrows(DomainConstraintException.class, () -> {
            Bundle.create(
                    mockBundleData.getId(),
                    mockBundleData.getCreatedAt(),
                    mockBundleData.getUpdatedAt(),
                    mockBundleData.getName(),
                    mockBundleData.getProducts(),
                    mockBundleData.getDiscountPercentage()
            );
        });

        mockBundleData.withDiscountPercentageGreaterThanOne();

        assertThrows(DomainConstraintException.class, () -> {
            Bundle.create(
                    mockBundleData.getId(),
                    mockBundleData.getCreatedAt(),
                    mockBundleData.getUpdatedAt(),
                    mockBundleData.getName(),
                    mockBundleData.getProducts(),
                    mockBundleData.getDiscountPercentage()
            );
        });
    }

    @Test
    @DisplayName("[CORE][DOMAIN][BUNDLE] - should not create a bundle with invalid product quantity")
    void create_bundle_with_invalid_product_quantity() throws DomainConstraintException {
        var mockBundleData = MockBundle.generateMockData();

        // should not allow a bundle without products
        mockBundleData.withNoProducts();

        assertThrows(DomainConstraintException.class, () -> {
            Bundle.create(
                    mockBundleData.getId(),
                    mockBundleData.getCreatedAt(),
                    mockBundleData.getUpdatedAt(),
                    mockBundleData.getName(),
                    mockBundleData.getProducts(),
                    mockBundleData.getDiscountPercentage()
            );
        });

        // should not allow a bundle with only one product
        mockBundleData.withOnlyOneProduct();

        assertThrows(DomainConstraintException.class, () -> {
            Bundle.create(
                    mockBundleData.getId(),
                    mockBundleData.getCreatedAt(),
                    mockBundleData.getUpdatedAt(),
                    mockBundleData.getName(),
                    mockBundleData.getProducts(),
                    mockBundleData.getDiscountPercentage()
            );
        });
    }

    @Test
    @DisplayName("[CORE][DOMAIN][BUNDLE] - should update only updatable fields to valid values")
    void update_bundle() throws DomainConstraintException {
        var formerBundleData = MockBundle.generateValidBundle();
        var bundleDataToUpdate = MockBundle.generateValidBundle();

        Bundle result = formerBundleData.update(bundleDataToUpdate);

        /* should NOT be updated
         * - id
         * - createdAt
         * ******************************/

        // id
        assertEquals(formerBundleData.getId(), result.getId());
        assertNotEquals(bundleDataToUpdate.getId(), result.getId());

        // createdAt
        assertEquals(formerBundleData.getCreatedAt(), result.getCreatedAt());
        assertNotEquals(bundleDataToUpdate.getCreatedAt(), result.getCreatedAt());

        /* should be updated
         * - updatedAt
         * - name
         * - products
         * - discountPercentage
         * ******************************/

        // updatedAt should be updated to current date
        assertTrue(result.getUpdatedAt().isBefore(LocalDateTime.now())); //before now
        assertTrue(result.getUpdatedAt().isAfter(formerBundleData.getUpdatedAt())); //after previous value
        assertNotEquals(bundleDataToUpdate.getUpdatedAt(), result.getUpdatedAt()); //different from updated data value (should be changed based on update time and not updated data value)
        assertNotEquals(formerBundleData.getUpdatedAt(), result.getUpdatedAt()); //different from previous value

        // name
        assertEquals(bundleDataToUpdate.getName(), result.getName());
        assertNotEquals(formerBundleData.getName(), result.getName());

        // products
        assertEquals(bundleDataToUpdate.getProducts(), result.getProducts());
        assertNotEquals(formerBundleData.getProducts(), result.getProducts());

        // discountPercentage
        assertEquals(bundleDataToUpdate.getDiscountPercentage(), result.getDiscountPercentage());
        assertNotEquals(formerBundleData.getDiscountPercentage(), result.getDiscountPercentage());

        // price
        assertEquals(bundleDataToUpdate.getPrice(), result.getPrice());
        assertNotEquals(formerBundleData.getPrice(), result.getPrice());
    }

    @Test
    @DisplayName("[CORE][DOMAIN][BUNDLE] - should calculate the total price of a bundle")
    void calculate_bundle_total_price() throws DomainConstraintException {
        var mockBundle = MockBundle.generateValidBundle();

        BigDecimal expectedPrice = mockBundle.getProducts().stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .subtract(mockBundle.getProducts().stream()
                        .map(Product::getPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
                        .multiply(mockBundle.getDiscountPercentage()));

        assertEquals(expectedPrice, mockBundle.getPrice());
    }

    @Test
    @DisplayName("[CORE][DOMAIN][BUNDLE] - should create new bundle with null id")
    void create_new_bundle_with_null_id() throws DomainConstraintException {
        var mockBundle = MockBundle.generateValidBundle();

        Bundle result = Bundle.createNew(
                mockBundle.getName(),
                mockBundle.getProducts(),
                mockBundle.getDiscountPercentage()
        );

        assertNull(result.getId());
    }

    @Test
    @DisplayName("[CORE][DOMAIN][BUNDLE] - should not create new bundle with invalid name")
    void create_new_bundle_with_invalid_name() {
        var mockBundleData = MockBundle.generateMockData();

        // should not allow a bundle without a name
        mockBundleData.withEmptyName();

        assertThrows(DomainConstraintException.class, () -> {
            Bundle.createNew(
                    mockBundleData.getName(),
                    mockBundleData.getProducts(),
                    mockBundleData.getDiscountPercentage()
            );
        });

        mockBundleData.withNullName();

        assertThrows(DomainConstraintException.class, () -> {
            Bundle.createNew(
                    mockBundleData.getName(),
                    mockBundleData.getProducts(),
                    mockBundleData.getDiscountPercentage()
            );
        });
    }

    @Test
    @DisplayName("[CORE][DOMAIN][BUNDLE] - should not create new bundle with invalid discount percentage")
    void create_new_bundle_with_invalid_discount_percentage() {
        var mockBundleData = MockBundle.generateMockData();

        // should not allow a bundle without a discount percentage
        mockBundleData.withNullDiscountPercentage();

        assertThrows(DomainConstraintException.class, () -> {
            Bundle.createNew(
                    mockBundleData.getName(),
                    mockBundleData.getProducts(),
                    mockBundleData.getDiscountPercentage()
            );
        });

        mockBundleData.withNegativeDiscountPercentage();

        assertThrows(DomainConstraintException.class, () -> {
            Bundle.createNew(
                    mockBundleData.getName(),
                    mockBundleData.getProducts(),
                    mockBundleData.getDiscountPercentage()
            );
        });

        mockBundleData.withDiscountPercentageGreaterThanOne();

        assertThrows(DomainConstraintException.class, () -> {
            Bundle.createNew(
                    mockBundleData.getName(),
                    mockBundleData.getProducts(),
                    mockBundleData.getDiscountPercentage()
            );
        });
    }

    @Test
    @DisplayName("[CORE][DOMAIN][BUNDLE] - should not create new bundle with invalid product quantity")
    void create_new_bundle_with_invalid_product_quantity() throws DomainConstraintException {
        var mockBundleData = MockBundle.generateMockData();

        // should not allow a bundle without products
        mockBundleData.withNoProducts();

        assertThrows(DomainConstraintException.class, () -> {
            Bundle.createNew(
                    mockBundleData.getName(),
                    mockBundleData.getProducts(),
                    mockBundleData.getDiscountPercentage()
            );
        });

        // should not allow a bundle with only one product
        mockBundleData.withOnlyOneProduct();

        assertThrows(DomainConstraintException.class, () -> {
            Bundle.createNew(
                    mockBundleData.getName(),
                    mockBundleData.getProducts(),
                    mockBundleData.getDiscountPercentage()
            );
        });
    }
}