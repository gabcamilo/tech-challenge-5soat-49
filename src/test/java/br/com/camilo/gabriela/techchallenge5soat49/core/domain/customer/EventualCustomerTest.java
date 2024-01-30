package br.com.camilo.gabriela.techchallenge5soat49.core.domain.customer;

import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DomainConstraintException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EventualCustomerTest {
    @Test
    @DisplayName("[CORE][DOMAIN][EVENTUAL CUSTOMER] - should not create customer with invalid name")
    void create_eventual_customer_with_invalid_data_name() {
        var mockCustomerData = MockEventualCustomer.generateMockData();

        // should not allow a customer without name
        mockCustomerData.withEmptyName();

        assertThrows(DomainConstraintException.class, () -> {
            EventualCustomer.create(
                    mockCustomerData.getName()
            );
        });

        mockCustomerData.withNullName();

        assertThrows(DomainConstraintException.class, () -> {
            EventualCustomer.create(
                    mockCustomerData.getName()
            );
        });
    }

    @Test
    @DisplayName("[CORE][DOMAIN][EVENTUAL CUSTOMER] - id should be null on eventual customers")
    void id_should_be_null_on_eventual_customers() throws DomainConstraintException {
        var mockCustomerData = MockEventualCustomer.generateMockData();

        EventualCustomer response = EventualCustomer.create(mockCustomerData.getName());
        assertNull(response.getId());
    }
}
