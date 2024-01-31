package br.com.camilo.gabriela.techchallenge5soat49.core.domain.payment;

import br.com.camilo.gabriela.techchallenge5soat49.core.domain.BaseDomain;
import br.com.camilo.gabriela.techchallenge5soat49.core.exceptions.DomainConstraintException;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class Payment {

    @NotBlank
    private PaymentStatus status;

    public Payment(){
        this.status = PaymentStatus.PENDING;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void pay(){
        this.status = PaymentStatus.APPROVED;
    }

    public void reject(){
        this.status = PaymentStatus.REJECTED;
    }

}
