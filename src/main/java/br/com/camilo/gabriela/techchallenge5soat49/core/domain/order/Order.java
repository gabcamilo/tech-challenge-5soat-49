package br.com.camilo.gabriela.techchallenge5soat49.core.domain.order;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.BaseDomain;
import br.com.camilo.gabriela.techchallenge5soat49.core.domain.customer.EventualCustomer;
import br.com.camilo.gabriela.techchallenge5soat49.core.domain.payment.Payment;
import br.com.camilo.gabriela.techchallenge5soat49.core.domain.payment.PaymentStatus;
import br.com.camilo.gabriela.techchallenge5soat49.core.domain.product.Product;
import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DomainConstraintException;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Order extends BaseDomain {
    @NotNull
    private final EventualCustomer customer;

    @Size(min = 1)
    private final List<OrderProduct> items;

    @NotNull
    private final Payment payment;

    @NotBlank
    private final PaymentStatus paymentStatus;

    private final String note;

    @NotNull
    private final BigDecimal total;

    private <T extends EventualCustomer> Order(String id, LocalDateTime createdAt, LocalDateTime updatedAt, T customer, List<OrderProduct> items, Payment payment, String note, BigDecimal total) throws DomainConstraintException {
        super(id, createdAt, updatedAt);
        this.customer = customer;
        this.items = items;
        this.payment = payment;
        this.paymentStatus = payment.getStatus();
        this.note = note;
        this.total = total;

        this.isValid();
    }

    public static <T extends EventualCustomer> Order createNew(T customer, List<OrderProduct> items, Payment payment, String note, BigDecimal total) throws DomainConstraintException {
        return new Order(null, LocalDateTime.now(), LocalDateTime.now(), customer, items, payment, note, total);
    }

    public Order update(Order order) throws DomainConstraintException {
        return new Order(
                getId(),
                getCreatedAt(),
                LocalDateTime.now(),
                this.customer,
                this.getItems(),
                order.getPayment(),
                this.note,
                this.total
        );
    }

    public EventualCustomer getCustomer() {
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

    public record OrderProduct(@NotNull Product product, @Min(1) Integer quantity, List<Product> addOns) {
        public OrderProduct(Product product, Integer quantity, List<Product> addOns) {
            this.product = product;
            this.quantity = quantity;
            this.addOns = addOns;
        }
    }
}
