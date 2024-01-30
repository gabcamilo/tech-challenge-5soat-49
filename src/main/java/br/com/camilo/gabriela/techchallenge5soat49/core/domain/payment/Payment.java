package br.com.camilo.gabriela.techchallenge5soat49.core.domain.payment;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.BaseDomain;
import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DomainConstraintException;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class Payment extends BaseDomain {

    @NotBlank
    private final PaymentStatus status;

    private Payment(String id, LocalDateTime createdAt, LocalDateTime updatedAt, PaymentStatus status) throws DomainConstraintException {
        super(id, createdAt, updatedAt);
        this.status = status;

        this.isValid();
    }

    public static Payment createNew() throws DomainConstraintException {
        return new Payment(null, LocalDateTime.now(), LocalDateTime.now(), PaymentStatus.PENDING);
    }

    public static Payment create(String id,
                                 LocalDateTime createdAt,
                                 LocalDateTime updatedAt,
                                 PaymentStatus status) throws DomainConstraintException {
        return new Payment(id, createdAt, updatedAt, status);
    }

    public Payment update(Payment payment) throws DomainConstraintException {
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
