package br.com.camilo.gabriela.techchallenge5soat49.core.domain.order;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.customer.Customer;
import br.com.camilo.gabriela.techchallenge5soat49.core.domain.customer.MockCustomer;
import br.com.camilo.gabriela.techchallenge5soat49.core.domain.payment.Payment;
import br.com.camilo.gabriela.techchallenge5soat49.core.domain.payment.PaymentStatus;
import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DomainConstraintException;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import org.instancio.Instancio;
import org.instancio.settings.Keys;
import org.instancio.settings.Settings;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MockOrder {
    private String id;

    @PastOrPresent
    private LocalDateTime createdAt;

    @PastOrPresent
    private LocalDateTime updatedAt;

    private Customer customer;

    @Size(min = 1)
    private List<OrderProduct> items;

    @NotNull
    private Payment payment;

    @NotNull
    private PaymentStatus paymentStatus;

    private String note;

    @NotNull
    private BigDecimal total;

    private MockOrder() {
        throw new IllegalStateException("Utility class");
    }

    public static MockOrder generateMockData() throws DomainConstraintException {
        Customer customer = MockCustomer.generateValidCustomer();
        MockOrder mockOrder = Instancio.of(MockOrder.class)
                .withSettings(Settings.create().set(Keys.BEAN_VALIDATION_ENABLED, true))
                .create();
        mockOrder.setCustomer(customer);
        return mockOrder;
    }

    public static Order generateValidOrder() throws DomainConstraintException {
        MockOrder mockOrder = generateMockData();
        return Order.create(
                mockOrder.getId(),
                mockOrder.getCreatedAt(),
                mockOrder.getUpdatedAt(),
                mockOrder.getCustomer(),
                mockOrder.getItems(),
                mockOrder.getPayment(),
                mockOrder.getNote()
        );
    }

    public MockOrder whithZeroItems() {
        this.items = new ArrayList<>();
        return this;
    }

    public MockOrder withNoPaymentData() {
        this.payment = null;
        return this;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderProduct> getItems() {
        return items;
    }

    public Payment getPayment() {
        return payment;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public String getNote() {
        return note;
    }

    public BigDecimal getTotal() {
        return total;
    }
}
