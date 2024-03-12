package br.com.camilo.gabriela.techchallenge5soat49.business.entities.customer;

import br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.customer.Customer;
import br.com.camilo.gabriela.techchallenge5soat49.business.exceptions.DomainConstraintException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    @DisplayName("[CORE][DOMAIN][CUSTOMER] - should not create customer with invalid name")
    void create_customer_with_invalid_data_name() {
        var mockCustomerData = MockCustomer.generateMockData();

        // should not allow a customer without name
        mockCustomerData.withEmptyName();

        assertThrows(DomainConstraintException.class, () -> {
            Customer.create(
                    mockCustomerData.getId(),
                    mockCustomerData.getCreatedAt(),
                    mockCustomerData.getUpdatedAt(),
                    mockCustomerData.getName(),
                    mockCustomerData.getEmail(),
                    mockCustomerData.getCpf()
            );
        });

        mockCustomerData.withNullName();

        assertThrows(DomainConstraintException.class, () -> {
            Customer.create(
                    mockCustomerData.getId(),
                    mockCustomerData.getCreatedAt(),
                    mockCustomerData.getUpdatedAt(),
                    mockCustomerData.getName(),
                    mockCustomerData.getEmail(),
                    mockCustomerData.getCpf()
            );
        });
    }

    @Test
    @DisplayName("[CORE][DOMAIN][CUSTOMER] - should not create customer with invalid email")
    void create_customer_with_invalid_data_email() {
        var mockCustomerData = MockCustomer.generateMockData();

        // should not allow a customer without email
        // empty email
        mockCustomerData.withEmptyEmail();
        assertThrows(DomainConstraintException.class, () -> {
            Customer.create(
                    mockCustomerData.getId(),
                    mockCustomerData.getCreatedAt(),
                    mockCustomerData.getUpdatedAt(),
                    mockCustomerData.getName(),
                    mockCustomerData.getEmail(),
                    mockCustomerData.getCpf()
            );
        });
        // null email
        mockCustomerData.withNullEmail();
        assertThrows(DomainConstraintException.class, () -> {
            Customer.create(
                    mockCustomerData.getId(),
                    mockCustomerData.getCreatedAt(),
                    mockCustomerData.getUpdatedAt(),
                    mockCustomerData.getName(),
                    mockCustomerData.getEmail(),
                    mockCustomerData.getCpf()
            );
        });

        //should not allow a customer with invalid email
        mockCustomerData.withInvalidEmail();
        assertThrows(DomainConstraintException.class, () -> {
            Customer.create(
                    mockCustomerData.getId(),
                    mockCustomerData.getCreatedAt(),
                    mockCustomerData.getUpdatedAt(),
                    mockCustomerData.getName(),
                    mockCustomerData.getEmail(),
                    mockCustomerData.getCpf()
            );
        });
    }

    @Test
    @DisplayName("[CORE][DOMAIN][CUSTOMER] - should not create customer with invalid cpf")
    void create_customer_with_invalid_data_cpf() {
        var mockCustomerData = MockCustomer.generateMockData();

        // should not allow a customer without cpf
        // empty cpf
        mockCustomerData.withEmptyCpf();
        assertThrows(DomainConstraintException.class, () -> {
            Customer.create(
                    mockCustomerData.getId(),
                    mockCustomerData.getCreatedAt(),
                    mockCustomerData.getUpdatedAt(),
                    mockCustomerData.getName(),
                    mockCustomerData.getEmail(),
                    mockCustomerData.getCpf()
            );
        });
        // null cpf
        mockCustomerData.withNullCpf();
        assertThrows(DomainConstraintException.class, () -> {
            Customer.create(
                    mockCustomerData.getId(),
                    mockCustomerData.getCreatedAt(),
                    mockCustomerData.getUpdatedAt(),
                    mockCustomerData.getName(),
                    mockCustomerData.getEmail(),
                    mockCustomerData.getCpf()
            );
        });

        //should not allow a customer with invalid cpf
        mockCustomerData.withInvalidCpf();
        assertThrows(DomainConstraintException.class, () -> {
            Customer.create(
                    mockCustomerData.getId(),
                    mockCustomerData.getCreatedAt(),
                    mockCustomerData.getUpdatedAt(),
                    mockCustomerData.getName(),
                    mockCustomerData.getEmail(),
                    mockCustomerData.getCpf()
            );
        });
    }

    @Test
    @DisplayName("[CORE][DOMAIN][CUSTOMER] - should update only updatable fields to valid values")
    void update_customer() throws DomainConstraintException {
        var formerCustomerData = MockCustomer.generateValidCustomer();
        var customerDataToUpdate = MockCustomer.generateValidCustomer();

        Customer result = formerCustomerData.update(customerDataToUpdate);

        /* should NOT be updated
         * - id
         * - createdAt
         * - cpf
         * ******************************/


        // id
        assertEquals(formerCustomerData.getId(), result.getId());
        assertNotEquals(customerDataToUpdate.getId(), result.getId());

        // createdAt
        assertEquals(formerCustomerData.getCreatedAt(), result.getCreatedAt());
        assertNotEquals(customerDataToUpdate.getCreatedAt(), result.getCreatedAt());

        // cpf
        assertEquals(formerCustomerData.getCpf(), result.getCpf());
        assertNotEquals(customerDataToUpdate.getCpf(), result.getCpf());

        /* should be updated
         * - updatedAt
         * - name
         * - email
         * ******************************/

        // updatedAt should be updated to new update time
        assertTrue(result.getUpdatedAt().isBefore(LocalDateTime.now())); //before now
        assertTrue(result.getUpdatedAt().isAfter(formerCustomerData.getUpdatedAt())); //after previous value
        assertNotEquals(customerDataToUpdate.getUpdatedAt(), result.getUpdatedAt()); //different from updated data value (should be changed based on update time and not updated data value)
        assertNotEquals(formerCustomerData.getUpdatedAt(), result.getUpdatedAt()); //different from previous value

        // name
        assertEquals(customerDataToUpdate.getName(), result.getName());
        assertNotEquals(formerCustomerData.getName(), result.getName());

        // email
        assertEquals(customerDataToUpdate.getEmail(), result.getEmail());
        assertNotEquals(formerCustomerData.getEmail(), result.getEmail());
    }

    @Test
    @DisplayName("[CORE][DOMAIN][CUSTOMER] - should create new customer with null id")
    void create_new_customer_with_null_id() throws DomainConstraintException {
        var mockCustomerData = MockCustomer.generateMockData();

        Customer result = Customer.createNew(
                mockCustomerData.getName(),
                mockCustomerData.getEmail(),
                mockCustomerData.getCpf()
        );

        assertNull(result.getId());
    }

    @Test
    @DisplayName("[CORE][DOMAIN][CUSTOMER] - should not create new customer with invalid name")
    void create_new_customer_with_invalid_data_name() {
        var mockCustomerData = MockCustomer.generateMockData();

        // should not allow a customer without name
        mockCustomerData.withEmptyName();

        assertThrows(DomainConstraintException.class, () -> {
            Customer.createNew(
                    mockCustomerData.getName(),
                    mockCustomerData.getEmail(),
                    mockCustomerData.getCpf()
            );
        });

        mockCustomerData.withNullName();

        assertThrows(DomainConstraintException.class, () -> {
            Customer.createNew(
                    mockCustomerData.getName(),
                    mockCustomerData.getEmail(),
                    mockCustomerData.getCpf()
            );
        });
    }

    @Test
    @DisplayName("[CORE][DOMAIN][CUSTOMER] - should not create new customer with invalid email")
    void create_new_customer_with_invalid_data_email() {
        var mockCustomerData = MockCustomer.generateMockData();

        // should not allow a customer without email
        // empty email
        mockCustomerData.withEmptyEmail();
        assertThrows(DomainConstraintException.class, () -> {
            Customer.createNew(
                    mockCustomerData.getName(),
                    mockCustomerData.getEmail(),
                    mockCustomerData.getCpf()
            );
        });
        // null email
        mockCustomerData.withNullEmail();
        assertThrows(DomainConstraintException.class, () -> {
            Customer.createNew(
                    mockCustomerData.getName(),
                    mockCustomerData.getEmail(),
                    mockCustomerData.getCpf()
            );
        });

        //should not allow a customer with invalid email
        mockCustomerData.withInvalidEmail();
        assertThrows(DomainConstraintException.class, () -> {
            Customer.createNew(
                    mockCustomerData.getName(),
                    mockCustomerData.getEmail(),
                    mockCustomerData.getCpf()
            );
        });
    }

    @Test
    @DisplayName("[CORE][DOMAIN][CUSTOMER] - should not create new customer with invalid cpf")
    void create_new_customer_with_invalid_data_cpf() {
        var mockCustomerData = MockCustomer.generateMockData();

        // should not allow a customer without cpf
        // empty cpf
        mockCustomerData.withEmptyCpf();
        assertThrows(DomainConstraintException.class, () -> {
            Customer.createNew(
                    mockCustomerData.getName(),
                    mockCustomerData.getEmail(),
                    mockCustomerData.getCpf()
            );
        });
        // null cpf
        mockCustomerData.withNullCpf();
        assertThrows(DomainConstraintException.class, () -> {
            Customer.createNew(
                    mockCustomerData.getName(),
                    mockCustomerData.getEmail(),
                    mockCustomerData.getCpf()
            );
        });

        //should not allow a customer with invalid cpf
        mockCustomerData.withInvalidCpf();
        assertThrows(DomainConstraintException.class, () -> {
            Customer.createNew(
                    mockCustomerData.getName(),
                    mockCustomerData.getEmail(),
                    mockCustomerData.getCpf()
            );
        });
    }
}
