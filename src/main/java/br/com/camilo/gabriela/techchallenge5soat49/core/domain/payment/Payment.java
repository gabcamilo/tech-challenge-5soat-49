package br.com.camilo.gabriela.techchallenge5soat49.core.domain.payment;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.BaseDomain;

import java.time.LocalDateTime;

public class Payment extends BaseDomain {
    private final PaymentStatus status;

    protected Payment(String id, LocalDateTime createdAt, LocalDateTime updatedAt, PaymentStatus status) {
        super(id, createdAt, updatedAt);
        this.status = status;
    }

    public Payment update(Payment payment) {
        return new Payment(
                getId(),
                getCreatedAt(),
                LocalDateTime.now(),
                payment.getStatus()
        );
    }

    public PaymentStatus getStatus() {
        return status;
    }
}
