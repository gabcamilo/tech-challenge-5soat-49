package br.com.camilo.gabriela.techchallenge5soat49.core.domain.order;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.BaseDomain;
import br.com.camilo.gabriela.techchallenge5soat49.core.domain.customer.Customer;
import br.com.camilo.gabriela.techchallenge5soat49.core.domain.payment.Payment;
import br.com.camilo.gabriela.techchallenge5soat49.core.domain.payment.PaymentStatus;
import br.com.camilo.gabriela.techchallenge5soat49.core.domain.product.Product;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class Order extends BaseDomain {

    private final Optional<Customer> customer;

    private final List<OrderProduct> items;

    private final Payment payment;

    private final PaymentStatus paymentStatus;

    private final String note;

    private final BigDecimal total;

    public Order(String id, LocalDateTime createdAt, LocalDateTime updatedAt, Optional<Customer> customer, List<OrderProduct> items, Payment payment, String note, BigDecimal total) {
        super(id, createdAt, updatedAt);
        this.customer = customer;
        this.items = items;
        this.payment = payment;
        this.paymentStatus = payment.getStatus();
        this.note = note;
        this.total = total;
    }

    public Order update(Order order) {
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

    public Optional<Customer> getCustomer() {
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
