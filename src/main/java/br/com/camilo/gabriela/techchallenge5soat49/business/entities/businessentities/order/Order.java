package br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.order;

import br.com.camilo.gabriela.techchallenge5soat49.business.entities.base.BaseDomain;
import br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.product.Product;
import br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.customer.Customer;
import br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.payment.Payment;
import br.com.camilo.gabriela.techchallenge5soat49.business.entities.businessentities.payment.PaymentStatus;
import br.com.camilo.gabriela.techchallenge5soat49.business.exceptions.DomainConstraintException;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class Order extends BaseDomain {
    private final Customer customer;

    @Size(min = 1)
    private final List<OrderProduct> items;

    @NotNull
    private final Payment payment;

    private final PaymentStatus paymentStatus;

    private final BigDecimal total;

    private Order(String id, LocalDateTime createdAt, LocalDateTime updatedAt, Customer customer, List<OrderProduct> items, Payment payment) throws DomainConstraintException {
        super(id, createdAt, updatedAt);
        this.customer = customer;
        this.items = items;
        this.payment = payment;
        this.total = calculateTotal(items);

        this.isValid();

        this.paymentStatus = payment.getStatus();
    }

    public static Order createNew(Customer customer, List<Product> products, HashMap<String, Integer> productsQuantity) throws DomainConstraintException {
        List<OrderProduct> items = products.stream().map(product -> {
            Integer quantity = productsQuantity.get(product.getId());
            if (quantity == null || quantity <= 0) {
                throw new IllegalArgumentException("Invalid quantity for product " + product.getId());
            }
            return new OrderProduct(product, quantity);
        }).toList();

        return new Order(null, LocalDateTime.now(), LocalDateTime.now(), customer, items, new Payment());
    }

    public static Order create(String id, LocalDateTime createdAt, LocalDateTime updatedAt, Customer customer, List<OrderProduct> items, Payment payment, String note) throws DomainConstraintException {
        return new Order(id, createdAt, updatedAt, customer, items, payment);
    }


    public Order update(Order order) throws DomainConstraintException {
        return new Order(
                getId(),
                getCreatedAt(),
                LocalDateTime.now(),
                this.customer,
                this.getProducts(),
                order.getPayment()
        );
    }

    private BigDecimal calculateTotal(List<OrderProduct> items) {
        BigDecimal total = BigDecimal.ZERO;
        for (OrderProduct item : items) {
            total = total.add(item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
        }
        return total;
    }

    public void payOrder() {
        this.payment.pay();
    }

    public void cancelOrder() {
        this.payment.reject();
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<OrderProduct> getProducts() {
        return items;
    }

    public Payment getPayment() {
        return payment;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public BigDecimal getTotal() {
        return total;
    }

}
