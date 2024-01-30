package br.com.camilo.gabriela.techchallenge5soat49.core.domain.order;

import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DomainConstraintException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderTest {

    @Test
    @DisplayName("[CORE][DOMAIN][ORDER] - should not create order less than one item")
    void create_order_with_invalid_item_list() throws DomainConstraintException {
        var mockOrderData = MockOrder.generateMockData();

        //should not create order less than one item
        mockOrderData.whithZeroItems();

        assertThrows(DomainConstraintException.class, () -> {
            Order.create(
                    mockOrderData.getId(),
                    mockOrderData.getCreatedAt(),
                    mockOrderData.getUpdatedAt(),
                    mockOrderData.getCustomer(),
                    mockOrderData.getItems(),
                    mockOrderData.getPayment(),
                    mockOrderData.getNote(),
                    mockOrderData.getTotal()
            );
        });
    }

    @Test
    @DisplayName("[CORE][DOMAIN][ORDER] - should not create order with null payment")
    void create_order_with_null_payment() throws DomainConstraintException {
        var mockOrderData = MockOrder.generateMockData();

        //should not create order with null payment
        mockOrderData.withNoPaymentData();

        assertThrows(DomainConstraintException.class, () -> {
            Order.create(
                    mockOrderData.getId(),
                    mockOrderData.getCreatedAt(),
                    mockOrderData.getUpdatedAt(),
                    mockOrderData.getCustomer(),
                    mockOrderData.getItems(),
                    mockOrderData.getPayment(),
                    mockOrderData.getNote(),
                    mockOrderData.getTotal()
            );
        });
    }
}