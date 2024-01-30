package br.com.camilo.gabriela.techchallenge5soat49.core.domain.order;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.BaseDomain;
import br.com.camilo.gabriela.techchallenge5soat49.core.domain.customer.Customer;
import br.com.camilo.gabriela.techchallenge5soat49.core.domain.customer.EventualCustomer;
import br.com.camilo.gabriela.techchallenge5soat49.core.domain.payment.Payment;
import br.com.camilo.gabriela.techchallenge5soat49.core.domain.payment.PaymentStatus;
import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DomainConstraintException;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Order extends BaseDomain {
    private final Customer customer;

    private final EventualCustomer eventualCustomer;

    @Size(min = 1)
    private final List<OrderProduct> items;

    @NotNull
    private final Payment payment;

    private final PaymentStatus paymentStatus;

    private final String note;

    private final BigDecimal total;

    private Order(String id, LocalDateTime createdAt, LocalDateTime updatedAt, Customer customer, EventualCustomer eventualCustomer, List<OrderProduct> items, Payment payment, String note, BigDecimal total) throws DomainConstraintException {
        super(id, createdAt, updatedAt);
        this.customer = customer;
        this.eventualCustomer = eventualCustomer;
        this.items = items;
        this.payment = payment;
        this.note = note;
        this.total = total;

        this.isValid();

        this.paymentStatus = payment.getStatus();
    }

    public static Order createNewEventual(EventualCustomer eventualCustomer, List<OrderProduct> items, Payment payment, String note, BigDecimal total) throws DomainConstraintException {
        return new Order(null, LocalDateTime.now(), LocalDateTime.now(), null, eventualCustomer, items, payment, note, total);
    }

    public static Order createNew(Customer customer, List<OrderProduct> items, Payment payment, String note, BigDecimal total) throws DomainConstraintException {
        return new Order(null, LocalDateTime.now(), LocalDateTime.now(), customer, null, items, payment, note, total);
    }

    public static Order create(String id, LocalDateTime createdAt, LocalDateTime updatedAt, Customer customer, List<OrderProduct> items, Payment payment, String note, BigDecimal total) throws DomainConstraintException {
        return new Order(null, LocalDateTime.now(), LocalDateTime.now(), customer, null, items, payment, note, total);
    }

    public static Order createEventual(String id, LocalDateTime createdAt, LocalDateTime updatedAt, EventualCustomer eventualCustomer, List<OrderProduct> items, Payment payment, String note, BigDecimal total) throws DomainConstraintException {
        return new Order(null, LocalDateTime.now(), LocalDateTime.now(), null, eventualCustomer, items, payment, note, total);
    }

    public Order update(Order order) throws DomainConstraintException {
        return new Order(
                getId(),
                getCreatedAt(),
                LocalDateTime.now(),
                this.customer,
                null,
                this.getItems(),
                order.getPayment(),
                this.note,
                this.total
        );
    }

    public Customer getCustomer() {
        return customer;
    }

    public EventualCustomer getEventualCustomer() {
        return eventualCustomer;
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
